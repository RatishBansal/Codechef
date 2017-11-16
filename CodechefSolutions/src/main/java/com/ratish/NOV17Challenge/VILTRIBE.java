package com.ratish.NOV17Challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
https://www.codechef.com/NOV17/problems/VILTRIBE
*/
public class VILTRIBE {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		while (testCases-- > 0) {
			String sequence = br.readLine();
			ArrayList<Character> left = new ArrayList<>(Collections.nCopies(sequence.length(), '.'));
			Character lastLeftAorB = '.';
			for (int i = 0; i < sequence.length(); i++) {
				if (sequence.charAt(i) != '.') {
					left.set(i, sequence.charAt(i));
					lastLeftAorB = sequence.charAt(i);
				} else {
					left.set(i, lastLeftAorB);
				}
			}
			lastLeftAorB = '.';
			ArrayList<Character> right = new ArrayList<>(Collections.nCopies(sequence.length(), '.'));
			for (int i = sequence.length() - 1; i >= 0; i--) {
				if (sequence.charAt(i) != '.') {
					right.set(i, sequence.charAt(i));
					lastLeftAorB = sequence.charAt(i);
				} else {
					right.set(i, lastLeftAorB);
				}
			}
			int noOfA = 0;
			int noOfB = 0;
			for (int i = 0; i < sequence.length(); i++) {
				if (left.get(i) == 'A' && right.get(i) == 'A') {
					noOfA++;
				} else if (left.get(i) == 'B' && right.get(i) == 'B') {
					noOfB++;
				}
			}
			System.out.println(noOfA + " " + noOfB);
		}
	}
}
