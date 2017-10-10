package com.ratish.JULY17Challenge;

/*https://www.codechef.com/JULY17/problems/CHEFSIGN
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CHEFSIGN {

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		while (testCases-- > 0) {
			String str = br.readLine();
			int value = 0;
			int maxValue = Integer.MIN_VALUE;
			char lastCharacter = '#';
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '=') {
					continue;
				} else if (str.charAt(i) == lastCharacter) {
					value++;
				} else {
					value = 1;
					lastCharacter = str.charAt(i);
				}
				if (value > maxValue) {
					maxValue = value;
				}
			}
			if (value > maxValue) {
				maxValue = value;
			}
			System.out.println(maxValue + 1);
		}
	}
}
