package com.ratish.JAN18Challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
https://www.codechef.com/JAN18/problems/MAXSC
*/
public class MAXSC {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long testCases = Long.parseLong(br.readLine());
		while (testCases-- > 0) {
			long n = Long.parseLong(br.readLine());
			ArrayList<ArrayList<Long>> grid = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				String[] tokens = br.readLine().split(" ");
				ArrayList<Long> row = new ArrayList<>();
				for (int j = 0; j < tokens.length; j++) {
					row.add(Long.parseLong(tokens[j]));
				}
				grid.add(row);
			}
			long answer = 0;
			long maxTillNow = Long.MAX_VALUE;
			boolean flag = false;
			for (int i = grid.size() - 1; i >= 0; i--) {
				ArrayList<Long> row = grid.get(i);
				long rowMax = Long.MIN_VALUE;
				for (int j = 0; j < row.size(); j++) {
					if (maxTillNow > row.get(j) && rowMax < row.get(j)) {
						rowMax = row.get(j);
					}
				}
				if (rowMax == Long.MIN_VALUE) {
					flag = true;
					break;
				}
				answer = answer + rowMax;
				maxTillNow = rowMax;
			}
			if (flag) {
				System.out.println(-1);
			} else {
				System.out.println(answer);
			}
		}
	}
}
