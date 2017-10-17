package com.us.g2g.util;

import java.math.BigInteger;
import java.security.SecureRandom;

public class RandomStringUtil {
	
	public static String next(){
		SecureRandom random = new SecureRandom();
		return new BigInteger(130, random).toString(32);
	}

	
}
