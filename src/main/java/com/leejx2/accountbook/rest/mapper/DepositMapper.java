package com.leejx2.accountbook.rest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.leejx2.accountbook.rest.model.Deposit;

@Repository
@Mapper
public interface DepositMapper {
	
	/**
	 * 사용자의 예적금 계좌 전체 조회
	 * @return
	 */
	List<Deposit> queryDeposits();
	
	/**
	 * 사용자의 예적금 계좌 조회
	 * @param userId
	 * @param depositId
	 * @return
	 */
	Deposit selectDeposit(String userId, String depositId);
	
	/**
	 * 계좌 정보 입력
	 * @param deposit
	 */
	@Transactional
	void insertDeposit(Deposit deposit);
	
	/**
	 * 계좌 정보 수정
	 * @param deposit
	 */
	@Transactional
	void updateDeposit(Deposit deposit);
	
	/**
	 * 계좌 총액 업데이트
	 * @param amount
	 */
	@Transactional
	void updateDepositTotalAmount(int amount);
	
	/**
	 * 계좌 삭제
	 * @param deposit
	 */
	@Transactional
	void deleteDeposit(Deposit deposit);
}
