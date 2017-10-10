package com.ratish.JULY17Challenge;

/*
 * https://www.codechef.com/JULY17/problems/NITIKA/
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NITIKA {

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		while (testCases-- > 0) {
			String[] str = br.readLine().split(" ");
			if (str.length == 1) {
				System.out.println(toUpperCase(str[0].substring(0, 1)) + str[0].substring(1).toLowerCase());
			} else if (str.length == 2) {
				System.out.println(toUpperCase(str[0].substring(0, 1)) + ". " + toUpperCase(str[1].substring(0, 1))
						+ str[1].substring(1).toLowerCase());
			} else {
				System.out.println(toUpperCase(str[0].substring(0, 1)) + ". " + toUpperCase(str[1].substring(0, 1))
						+ ". " + toUpperCase(str[2].substring(0, 1)) + str[2].substring(1).toLowerCase());

			}
		}
	}

	private static String toUpperCase(String substring) {
		return substring.toUpperCase();
	}
}