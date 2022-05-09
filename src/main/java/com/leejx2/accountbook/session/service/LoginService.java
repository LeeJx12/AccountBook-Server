package com.leejx2.accountbook.session.service;

import org.springframework.stereotype.Service;

import com.leejx2.accountbook.common.Constants;
import com.leejx2.accountbook.common.util.Encryptor;
import com.leejx2.accountbook.rest.model.User;
import com.leejx2.accountbook.session.model.SessionUser;

@Service
public class LoginService {

	/**
	 * password 인증
	 * @param sessionUser
	 * @param user
	 * @param passwd
	 * @return
	 */
	public SessionUser authenticate(SessionUser sessionUser, User user, String passwd) {
		// password 처리
		String encPasswd = "";
		try {
			encPasswd = Encryptor.base64Decode(passwd);
			encPasswd = Encryptor.aesDecrypt(encPasswd);
			encPasswd = Encryptor.encrypt(encPasswd);
		} catch(Exception e) {
			//TODO: 로깅처리, exception 처리 추가할것!
			return sessionUser;
		}
		if (!user.getPasswd().equals(encPasswd)) {
			sessionUser.setLoginFailMessage(Constants.LOGIN_FAIL_AUTH_FAIL);
		} else {
			sessionUser = (SessionUser) user;
			sessionUser.setLoginResult(Constants.LOGIN_RESULT_SUCCESS);
			sessionUser.setLoginFailMessage("");
		}
		return sessionUser;
	}
}
