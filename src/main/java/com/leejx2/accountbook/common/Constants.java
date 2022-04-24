package com.leejx2.accountbook.common;

public class Constants {

	/**
	 * 세션 상태
	 */
	public static final String SESSION_STATUS_VALID = "SESSION_STATUS_VALID";
	public static final String SESSION_STATUS_INVALID = "SESSION_STATUS_INVALID";
	
	/**
	 * 로그인 결과 및 실패 메시지
	 */
	public static final String LOGIN_RESULT_SUCCESS = "LOGIN_RESULT_SUCCESS";
	public static final String LOGIN_RESULT_FAIL = "LOGIN_RESULT_FAIL";
	
	public static final String LOGIN_FAIL_USER_NOT_FOUND = "LOGIN_FAIL_USER_NOT_FOUND";
	public static final String LOGIN_FAIL_AUTH_FAIL = "LOGIN_FAIL_AUTH_FAIL";
	public static final String LOGIN_FAIL_ERROR = "LOGIN_FAIL_ERROR";
	
	/**
	 * HttpSession keys
	 */
	public static final String SESSION_KEY_USER = "SESSION_KEY_USER";
	public static final String SESSION_KEY_LOGINID = "SESSION_KEY_LOGINID";
}
