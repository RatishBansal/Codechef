package com.ratish.JAN18Challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://www.codechef.com/JAN18/problems/RECTANGL
*/
public class RECTANGL {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		while (testCases-- > 0) {
			String[] tokens = br.readLine().split(" ");
			int a = Integer.parseInt(tokens[0]);
			int b = Integer.parseInt(tokens[1]);
			int c = Integer.parseInt(tokens[2]);
			int d = Integer.parseInt(tokens[3]);
			if ((a == b && c == d) || (a == c && b == d) || (a == d && b == c)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
