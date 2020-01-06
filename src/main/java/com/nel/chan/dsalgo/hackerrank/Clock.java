package com.nel.chan.dsalgo.hackerrank;

public class Clock {

	static String timeConversion(String s) {
		if (s.equals("12:00:00AM")) {
			return "00:00:00";
		}
		
		String convertedTime = "";
		
		
		String isAm = s.substring(s.length() - 2);
		if ("AM".equalsIgnoreCase(isAm)) {
			convertedTime = s.substring(0, s.length() - 2);
			int hour = Integer.parseInt(convertedTime.substring(0, 2));
			if (hour == 12) {
				convertedTime = "00" + ":" + convertedTime.substring(3);
			}
		} 
		else {
			convertedTime = s.substring(0, s.length() - 2);
			int hour = Integer.parseInt(convertedTime.substring(0, 2));
			if (hour != 12) {
				hour = hour + 12;
				convertedTime = hour + ":" + convertedTime.substring(3);
			}
		}

		return convertedTime;
	}

	public static void main(String[] args) {
		String s = "12:05:39AM";
		String result = timeConversion(s);
		System.out.println(result);
	}
}