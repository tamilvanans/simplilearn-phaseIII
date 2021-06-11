package com.simplilearn.sportyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.sportyshoes.vo.PurchaseVO;

@Repository
public interface PurchaseRepository extends JpaRepository<PurchaseVO, Integer> {
}
