package com.nel.chan.dsalgo.hackerrank;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Given the number of seconds elapsed since epoch [01-01-1970 00:00:00
 * Thursday], you need to find the current date, along with the day.
 * 
 * @author Chandrakanth Nelge
 *
 */
public class TimeOfTheYear {

	private static void findTimeOfTheYear(long seconds) {
		Date date = new Date(seconds);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy EEEE", Locale.US);
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		String formattedDate = sdf.format(date);

		String[] temp = formattedDate.split("-");
		String convertedDate = temp[0] + "-" + temp[1].toUpperCase() + "-" + temp[2];
		System.out.println(convertedDate);
	}

	public static void main(String[] args) {
		long seconds = 68169600;
		findTimeOfTheYear(seconds * 1000);
	}
}