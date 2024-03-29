package ex07;

import java.util.Scanner;

/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Ashley Mojica
 */

/*
Exercise 7 - Area of a Rectangular Room
When working in a global environment, you’ll have to present information in both metric and Imperial
units. And you’ll need to know when to do the conversion to ensure the most accurate results.

Create a program that calculates the area of a room. Prompt the user for the length and width of the
room in feet. Then display the area in both square feet and square meters.

Example Output:
What is the length of the room in feet? 15
What is the width of the room in feet? 20
You entered dimensions of 15 feet by 20 feet.
The area is
300 square feet
27.871 square meters

The formula for this conversion is m2 = f2 × 0.09290304

Constraints:
Keep the calculations separate from the output.
Use a constant to hold the conversion factor.

Challenges:
Revise the program to ensure that inputs are entered as numeric values. Don’t allow the user to
proceed if the value entered is not numeric.
Create a new version of the program that allows you to choose feet or meters for your inputs.
Implement this program as a GUI program that automatically updates the values when any value changes.
 */
public class App 
{
    static Scanner input = new Scanner(System.in);
    public static void main( String[] args )
    {
        App myApp = new App();
        double feetConversion = 1.0; // Because it's feet->feet
        double metersConversion =  0.09290304;
        String lengthString = myApp.getLength();
        String widthString = myApp.getWidth();

        double length = myApp.convertStringToDouble(lengthString);
        double width = myApp.convertStringToDouble(widthString);

        double areaInFeet = myApp.getArea(length, width, feetConversion);
        String areaInFeetString = String.format("%.0f", areaInFeet);
        double areaInMeters = myApp.getArea(length, width, metersConversion);
        String areaInMetersString = String.format("%.3f", areaInMeters);
        String message = myApp.generateMessage(lengthString, widthString, areaInFeetString, areaInMetersString);
        System.out.println(message);
    }

    public String getLength(){
        System.out.print("What is the length of the room in feet? ");
        String len = input.nextLine();
        return len;
    }
    public String getWidth(){
        System.out.print("What is the width of the room in feet? ");
        String wid = input.nextLine();
        return wid;
    }

    public double convertStringToDouble(String word){
        return Double.parseDouble(word);
    }

    public double getArea(double length, double width, double conversion){
        return ((length * width) * conversion);
    }

    public String generateMessage(String length , String width, String areaFeet, String areaMeters) {
        return "You entered dimensions of " + length + " feet by " + width + " feet.\n" +
                "The area is\n" + areaFeet + " square feet\n" + areaMeters + " square meters";
    }
}
