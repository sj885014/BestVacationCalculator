package com.surya;

import java.util.Scanner;

public class BestDayCalculator {

	public static void main(String[] args) throws Exception {
		// This itself calls all the methods for the first part of the application 
		//where it returns the best day for vacation among all the given days.		
		RetriveFile obj1 = new RetriveFile();
		
		System.out.println();
		System.out.println("***********This is the second part where we enter the n value(i.e. number of days for vacation) as the input**************");
		System.out.println();
		
		//Second part of the Application	
		System.out.println("Please enter the N Value:");
		Scanner input = new Scanner(System.in);
		int days = input.nextInt();// Enter the number of days user wants for a vacation.
		obj1.vacationRange(days);// Prints the optimal vacation period.

	}

}
