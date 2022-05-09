package com.leejx2.accountbook.common.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.util.Base64Utils;

public class Encryptor {
	public static String alg = "AES/CBC/PKCS5Padding";
    private final static String key = "a12eadf09j2nfad3mn4i8qdw0zcvk24t";
    private final static String iv = key.substring(0, 16); // 16byte
	
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
	 * AES256 암호화
	 * @param pwd
	 * @return
	 */
	public static String aesEncrypt(String pwd) {
		Cipher cipher;
		byte[] encrypted = null;
		String result = "";
		try {
			cipher = Cipher.getInstance(alg);
			
			SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
	        IvParameterSpec ivParamSpec = new IvParameterSpec(iv.getBytes("UTF-8"));
	        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParamSpec);
	        
	        encrypted = cipher.doFinal(pwd.getBytes("UTF-8"));
	        result = Base64.getEncoder().encodeToString(encrypted);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}

        return result;
	}
	
	/**
	 * AES256 복호화
	 * @param cipherText
	 * @return
	 * @throws Exception
	 */
	public static String aesDecrypt(String cipherText) throws Exception {
        Cipher cipher = Cipher.getInstance(alg);
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
        IvParameterSpec ivParamSpec = new IvParameterSpec(iv.getBytes("UTF-8"));
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivParamSpec);

        byte[] decodedBytes = Base64.getDecoder().decode(cipherText);
        byte[] decrypted = cipher.doFinal(decodedBytes);
        return new String(decrypted, "UTF-8");
    }
	
	/**
	 * Base64 decode
	 */
	public static String base64Decode(String pwd) {
		return new String(Base64.getUrlDecoder().decode(pwd));
	}
}
