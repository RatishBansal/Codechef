package com.ratish.JULY17Challenge;

/*
 * https://www.codechef.com/JULY17/problems/CALC
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CALC {

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		while (testCases-- > 0) {
			String[] str = br.readLine().split(" ");
			long N = Integer.parseInt(str[0]);
			long B = Integer.parseInt(str[1]);
			long i = (N) / (2 * B);
			long maxValue1 = (N - i * B) * i;
			i++;
			long maxValue2 = (N - i * B) * i;
			/*
			 * i = i - 1; long maxValue3 = (N - i * B) * i;
			 */
			long maxValue = maxValue(maxValue1, maxValue2, Long.MIN_VALUE);
			System.out.println(maxValue >= 0 ? maxValue : N - B);
		}
	}

	private static long maxValue(long maxValue1, long maxValue2, long maxValue3) {
		long answer = maxValue1;
		if (maxValue2 > answer) {
			answer = maxValue2;
		}
		if (maxValue3 > answer) {
			answer = maxValue3;

		}
		return answer;
	}
}