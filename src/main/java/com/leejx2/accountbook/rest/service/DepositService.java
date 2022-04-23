package com.leejx2.accountbook.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leejx2.accountbook.rest.mapper.DepositMapper;
import com.leejx2.accountbook.rest.model.Deposit;

@Service
public class DepositService {

	@Autowired
	private DepositMapper depositMapper;
	
	/**
	 * 사용자의 예적금 계좌 전체 조회
	 * @return
	 */
	public List<Deposit> getUserDeposits(String userId) {
		return depositMapper.queryDeposits();
	}
	
	/**
	 * 사용자의 예적금 계좌 조회
	 * @param userId
	 * @param depositId
	 * @return
	 */
	public Deposit getUserDeposit(String userId, String depositId) {
		return depositMapper.selectDeposit(userId, depositId);
	}
	
	/**
	 * 계좌 정보 입력
	 * @param deposit
	 */
	@Transactional
	public void addDeposit(Deposit deposit) {
		depositMapper.insertDeposit(deposit);
	}
	
	/**
	 * 계좌 정보 수정
	 * @param deposit
	 */
	@Transactional
	public void editDeposit(Deposit deposit) {
		depositMapper.updateDeposit(deposit);
	}
	
	/**
	 * 계좌 총액 업데이트
	 * @param amount
	 */
	@Transactional
	public void editDepositTotalAmount(int amount) {
		depositMapper.updateDepositTotalAmount(amount);
	}
	
	/**
	 * 계좌 삭제
	 * @param deposit
	 */
	@Transactional
	public void delDeposit(Deposit deposit) {
		depositMapper.deleteDeposit(deposit);
	}
}
