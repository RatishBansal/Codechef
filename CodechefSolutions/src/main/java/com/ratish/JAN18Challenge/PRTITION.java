package com.ratish.JAN18Challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
https://www.codechef.com/JAN18/problems/PRTITION
*/
public class PRTITION {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long testCases = Long.parseLong(br.readLine());
		while (testCases-- > 0) {
			String[] tokens = br.readLine().split(" ");
			long x = Long.parseLong(tokens[0]);
			long n = Long.parseLong(tokens[1]);
			char[] answer = new char[(int) n];
			Arrays.fill(answer, '0');
			if (n == 2) {
				System.out.println("impossible");
			} else if ((((n * (n + 1)) / 2 - x) % 2) != 0) {
				System.out.println("impossible");
			} else {
				answer[(int) (x - 1)] = '2';
				long requiredSum = ((n * (n + 1)) / 2 - x) / 2;
				long sum = 0;
				// boolean flag = true;
				int i = (int) (n);
				while (sum < requiredSum && i > 0) {
					if (i == x) {
						i--;
						continue;
					}
					if ((requiredSum - sum) >= i) {
						sum = sum + i;
						answer[i - 1] = '1';
						if ((requiredSum - sum) == x) {
							sum = sum - i;
							answer[i - 1] = '0';
						}
					} else if ((requiredSum - sum) < i && (requiredSum - sum) != x) {
						answer[(int) (requiredSum - sum - 1)] = '1';
						sum = requiredSum;
					}
					i--;
				}
				if (sum == requiredSum) {
					System.out.println(new String(answer));
				} else {
					System.out.println("impossible");
				}
			}
		}
	}
}
