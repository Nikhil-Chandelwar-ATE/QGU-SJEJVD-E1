package com.generic_Library;

import java.util.Date;
import java.util.Random;

public class Java_Utility {

	public static int getRandomNumber() {
		
		Random num = new Random();
		return num.nextInt(1000);
	}
	
	public static String getName() {
		
		String name = new Date().toString().replace(" ", "_").replace(":", "_");
		return name;
	}
}
