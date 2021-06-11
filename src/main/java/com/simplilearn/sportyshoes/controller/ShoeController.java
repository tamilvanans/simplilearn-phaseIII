package com.simplilearn.sportyshoes.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.StringTokenizer;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.simplilearn.sportyshoes.service.ShoeService;
import com.simplilearn.sportyshoes.vo.PurchaseVO;
import com.simplilearn.sportyshoes.vo.ShoeVO;
import com.simplilearn.sportyshoes.vo.UserVO;

@Controller
public class ShoeController {

	@Autowired
	private ShoeService shoeService;
	
	@GetMapping("/Welcome")
	public String welcome() {
		return "Login";
	}
	
	@PostMapping("/ValidateLogin")
	public String doLoginValidation(Model model, @RequestParam(value="username") String username, 
			@RequestParam(value="password") String password) {
		if(username.equals("admin")) {
			return "ShoeMaintenance";
		} else {
			UserVO userVo = shoeService.checkValidLogin(username,password);
			if(userVo != null) {
				List<ShoeVO> shoeList = shoeService.findAllShoes();
				model.addAttribute("ShoeMaster", shoeList);
				model.addAttribute("UserId", userVo.getUserId());
				return "ShoeShopping";
			} else {
				return "UserProfiling";	
			}
		}
	}
	
	@PostMapping("/doShopping")
	public String doShoppingValidation(HttpSession session, Model model, @RequestParam(value = "action", required = false) String operation, 
			@RequestParam(value = "count", required = false) String count,
			@RequestParam(value = "userId", required = false) String userId) {

		HashMap<Integer,Integer> purchaseDetails = new HashMap<>();
		if("Checkout".equals(operation)) {
			if(count != null) {
				Iterator<Object> iterate = new StringTokenizer(count,",").asIterator();
				while(iterate.hasNext()){
					String value = (String) iterate.next();
					System.out.println(value);
					if(!value.startsWith("0")) {
						purchaseDetails.put(Integer.parseInt(value.substring(value.indexOf("-")+1)), 
							Integer.parseInt(value.substring(0, value.indexOf("-"))));
					}
				}
			}
			PurchaseVO purchaseVo = shoeService.doPurchase(purchaseDetails,userId);
			model.addAttribute("Purchase", purchaseVo);
			model.addAttribute("PurchaseDetails", purchaseDetails);
			session.setAttribute("Purchase", purchaseVo);
			session.setAttribute("PurchaseDetails", purchaseDetails);
			if(purchaseVo.getPurchaseAmount() > 0) {
				return "ShoePayment";
			} else {
				return "InvalidCheckout";
			}
		} else {
			return "SuccessMaintain";
		}
	}
	
	@PostMapping("/doPayment")
	public String doPaymentConfirmation(HttpSession session, Model model, @RequestParam(value = "action", required = false) String operation) {
		PurchaseVO purchaseVo = (PurchaseVO) session.getAttribute("Purchase");
		HashMap<Integer,Integer> purchaseDetails = (HashMap<Integer,Integer>) session.getAttribute("PurchaseDetails");
		if("Payment".equals(operation)) {
			shoeService.save(purchaseVo,purchaseDetails);
			return "PaymentSuccess";
		} else {
			return "CancelPayment";
		}
		
	}
	
	@PostMapping("/MaintainUser")
	public String persistUserDetails(@ModelAttribute UserVO userVo) {
		shoeService.persistUser(userVo);
		return "SuccessMaintain";
	}
	
	@GetMapping("/ManageShoes")
	public String doManageShoes(Model model, @RequestParam(value = "action", required = false) String operation, 
			@RequestParam(value = "shoeId", required = false) String shoeId) {
		List<ShoeVO> shoeList = shoeService.findAllShoes();
		model.addAttribute("ShoeMaster", shoeList);
		if("AddMod".equals(operation)){
			Optional<ShoeVO> shoe = shoeService.findByShoeId(shoeId);
			model.addAttribute("ShoeData", shoe);
			return "ShoeMasterMaint";
		} else if("Delete".equals(operation)){
			shoeService.deleteByShoeId(shoeId);
			shoeList = shoeService.findAllShoes();
			model.addAttribute("ShoeMaster", shoeList);
			return "ShoeMasterView";
		} else {
			return "ShoeMasterView";
		}
	}
	
	@GetMapping("/ListUser")
	public String generateUserList(Model model) {
		List<UserVO> userList = shoeService.findAllUsers();
		model.addAttribute("UserList",userList);
		return "UserListView";
	}
	
	@GetMapping("/PurchaseReport")
	public String generateReport(Model model) {
		List<PurchaseVO> purchaseList = shoeService.findAllPurchases();
		model.addAttribute("PurchaseList",purchaseList);
		return "Report";
	}
	
	@GetMapping(value="/doShoeMaint")
	public String doMastShoeMaint(@RequestParam("shoeId") String shoeId, 
			@RequestParam("shoeName") String shoeName,
			@RequestParam("shoeCount") String shoeCount,
			@RequestParam("shoeCost") String shoeCost,
			@RequestParam("shoeDesc") String shoeDesc) {
		ShoeVO shoeVO = new ShoeVO();
		if(shoeId != null) {
			shoeVO.setShoeId(Integer.parseInt(shoeId));
		}
		shoeVO.setShoeName(shoeName);
		shoeVO.setShoeCount(shoeCount);
		shoeVO.setShoeCost(shoeCost);
		shoeVO.setShoeDetail(shoeDesc);
		shoeService.save(shoeVO);
		return "SuccessMaintain";
	}
	
}
