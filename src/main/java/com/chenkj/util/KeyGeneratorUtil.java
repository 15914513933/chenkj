package com.chenkj.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class KeyGeneratorUtil {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	private static Random random = new Random();
	public static String generateKey(){
		return sdf.format(new Date()) + (random.nextInt(900)+ 100);
	}
	public static void main(String[] args) {
		System.out.println(generateKey());
	}
}
