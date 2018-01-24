package com.ratish.JAN18Challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
https://www.codechef.com/JAN18/problems/KCON
*/
public class KCON {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long testCases = Long.parseLong(br.readLine());
		while (testCases-- > 0) {
			String[] tokens = br.readLine().split(" ");
			long n = Long.parseLong(tokens[0]);
			long k = Long.parseLong(tokens[1]);
			ArrayList<Long> arr = new ArrayList<>();
			tokens = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				arr.add(Long.parseLong(tokens[i]));
			}
			long s1 = getMaxValue(arr);
			long s2 = getIncreasingMaxValue(arr);
			long s3 = getTotalSum(arr);
			long s4 = getMaxSumIncludingLast(arr);
			if (k == 1) {
				System.out.println(s1);
			} else if (k == 2) {
				ArrayList<Long> arr2 = new ArrayList<>();
				arr2.addAll(arr);
				arr2.addAll(arr);
				System.out.println(getMaxValue(arr2));
			} else {
				long temp1 = s4 + (k - 2) * s3 + s2;
				temp1 = Math.max(s2 + s4, temp1);
				System.out.println(Math.max(s1, temp1));
			}
		}
	}

	private static long getTotalSum(ArrayList<Long> arr) {
		long sum = 0;
		for (int i = 0; i < arr.size(); i++) {
			sum = sum + arr.get(i);
		}
		return sum;
	}

	private static long getMaxSumIncludingLast(ArrayList<Long> arr) {
		long maxSumTillNow = arr.get(arr.size() - 1);
		long maxSumGlobal = arr.get(arr.size() - 1);
		for (int i = arr.size() - 2; i >= 0; i--) {
			maxSumTillNow = maxSumTillNow + arr.get(i);
			if (maxSumTillNow > maxSumGlobal) {
				maxSumGlobal = maxSumTillNow;
			}
		}
		return maxSumGlobal;
	}

	private static long getMaxValue(ArrayList<Long> arr) {
		long maxSumTillNow = arr.get(0);
		long maxSumGlobal = arr.get(0);
		for (int i = 1; i < arr.size(); i++) {
			maxSumTillNow = Math.max(arr.get(i), maxSumTillNow + arr.get(i));
			maxSumGlobal = Math.max(maxSumGlobal, maxSumTillNow);
		}
		return maxSumGlobal > maxSumTillNow ? maxSumGlobal : maxSumTillNow;
	}

	private static long getIncreasingMaxValue(ArrayList<Long> arr) {
		long maxSumTillNow = arr.get(0);
		long maxSumGlobal = arr.get(0);
		for (int i = 1; i < arr.size(); i++) {
			maxSumTillNow = maxSumTillNow + arr.get(i);
			if (maxSumTillNow > maxSumGlobal) {
				maxSumGlobal = maxSumTillNow;
			}
		}
		return maxSumGlobal;
	}
}
