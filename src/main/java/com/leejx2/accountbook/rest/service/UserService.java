package com.leejx2.accountbook.rest.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leejx2.accountbook.common.util.Encryptor;
import com.leejx2.accountbook.rest.mapper.UserMapper;
import com.leejx2.accountbook.rest.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 전체 사용자 조회
	 * @return
	 */
	public List<User> getUsers() {
		return userMapper.queryUsers();
	}
	
	/**
	 * 특정 사용자 조회
	 * @param loginId
	 * @return
	 */
	public User getUser(String loginId) {
		return userMapper.selectUser(loginId);
	}
	
	/**
	 * 사용자 생성
	 * @param user
	 */
	@Transactional
	public void addUser(User user) {
		user.setUserId(UUID.randomUUID().toString());
		user.setPasswd(Encryptor.encrypt(user.getPasswd()));
		userMapper.insertUser(user);
	}
	
	/**
	 * 사용자 설정 변경
	 * @param user
	 */
	@Transactional
	public void setUserConfig(User user) {
		userMapper.updateUser(user);
	}
	
	/**
	 * 사용자 삭제
	 * @param user
	 */
	@Transactional
	public void delUser(User user) {
		userMapper.deleteUser(user);
	}
}
