package com.leejx2.accountbook.session.controller;

import java.sql.Timestamp;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.leejx2.accountbook.common.Constants;
import com.leejx2.accountbook.rest.model.User;
import com.leejx2.accountbook.rest.service.UserService;
import com.leejx2.accountbook.session.model.SessionUser;
import com.leejx2.accountbook.session.service.LoginService;

@RestController
public class SessionController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/login")
	public SessionUser login(HttpSession session, @RequestBody Map<String, String> params) {
		// 초기화
		if (!session.isNew()) {
			session.invalidate();
		}
		
		SessionUser sessionUser = new SessionUser();
		
		String loginId = params.getOrDefault("loginId", "");
		String passwd = params.getOrDefault("passwd", "");
		
		// 사용자 체크
		User user = userService.getUser(loginId);
		if (user == null) {
			sessionUser.setLoginFailMessage(Constants.LOGIN_FAIL_USER_NOT_FOUND);
			return sessionUser;
		}
		
		// 사용자 인증
		sessionUser = loginService.authenticate(sessionUser, user, passwd);
		
		if (Constants.LOGIN_RESULT_SUCCESS.equals(sessionUser.getLoginResult())) {
			sessionUser.setJSEESIONID(session.getId());
			sessionUser.setSessionStatus(Constants.SESSION_STATUS_VALID);
			sessionUser.setCreationDate(new Timestamp(session.getCreationTime()));
			
			session.setAttribute(Constants.SESSION_KEY_USER, sessionUser);
			session.setAttribute(Constants.SESSION_KEY_LOGINID, sessionUser.getLoginId());
		}
		
		return sessionUser;
	}
	
	@PostMapping("/session")
	public boolean session(HttpSession session, @RequestBody Map<String, String> params) {
		String loginId = params.getOrDefault("loginId", "");
		SessionUser sessionUser = (SessionUser) session.getAttribute(Constants.SESSION_KEY_USER);
		String sessionLoginId = (String) session.getAttribute(Constants.SESSION_KEY_LOGINID);
		
		session.invalidate();
		if (!loginId.equals(sessionLoginId) || sessionUser == null) {
			
			return false;
		} else {
			User user = userService.getUser(loginId);
			sessionUser = (SessionUser) user;
			sessionUser.setLoginResult(Constants.LOGIN_RESULT_SUCCESS);
			sessionUser.setLoginFailMessage("");
			sessionUser.setJSEESIONID(session.getId());
			sessionUser.setSessionStatus(Constants.SESSION_STATUS_VALID);
			sessionUser.setCreationDate(new Timestamp(session.getCreationTime()));
			
			session.setAttribute(Constants.SESSION_KEY_USER, sessionUser);
			session.setAttribute(Constants.SESSION_KEY_LOGINID, sessionUser.getLoginId());
		}
		
		return true;
	}
}
