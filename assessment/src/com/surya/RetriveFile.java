package com.surya;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RetriveFile {
	
	//Declaration Section
	ArrayList<String> storedLines = new ArrayList();
	List<Integer> precpList = new ArrayList<>();
	List<Integer> highTempList = new ArrayList<>();
	List<Integer> lowTempList = new ArrayList<>();
	List<String> dayList = new ArrayList<>();
	List<Integer> dayNumberList = new ArrayList<>();
	List<String> resultList = new ArrayList<>();
	List<Integer> indexList = new ArrayList<>();
	List<Integer> tempSumList = new ArrayList<>();
	
	List<String> modifiedResultList = new ArrayList<>();
	
	int smallest=Integer.MAX_VALUE;
	String weekDay;
	String weekDay1;
	String weekDay2;
	
	public RetriveFile() throws Exception {
		retriveString();//Calling the method which stores all the lines individually and separates the parameters from each line.
	}
	public void retriveString() throws Exception{

		File weatherFile = new File("src\\com\\surya\\weather.txt");
		
		
		//Reading the Weather File 
		BufferedReader readFile = new BufferedReader(new FileReader(weatherFile));
		
		int lineNumber=0;
		String eachline;
		
		while((eachline = readFile.readLine())!=null){
			lineNumber++;
			eachline=eachline.trim();//Trimming all the spaces before and after each line.
			eachline=eachline.replaceAll("\\s+",""); //Replacing all the spaces between the words in each line.
			if(lineNumber==1) {
				continue; //Ignoring the first line in weather file
			}
			else{
				storedLines.add(eachline); //Storing each lines in the ArrayList
			}	
		}
		
		
		int countLine = 0;
		for(String eachString:storedLines) {
			countLine++;
			if(countLine<10) {
				// For precp Storing
				int prep=Integer.valueOf(eachString.substring(6));
				precpList.add(prep);
				
				// For High Temp Storing
				int highTemp = Integer.valueOf(eachString.substring(2, 4));
				highTemp = (int) (highTemp*1.8 + 32);
				highTempList.add(highTemp);
				
				//For Low Temp Storing
				int lowTemp = Integer.valueOf(eachString.substring(4, 6));
				lowTemp = (int) (lowTemp*1.8 + 32);
				lowTempList.add(lowTemp);
				
				//For Day of week Storing
				String dayOfWeek = eachString.substring(1,2);
				dayList.add(dayOfWeek);
				
				//For Storing the day of the month.
				int dayNum = Integer.valueOf(eachString.substring(0, 1));
				dayNumberList.add(dayNum);
			}
			else {
				// For precp Storing
				int prep=Integer.valueOf(eachString.substring(7));
				precpList.add(prep);
				
				// For High Temp Storing
				int highTemp = Integer.valueOf(eachString.substring(3, 5));
				highTemp = (int) (highTemp*1.8 + 32);
				highTempList.add(highTemp);
				
				//For Low Temp Storing
				int lowTemp = Integer.valueOf(eachString.substring(5, 7));
				lowTemp = (int) (lowTemp*1.8 + 32);
				lowTempList.add(lowTemp);
				
				//For Day of week Storing
				String dayOfWeek = eachString.substring(2,3);
				dayList.add(dayOfWeek);
				
				//For Storing the day of the month.
				int dayNum = Integer.valueOf(eachString.substring(0, 2));
				dayNumberList.add(dayNum);
			}
		}
//		System.out.println(highTempList);
//		System.out.println(lowTempList);
//		System.out.println(precpList);
//		System.out.println(dayList);
//		System.out.println(dayNumberList);
		calcBestDay(); //Calling the method which is going to calculate the best day from the sorted Lists.
		
	}
	
	
	public void calcBestDay() {
		for(int i=0; i<highTempList.size(); i++) {
			if(highTempList.get(i)<=85 && lowTempList.get(i)>=70) {
				indexList.add(i); // Adding all the indexes in the list which have the temperature range between 70 and 85.
				if(precpList.get(i)<smallest)
					smallest=precpList.get(i); // Calculating the least precipitation among the given indexes.
			}
		}
		for(int elem:indexList) {
			if(precpList.get(elem) == smallest) { // The index among the selected indexes which have the smallest precipitation is the best day.
				int dayNum = dayNumberList.get(elem);
				weekDay = calcDay(dayNum); // Calling out the method which returns the full week day name from the day number.
				String result= weekDay + " the " + dayNum+"th day of month is the bestday for a picnic."; 
				resultList.add(result); //Storing the result string in result ArrayList.
			}
		}
//		System.out.println(indexList);
		for(String result: resultList) {
			System.out.println(result); //Printing out the result ArrayList.
		}
	}
	
	public String calcDay(int dayNum) { //Method which returns the full WeekDay Name from the day number.
		dayNum = dayNum%7;
		
		switch(dayNum) {
			case 1:
				return "Wednesday";
			case 2:
				return "Thursday";
			case 3:
				return "Friday";
			case 4:
				return "Saturday";
			case 5:
				return "Sunday";
			case 6:
				return "Monday";
			case 7:
				return "Tuesday";
			default:
				return "Not a Valid Number";
		}
	}
	
	//----------------------**************************SECOND PART**************************----------------------//
	
	int temp=0;
	int n;
	List<Integer> tempBuffer = new ArrayList<>();
	
		public void vacationRange(int N) {//Method which prints the best vacation range
			try {
			this.n=N;
			if(n == 1) { //If number of days is 1, we can use the same code as we used above to print best day for vacation.
				for(int elem:indexList) {
					if(precpList.get(elem) == smallest) {
						int dayNum = dayNumberList.get(elem);
						weekDay = calcDay(dayNum);
						String result= weekDay + " the " + dayNum+"th day of month is the bestday for a picnic.";
						modifiedResultList.add(result);
					}
				}
			}
			else {		
				for(int i=0;i<indexList.size();i++) {
					
					int start = i;
					int size = 1;
					int end = start;
					
					//Storing the "n" consecutive days from indexList to the tempBuffer.
					if(i<=indexList.size()-n) {
						end = start+1;
						while(indexList.get(end) == indexList.get(end-1)+1) {
							size++;
							if(end>=indexList.size()) {
								break;
							}
							if(size == n) {
								tempBuffer.add(indexList.get(start));
								tempBuffer.add(indexList.get(end));
							}
							end++;
						}
					}
				}	
			}
			
			//Calculating the sum of precipitation for all the days combined in each Range and storing in the tempSumList.
			for(int i=0;i<tempBuffer.size();i++) {
				if(i%2 == 1) {
					continue;
				}
				int a = tempBuffer.get(i);
				int b = tempBuffer.get(i+1);
				
				int sum = precpList.get(a);
				inner: while( a!=b ) {
					sum += precpList.get(a+1);
					a++;
				}
				tempSumList.add(sum);
			}
			
			//Calculating the minimum sum among all the sums.
			int smallestPrecpSum = Integer.MAX_VALUE;
			for(int element: tempSumList) {
				if(element<smallestPrecpSum) {
					smallestPrecpSum = element;
				}
			}
			
			//Matching the range with the minimum sum
			for(int i=0;i<tempBuffer.size();i++) {
				if(i%2 == 1) {
					continue;
				}
				int a = tempBuffer.get(i);
				int b = tempBuffer.get(i+1);
				
				int sum = precpList.get(a);
				inner: while( a!=b ) {
					sum += precpList.get(a+1);
					a++;
				}
				if(sum == smallestPrecpSum) {//The range with minimum sum is the best vacation range, so retrieving all the parameters from the range values.
					
					int dayNum1 = dayNumberList.get(b-n+1);
					int dayNum2 = dayNumberList.get(b);
					weekDay1 = calcDay(dayNum1);
					weekDay2 = calcDay(dayNum2);
					String result= weekDay1 + " to " + weekDay2 + " i.e. the " + dayNum1+"th day of month to "+dayNum2+"th day of month are the bestdays for a picnic with good climate and less precipitation.";
					modifiedResultList.add(result); // Storing the result Strings to the new resultList.
					
//					System.out.println((b-n+1) +" "+ b  );
				}
			}
//			System.out.println(tempBuffer);
//			System.out.println(tempSumList);
//			System.out.println(smallestPrecpSum);
			
			//If there is no possible range, then the result list will be empty, so printing the text to display no valid range.
			if(modifiedResultList.size()==0) {
				System.out.println(n+" days of vacation is not possible as there are no consecutive days with the given range of temperature and precipitation!");
			}
			else {
				for(String result: modifiedResultList) {//Printing out the new result list Strings.
					System.out.println(result);
				}	
			}
		}
	
		catch(Exception e) {//Catches all the exceptions in regards to the number entered by the user, and prints the below text.
			System.out.println("Please enter the valid number greater than 0");
		}
	}
}
