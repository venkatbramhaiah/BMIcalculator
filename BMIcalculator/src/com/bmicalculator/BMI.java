package com.bmicalculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BMI {
	String name;
	float weight;
	float height;

	public float detials(float weight, float height) {
		this.weight = weight;
		this.height = height;
		float Bmi = weight / (height * height);
		return Bmi;
	}
	public static void verify(String name, float value) {

		if (value <= 18.5) {
			System.out.println(name + "BMI  is " + value + " it is  Underweight");
		} else if (value > 18.5 && value <= 24) {
			System.out.println(name + " BMI is " + value + " it is  Normal");
		} else if (value > 24 && value <= 29) {
			System.out.println(name + "BMI is " + value + " it is  Overweight");
		} else {
			System.out.println(name + "BMI is " + value + " it is  Obese");
		}
	}

	public static void main(String[] args) {

		Map<String, Float> mp = new HashMap<String, Float>();

		Scanner sc = new Scanner(System.in);
		String name = "";
		float weight = 0.0f;
		float height = 0.0f;

		int option = 0;

		do {
			System.out.println("Choose Option...");
			System.out.println("1. Name");
			System.out.println("2. Weight Kilograms");
			System.out.println("3. Person in Meters(Exit)");

			option = sc.nextInt();

			if (option == 1 || option == 2) {
				System.out.println("Enter the Name :");
				name = sc.next();
				Float value = mp.get(name);
				if (value == null) {
					
					System.out.println("Enter the weight in KiloGrams : ");
					weight = sc.nextFloat();
					System.out.println("Enter the height of the person in Meters : ");
					height = sc.nextFloat();

					BMI obj = new BMI();
					value = obj.detials(weight, height);
					verify(name, value);
					mp.put(name, value);
				} else {
					verify(name, value);
				}
			} else {
				name = null;
				System.out.println("Completed.....");
			}
		} while (name != null);
	}

}
