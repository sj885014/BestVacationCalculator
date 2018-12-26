# BestVacationCalculator
In this application we will be focussing on two main parts.

1. In the first part of the application, the data from the weather.txt is read and then calculates the best day from the given list for a vaction based on two main conditions, the climate should be equal to or in between 70 to 85 F and least precipitation. If there are multiple values possible, all the possibilities will be stored in an ArrayList.

2. In the second part of the application, the user will enter an N value, which is the number of days the user wants for the vacation. Here we follow the same conditions as we followed in the first part. All the vacation days should have the climate range in between 70 to 85F, and whichever range has the minimum precipitation is the best vacation period for the user. Again if we have the mutiple ranges which follow the above mentioned rules, those ranges are saved to an ArrayList and printed.

weather.txt is the text file contataining the weather and the dates information.

RetriveFile.java is java file which does all the manipulations needed.

BestDayCalculator.java is the java file, which has the main method, where we declare the object of RetrieveFile and call the first method and second method. First method directly prints the best vacation day in the weather file, for the second method user enters the N value which is number of days user wants to go on a vacation. If there is a valid existing range, then it prints the range. 
