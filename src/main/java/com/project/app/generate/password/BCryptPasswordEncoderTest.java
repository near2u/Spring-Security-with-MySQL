package com.project.app.generate.password;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderTest {
	
	public static void main(String[] args) {
		
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		//BCryptPasswordde
		System.out.println(bCryptPasswordEncoder.encode("vishal@123"));
		System.out.println(bCryptPasswordEncoder.encode("m@123"));
		//bCryptPasswordEncoder.de
	}

}
