package com.simplilearn.sportyshoes.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.sportyshoes.repository.PurchaseRepository;
import com.simplilearn.sportyshoes.repository.ShoeRepository;
import com.simplilearn.sportyshoes.repository.UserRepository;
import com.simplilearn.sportyshoes.vo.PurchaseVO;
import com.simplilearn.sportyshoes.vo.ShoeVO;
import com.simplilearn.sportyshoes.vo.UserVO;

@Service
public class ShoeService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ShoeRepository shoeRepository;
	
	@Autowired
	PurchaseRepository purchaseRepository;
	
	public UserVO checkValidLogin(String username, String password) {
		List<UserVO> listUser = userRepository.findByUserNameAndPassWord(username, password);
		if(listUser.size() > 0) {
			return listUser.get(0);
		} else {
			return null;
		}
	}

	public void persistUser(String firstName, String lastName, String eMailID, String mobileNumber, String addressLine1,
			String addressLine2, String addressLine3, String addressLine4, String addressLine5,String userName, String passWord) {
		UserVO user = new UserVO();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setemailId(eMailID);
		user.setMobileNumber(mobileNumber);
		user.setAddressLine1(addressLine1);
		user.setAddressLine2(addressLine2);
		user.setAddressLine3(addressLine3);
		user.setAddressLine4(addressLine4);
		user.setAddressLine5(addressLine5);
		user.setUserName(userName);
		user.setPassWord(passWord);;
		userRepository.save(user);
	}
	
	public void persistUser(UserVO userVo) {
		userRepository.save(userVo);
	}

	public List<ShoeVO> findAllShoes() {
		return shoeRepository.findAll();
	}
	
	public List<UserVO> findAllUsers() {
		return userRepository.findAll();
	}
	
	public List<PurchaseVO> findAllPurchases() {
		return purchaseRepository.findAll();
	}

	public Optional<ShoeVO> findByShoeId(String shoeId) {
		return shoeRepository.findById(Integer.valueOf(shoeId == null ? "0" : shoeId));
		
	}

	public void deleteByShoeId(String shoeId) {
		shoeRepository.deleteById(Integer.valueOf(shoeId));
	}

	public void save(ShoeVO shoeVO) {
		shoeRepository.save(shoeVO);
	}

	public PurchaseVO doPurchase(HashMap<Integer, Integer> purchaseDetails, String userId) {
		int purchaseAmount = 0;
		Set<ShoeVO> purchaseSet = new HashSet<>();
		Set<Entry<Integer,Integer>> shoeSet = purchaseDetails.entrySet();
		for(Entry<Integer,Integer> shoeEntry : shoeSet) {
			Optional<ShoeVO> optShoeVo = shoeRepository.findById(shoeEntry.getKey());
			if(optShoeVo.isPresent()) {
				ShoeVO shoeVo = optShoeVo.get();
				purchaseSet.add(shoeVo);
				purchaseAmount += Integer.parseInt(shoeVo.getShoeCost())*(int)shoeEntry.getValue();
			}
		}
		PurchaseVO purchaseVo = new PurchaseVO();
		purchaseVo.setPurchaseAmount(purchaseAmount);
		purchaseVo.setShoes(purchaseSet);
		Optional<UserVO> optUserVo = userRepository.findById(Integer.parseInt(userId));
		if(optUserVo.isPresent()) {
			System.out.println("user:"+optUserVo.get().getUserId());
			purchaseVo.setUser(optUserVo.get());
		}
		//purchaseRepository.save(purchaseVo);
		return purchaseVo;
	}

	public void save(PurchaseVO purchaseVo, HashMap<Integer, Integer> purchaseDetails) {
		Set<Entry<Integer,Integer>> shoeSet = purchaseDetails.entrySet();
		for(Entry<Integer,Integer> shoeEntry : shoeSet) {
			Optional<ShoeVO> optShoeVo = shoeRepository.findById(shoeEntry.getKey());
			if(optShoeVo.isPresent()) {
				ShoeVO shoeVo = optShoeVo.get();
				int beforeCount = Integer.parseInt(shoeVo.getShoeCount());
				int afterCount = beforeCount - (int)shoeEntry.getValue();
				shoeVo.setShoeCount(String.valueOf(afterCount));
				shoeRepository.save(shoeVo);
			}
		}
		purchaseRepository.save(purchaseVo);
	}
	
}
