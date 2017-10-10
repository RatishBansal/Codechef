package com.ratish.AU17Challenge;

/*
https://www.codechef.com/AUG17/problems/RAINBOWA
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RAINBOWA {

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		while (testCases-- > 0) {
			int N = Integer.parseInt(br.readLine());
			String[] str = br.readLine().split(" ");
			int lastMax = 0;
			boolean flag = true;
			for (int i = 0; i <= N / 2; i++) {
				if (Integer.parseInt(str[i]) == (lastMax + 1)) {
					lastMax++;
				} else if (Integer.parseInt(str[i]) < lastMax) {
					flag = false;
					break;
				}
			}
			for (int i = 0; i < N / 2; i++) {
				if (Integer.parseInt(str[i]) != Integer.parseInt(str[N - i - 1])) {
					flag = false;
					break;
				}
			}
			System.out.println((flag && (lastMax == 7)) ? "yes" : "no");
		}
	}
}