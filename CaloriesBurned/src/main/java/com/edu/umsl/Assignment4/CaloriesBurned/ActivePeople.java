package com.edu.umsl.Assignment4.CaloriesBurned;

import java.util.Scanner;

public class ActivePeople {
	
	String name;
    static double weight;
	int age;
	public Scanner input;
	int selection;
	static ActivityType at = new ActivityType();
	
	
	public ActivePeople (String name, double weight, int age, 
			Scanner input, int selection, ActivityType at) {
		super();
		this.name = name;
		ActivePeople.weight = weight;
		this.age = age;
		this.input = input;
		this. selection = selection;
		ActivePeople.at = at;
	}
	public ActivePeople() {
	
	}
	public void Menu() {
		
		ActivityType at = new ActivityType();
		
		do{

			System.out.println();
			System.out.println("Menu of options: ");
			System.out.println();
			System.out.println("'1' Create/append to an Activity Log");
		    System.out.println("'2' Exit");
		    System.out.println();
		    System.out.print("Enter your selection here: ");
		    input = new Scanner(System.in);
		    selection = input.nextInt();
		    
		    if(selection !=1) {
		    break;
		     }
		    at.writeToFile();	
		} while (selection == 1);
	}
	
	public String getName() {
		System.out.print("Enter your name: ");
		input = new Scanner(System.in);
	    name = input.nextLine();
	    return name;
	}
	public double getWeight() {
		System.out.print("Enter your weight (in lbs): ");
		input = new Scanner(System.in);
	    weight = input.nextInt();
		return weight;
	}
	public int getAge() {
		System.out.print("Enter your age (in years): ");
		input = new Scanner(System.in);
	    age = input.nextInt();
		return age;
	}
	public Scanner getInput() {
		return input;
	}
	public int getSelection() {
		return selection;
	}
	public ActivityType getAt() {
		return at;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setWeight(double weight) {
		ActivePeople.weight = weight;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setInput(Scanner input) {
		this.input = input;
	}
	public void setSelection(int selection) {
		this.selection = selection;
	}
	public void setAt(ActivityType at) {
		ActivePeople.at = at;
	}
}
