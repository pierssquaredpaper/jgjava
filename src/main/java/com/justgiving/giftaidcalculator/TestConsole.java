package com.justgiving.giftaidcalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestConsole {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please Enter donation amount:");
		double s = new Double(br.readLine());
		System.out.println(giftAidAmount(s));
		System.out.println("Press any key to exit.");
		br.readLine();
	}

	static double giftAidAmount(double donationAmount) {
		double gaRatio = 17.5 / (100.0 - 17.5);
		return donationAmount * gaRatio;
	}

}
