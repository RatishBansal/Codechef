package com.ratish.AU17Challenge;

/*https://www.codechef.com/AUG17/problems/GCAC
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GCAC {
	static class Company {
		int offeredSalary;
		int maxJobOffers;
		int offerTillNow;

		public Company(int offerSalary, int maxJobOfffers) {
			this.offeredSalary = offerSalary;
			this.maxJobOffers = maxJobOfffers;
			this.offerTillNow = 0;
		}
	}

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		while (testCases-- > 0) {
			String[] str = br.readLine().split(" ");
			ArrayList<String> qual = new ArrayList<>();
			int N = Integer.parseInt(str[0]);
			int M = Integer.parseInt(str[1]);
			str = br.readLine().split(" ");
			int[] minSalary = new int[N];
			ArrayList<Company> companies = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				minSalary[i] = Integer.parseInt(str[i]);
			}
			for (int i = 0; i < M; i++) {
				str = br.readLine().split(" ");
				Company c = new Company(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
				companies.add(c);
			}
			for (int i = 0; i < N; i++) {
				qual.add(br.readLine());
			}
			int noOfJobCandidates = 0;
			long totalSalary = 0;
			int companiesWithoutHire = 0;
			for (int i = 0; i < N; i++) {
				String offers = qual.get(i);
				int offeredCompanyIndex = -1;
				int maxValueTillNow = minSalary[i];
				for (int j = 0; j < M; j++) {
					if (offers.charAt(j) == '1' && maxValueTillNow <= companies.get(j).offeredSalary
							&& companies.get(j).offerTillNow < companies.get(j).maxJobOffers) {
						maxValueTillNow = companies.get(j).offeredSalary;
						offeredCompanyIndex = j;
					}
				}
				if (offeredCompanyIndex != -1) {
					companies.get(offeredCompanyIndex).offerTillNow++;
					totalSalary = totalSalary + companies.get(offeredCompanyIndex).offeredSalary;
					noOfJobCandidates++;
				}
			}
			for (int j = 0; j < M; j++) {
				if (companies.get(j).offerTillNow == 0) {
					companiesWithoutHire++;
				}
			}
			System.out.println(noOfJobCandidates + " " + totalSalary + " " + companiesWithoutHire);
		}
	}
}
