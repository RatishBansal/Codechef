package com.ratish.NOV17Challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
https://www.codechef.com/NOV17/problems/CLRL
*/
public class CLRL {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		while (testCases-- > 0) {
			String[] tokenRatings = br.readLine().split(" ");
			int n = Integer.parseInt(tokenRatings[0]);
			int RezibaRating = Integer.parseInt(tokenRatings[1]);
			tokenRatings = br.readLine().split(" ");
			ArrayList<Integer> ratings = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				ratings.add(Integer.parseInt(tokenRatings[i]));
			}
			int upperBound = Integer.MAX_VALUE;
			int lowerBound = Integer.MIN_VALUE;
			boolean flag = true;
			for (int i = 0; i < n; i++) {
				if (!(ratings.get(i) > lowerBound && ratings.get(i) < upperBound)) {
					flag = false;
					break;
				}
				if (ratings.get(i) > RezibaRating) {
					upperBound = ratings.get(i);
				} else {
					lowerBound = ratings.get(i);
				}
			}
			System.out.println(flag ? "YES" : "NO");
		}
	}
}
