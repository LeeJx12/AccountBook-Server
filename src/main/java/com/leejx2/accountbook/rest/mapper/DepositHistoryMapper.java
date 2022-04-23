package com.leejx2.accountbook.rest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.leejx2.accountbook.rest.model.DepositHistory;

@Repository
@Mapper
public interface DepositHistoryMapper {

	/**
	 * 입출금 내역 전체 조회
	 * @param depositId
	 * @return
	 */
	List<DepositHistory> queryDepositHistory(String depositId);
	
	/**
	 * 입출금 내역 단건 조회
	 * @param depositId
	 * @param historyId
	 * @return
	 */
	DepositHistory selectDepositHistory(String depositId, String historyId);
	
	/**
	 * 입출금 내역 입력
	 * @param depositHistory
	 */
	void insertDepositHistory(DepositHistory depositHistory);
	
	/**
	 * 입출금 내역 수정
	 * @param depositHistory
	 */
	void updateDepositHistory(DepositHistory depositHistory);
	
	/**
	 * 입출금 내역 삭제
	 * @param depositHistory
	 */
	void deleteDepositHistory(DepositHistory depositHistory);
}
