package com.leejx2.accountbook.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Encryptor {
	
	/**
	 * 단방향 암호화(MD5 사용)
	 * @param pwd
	 * @return
	 */
	public static String encrypt(String pwd) {
		String MD5 = "";
	    try {
	        MessageDigest md = MessageDigest.getInstance("MD5");
	        md.update(pwd.getBytes());
	        byte byteData[] = md.digest();
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < byteData.length; i++) {
	            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	        }
	        MD5 = sb.toString();
	 
	    } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	        MD5 = null;
	    }
	    return MD5;
	}
	
	/**
	 * Base64 decode
	 */
	public static String base64Decode(String pwd) {
		byte[] decoded = Base64.getDecoder().decode(pwd);
		return new String(decoded);
	}
}
