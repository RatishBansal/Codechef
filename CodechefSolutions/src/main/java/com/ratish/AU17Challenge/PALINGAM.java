package com.ratish.AU17Challenge;

/*
 * https://www.codechef.com/AUG17/problems/PALINGAM
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PALINGAM {

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		while (testCases-- > 0) {
			String s = br.readLine();
			String t = br.readLine();
			char answer = 'B';
			int[] sArray = new int[26];
			int[] tArray = new int[26];
			boolean bHasUniqueElement = false;
			boolean aHasUniqueElement = false;
			for (int i = 0; i < s.length(); i++) {
				sArray[s.charAt(i) - 97]++;
				tArray[t.charAt(i) - 97]++;
			}
			for (int i = 0; i < 26; i++) {
				if (sArray[i] == 0 && tArray[i] >= 1) {
					bHasUniqueElement = true;
				}
				if (sArray[i] >= 1 && tArray[i] == 0) {
					aHasUniqueElement = true;
				}
			}

			if (aHasUniqueElement && bHasUniqueElement) {
				answer = 'B';
			} else if (aHasUniqueElement && !bHasUniqueElement) {
				answer = 'A';
			} else if (!aHasUniqueElement) {
				answer = 'B';
			}

			for (int i = 0; i < 26; i++) {
				if (sArray[i] >= 2 && tArray[i] == 0) {
					answer = 'A';
				}
			}
			System.out.println(answer);

		}
	}
}
