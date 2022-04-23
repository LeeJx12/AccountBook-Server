package com.leejx2.accountbook.rest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.leejx2.accountbook.rest.model.User;

@Repository
@Mapper
public interface UserMapper {

	/**
	 * 전체 사용자 조회
	 * @return
	 */
	List<User> queryUsers();
	
	/**
	 * 특정 사용자 조회
	 * @param loginId
	 * @return
	 */
	User selectUser(String loginId);
	
	/**
	 * 사용자 생성
	 * @param user
	 */
	void insertUser(User user);
	
	/**
	 * 사용자 설정 변경
	 * @param user
	 */
	void updateUser(User user);
	
	/**
	 * 사용자 삭제
	 * @param user
	 */
	void deleteUser(User user);
}
