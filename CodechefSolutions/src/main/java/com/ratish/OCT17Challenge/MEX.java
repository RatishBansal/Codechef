package com.ratish.OCT17Challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/*
https://www.codechef.com/OCT17/problems/MEX
*/
public class MEX {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		while (testCases-- > 0) {
			String[] tokens = br.readLine().split(" ");
			int N = Integer.parseInt(tokens[0]);
			int K = Integer.parseInt(tokens[1]);
			tokens = br.readLine().split(" ");
			HashSet<Long> hashSet = new HashSet<>();
			for (int i = 0; i < tokens.length; i++) {
				hashSet.add(Long.parseLong(tokens[i]));
			}
			long kCopy = K;
			long answer = 0;
			for (long i = 0; i < hashSet.size() + kCopy+1; i++) {
				if (K != 0 && !hashSet.contains(i)) {
					K--;
				} else if (K == 0 && !hashSet.contains(i)) {
					answer = i;
					break;
				}
			}
			System.out.println(answer);

		}
	}
}
