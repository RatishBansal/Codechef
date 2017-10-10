package com.ratish.AU17Challenge;

/*
 * https://www.codechef.com/AUG17/problems/CHEFMOVR
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CHEFMOVR {

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		while (testCases-- > 0) {
			String[] str = br.readLine().split(" ");
			long N = Long.parseLong(str[0]);
			int D = Integer.parseInt(str[1]);
			str = br.readLine().split(" ");
			long sum = 0;
			long answer = 0;
			boolean flag = true;
			for (int i = 0; i < N; i++) {
				sum = sum + Long.parseLong(str[i]);
			}
			long elemntValue = sum / N;
			long elemntRemainder = sum % N;
			long carryForward = 0;
			for (int i = 0; i < N - D; i++) {
				if (elemntRemainder > 0) {
					flag = false;
					break;
				} else {
					long leftDiversion = Long.parseLong(str[i]) - elemntValue;
					answer = answer + Math.abs(leftDiversion);
					str[i] = Long.toString(elemntValue);
					str[i + D] = Long.toString(Long.parseLong(str[i + D]) + leftDiversion);
				}
			}
			for (int i = 0; i < N; i++) {
				if (Long.parseLong(str[i]) != elemntValue) {
					flag = false;
					break;
				}
			}
			System.out.println(flag && (carryForward == 0) ? answer : "-1");
		}
	}
}
