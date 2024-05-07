package com.klef.jfsd.springboot.service;

import java.security.SecureRandom;

import org.springframework.stereotype.Service;

@Service
public class PasswordGenaraterServiceImpl implements PasswordGenaraterService{
	 public  String generateRandomString(int length) {
	        String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
	        String digitChars = "0123456789";
	        String specialChars = "!@#$%^&*()-_+=<>?";

	        String allChars = uppercaseChars + lowercaseChars + digitChars + specialChars;
	        SecureRandom random = new SecureRandom();
	        StringBuilder sb = new StringBuilder(length);

	        for (int i = 0; i < length; i++) {
	            int randomIndex = random.nextInt(allChars.length());
	            char randomChar = allChars.charAt(randomIndex);
	            sb.append(randomChar);
	        }
System.out.println(sb.toString());
	        return sb.toString();
	    }
}
