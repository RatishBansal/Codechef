package com.ratish.OCT17Challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
https://www.codechef.com/OCT17/problems/PERFCONT
*/
public class PERFCONT {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		while (testCases-- > 0) {
			String[] tokens = br.readLine().split(" ");
			int N = Integer.parseInt(tokens[0]);
			int P = Integer.parseInt(tokens[1]);
			tokens = br.readLine().split(" ");
			ArrayList<Integer> noOfSolutions = new ArrayList<>();
			for (int i = 0; i < tokens.length; i++) {
				noOfSolutions.add(Integer.parseInt(tokens[i]));
			}
			int hardProblem = 0;
			int cakeWalk = 0;
			for (int i = 0; i < noOfSolutions.size(); i++) {
				if (noOfSolutions.get(i) >= (P / 2)) {
					cakeWalk++;
				}
				if (noOfSolutions.get(i) <= (P / 10)) {
					hardProblem++;
				}
			}
			if (cakeWalk == 1 && hardProblem == 2) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}

		}
	}
}
