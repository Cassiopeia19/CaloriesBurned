package com.edu.umsl.Assignment4.CaloriesBurned;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ActivityType extends ActivePeople {

	String activity;
	double miles;
	double burnPerMile = 0;
	double totalCalorieBurn = 0;

	public ActivityType(String name, double weight, int age, String activity, double miles, 
			double burnPerMile, double totalCalorieBurn,
			ActivityType at, Scanner input, int selection) {
		super(name, weight, age, input, selection, at);

		this.activity = activity;
		this.miles = miles;
		this.burnPerMile = burnPerMile;
		this.totalCalorieBurn = totalCalorieBurn;
	}

	ActivePeople ap = new ActivePeople();
	
	public ActivityType() {

	}
	public String getActivity(){

		System.out.println();
		System.out.println("Select from the following activities to compute calories burned: ");
		System.out.println();
		System.out.println("'1' Running");
		System.out.println("'2' Walking");
		System.out.println();
		System.out.print("Enter your selection here: ");
	
		input = new Scanner(System.in);
		selection = input.nextInt();
			
		switch(selection) {
		case 1:
			activity = "running";
			break;
		case 2:
			activity = "walking";
			break;
						} 
		return activity;
		}

	public double getMiles() {
		System.out.println();
		System.out.print("Enter the number of miles: ");
		input = new Scanner(System.in);
	    miles = input.nextInt();
		return miles;
	}
	public double getBurnPerMile() {

		if (activity =="running") {
			burnPerMile =(0.75 * ActivePeople.weight);
		}
		else if(activity == "walking") {
			burnPerMile = (0.53 * ActivePeople.weight);
		}
		return burnPerMile;
	}
	public double getTotalCalorieBurn() {
		
		totalCalorieBurn = (at.burnPerMile * at.miles);
		return totalCalorieBurn;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public void setMiles(int miles) {
		this.miles = miles;
	}

	public void setBurnPerMile(double burnPerMile) {
		this.burnPerMile = burnPerMile;
	}
	
	public void setTotalCalorieBurn(double totalCalorieBurn) {
		this.totalCalorieBurn = totalCalorieBurn;
	}

	
	public void writeToFile() {

		BufferedWriter bw = null;
		File file = new File("activityLogDetails.csv");

		if (!file.exists()) {
			try {
				bw = new BufferedWriter(new FileWriter("activityLogDetails.csv"));
				bw.write("NAME,WEIGHT,AGE,ACTIVITY,MILES,NET CALORIE BURN/MILE,"
						+ "TOTAL CALORIE BURN/MILE");
				bw.newLine();
				bw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		try {
			bw = new BufferedWriter(new FileWriter("activityLogDetails.csv", true));
			bw.write(ap.getName() + "," + ap.getWeight() + "," + ap.getAge() 
			+ "," + at.getActivity() + "," + at.getMiles() + "," + at.getBurnPerMile() 
			+ "," + at.getTotalCalorieBurn());
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public ActivePeople getAp() {
		return ap;
	}
	public void setAp(ActivePeople ap) {
		this.ap = ap;
	}
	public ActivityType activityLogDetails(String name, double weight, int age,
			String activity, double miles, double burnPerMile, 
			double totalCalorieBurn) {
		return new ActivityType();
	}
}