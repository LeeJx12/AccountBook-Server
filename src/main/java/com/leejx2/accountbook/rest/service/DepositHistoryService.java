package com.leejx2.accountbook.rest.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leejx2.accountbook.rest.mapper.DepositHistoryMapper;
import com.leejx2.accountbook.rest.model.DepositHistory;

@Service
public class DepositHistoryService {

	@Autowired
	private DepositHistoryMapper depositHistoryMapper;
	
	/**
	 * 입출금 내역 전체 조회
	 * @param depositId
	 * @return
	 */
	public List<DepositHistory> getDepositHistory(String depositId) {
		return depositHistoryMapper.queryDepositHistory(depositId);
	}
	
	/**
	 * 입출금 내역 단건 조회
	 * @param depositId
	 * @param historyId
	 * @return
	 */
	public DepositHistory getDepositHistory(String depositId, String historyId) {
		return depositHistoryMapper.selectDepositHistory(depositId, historyId);
	}
	
	/**
	 * 입출금 내역 입력
	 * @param depositHistory
	 */
	@Transactional
	public void addDepositHistory(DepositHistory depositHistory) {
		depositHistory.setHitoryId(UUID.randomUUID().toString());
		depositHistoryMapper.insertDepositHistory(depositHistory);
	}
	
	/**
	 * 입출금 내역 수정
	 * @param depositHistory
	 */
	@Transactional
	public void editDepositHistory(DepositHistory depositHistory) {
		depositHistoryMapper.updateDepositHistory(depositHistory);
	}
	
	/**
	 * 입출금 내역 삭제
	 * @param depositHistory
	 */
	@Transactional
	public void delDepositHistory(DepositHistory depositHistory) {
		depositHistoryMapper.deleteDepositHistory(depositHistory);
	}
}
