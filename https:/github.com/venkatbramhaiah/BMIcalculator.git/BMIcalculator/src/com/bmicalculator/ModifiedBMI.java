package com.bmicalculator;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class ModifiedBMI extends MainOperations {
	 String name = "";
	float weight = 0.0f;
	float height = 0.0f;
	float bmi = 0.0f;

	public void verify(float value) {
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

	Scanner sc = new Scanner(System.in);
	static ModifiedBMI obj = new ModifiedBMI();
	PersonDetails obj1 = new PersonDetails();
	Map<String, Object> mp = new HashMap<String, Object>();
	Map<String, Float> mp1 = new HashMap<String, Float>();

	public float calBMI(float weight, float height) {
		this.height = height;
		this.weight = weight;
		float bmival = weight / (height * height);
		return bmival;
	}

	// public Float verifyNum(String message) {
	//
	// float val = .0f;
	// try {
	//
	// System.out.println(message);
	// val = Float.parseFloat(sc.next());
	//
	// } catch (Exception e) {
	// System.out.println("Please enter the valid input.........");
	// verifyNum(message);
	// }
	// return val;
	// }

	public Float verifyNum() {
		float val = .0f;
		try {
			val = Float.parseFloat(sc.next());
		} catch (Exception e) {
			System.out.println("Please enter the valid input.........");
			val = verifyNum();
		}
		return val;
	}

	void bmiKgMeter() {
		String message = "Enter  height of the person in inches...";
		System.out.println(message);
		height = verifyNum();
		//System.out.println(height);
		message = "Enter weight of the person in pounds...";
		System.out.println(message);
		weight = verifyNum();
		//System.out.println(weight);
		float output1 = obj.bmiPoundsInches(weight, height);
		obj.verify(output1);

	}

	// void bmiKgMeter() {
	// while (true) {
	// System.out.println("Enter  height of the person in inches ");
	// height = sc.nextFloat();
	// try {
	// System.out.println("Enter weight of the person in pounds ");
	// weight = sc.nextFloat();
	// float output1 = obj.bmiPoundsInches(weight, height);
	// obj.verify(output1);
	// // System.out.println("BMI value is " + output1);
	// } catch (InputMismatchException ex) {
	// System.out.println(" Enter valid values");
	// obj.bmiKgMeter();
	// }
	// }
	// }

	void bmiPoundInch() {
		String message = "Enter height of the persion in meters ";
		System.out.println(message);
		height = verifyNum();
		message = "Enter weight of the person in kilograms ";
		System.out.println(message);
		weight = verifyNum();
		float output2 = obj.bmiKgMeters(weight, height);
		obj.verify(output2);
		// System.out.println("BMI value is " + output2);
	}

	void calHeight() {
		String message = "Enter BMI value ";
		System.out.println(message);
		bmi = verifyNum();
		message = "Enter weight of the person in kilograms ";
		System.out.println(message);
		weight = verifyNum();
		float output3 = obj.calHeight(bmi, weight);
		System.out.println("The height of the persion in meters is " + output3);
	}

	void calWeight() {
		System.out.println("Enter height of the person in meters ");
		height = sc.nextFloat();
		System.out.println("Enter BMI value of the persion ");
		bmi = sc.nextFloat();
		obj.calWeight(height, bmi);
		System.out.println("The weight of the person in kilograms is " + weight);
	}

	String addIntern() {
		System.out.println("Enter name of the intern ");
		name = sc.next();
		System.out.println("Enter height of " + name + " in meters ");
		height = sc.nextFloat();
		System.out.println("Enter weight of " + name + " in kilograms ");
		weight = sc.nextFloat();
		float bmivlaue = obj.calBMI(weight, height);
		mp1.put(name, bmivlaue);
		obj1.setHeight(height);
		obj1.setWeight(weight);
		mp.put(name, obj1);
		String val = name;
		obj.fileDetails(name);
		System.out.println("Intern added successfully...");
		return val;
	}

	void displayIntern() {
		System.out.println("Enter name of the Intern to get the detials ");
		name = sc.next();
		Object details = mp.get(name);
		System.out.println("The heght of the " + name + " is " + ((PersonDetails) details).getHeight()
				+ " and wight is " + ((PersonDetails) details).getWeight());
		float height1 = ((PersonDetails) details).getHeight();
		float weight1 = ((PersonDetails) details).getWeight();
		float bmivlaue = obj.calBMI(weight1, height1);
		mp1.put(name, bmivlaue);
	}

	void calBMI() {
		System.out.println("Enter name of the intern to calculate the BMI value ");
		name = sc.next();
		float value = mp1.get(name);
		System.out.println("BMI value for " + name + " is " + value);
	}

	void terminate() {
		System.exit(0);
	}

	public int fileDetails(String name) {
		try {
			File fw = new File("/Users/venkat/Desktop/Newtask/BMIcalculator/war/InternDetails.txt");
			Object details = mp.get(name);
			FileWriter writer = new FileWriter(fw, true);
			writer.write("name " + name + " height : " + ((PersonDetails) details).getHeight() + " weight : "
					+ ((PersonDetails) details).getWeight() + "\n");
			// writer.flush();
			writer.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		return 0;
	}

	void displayAllIntern() throws IOException {
		
		FileReader fr = new FileReader("/Users/venkat/Desktop/Newtask/BMIcalculator/war/InternDetails.txt");
		int i;
		while ((i = fr.read()) != -1)
			System.out.print((char) i);
		fr.close();
	}

	public static void main(String[] args) throws IOException {

		while (true) {
			try {
				
				Scanner sc = new Scanner(System.in);
				int option = 0;
                 
				do {

					System.out.println("Enter your choice...");
					System.out.println("1.Calculate your BMI (given height(inch) and weight(pounds))");
					System.out.println("2.Calculate your BMI (given height(meter) weight(Kilogram))");
					System.out.println("3.Calculate your height (given BMI and weight)");
					System.out.println("4.Calculate your weight (given height and BMI)");
					System.out.println("5.Add an intern with his height(meter) and weight(Kilogram)");
					System.out.println("6.View height(meter) and weight(Kilogram) of interns");
					System.out.println("7.Calculate BMI value for a particular an intern");
					System.out.println("8.Display all the intern detials ");
					System.out.println("9.Exit");

					option = sc.nextInt();
					switch (option) {
					case 1:
						obj.bmiKgMeter();
						break;
					case 2:
						obj.bmiPoundInch();
						break;
					case 3:
						obj.calHeight();
						break;
					case 4:
						obj.calWeight();
						break;
					case 5:
						obj.addIntern();
						break;
					case 6:
						obj.displayIntern();
						break;
					case 7:
						obj.calBMI();
						break;
					case 8:
						obj.displayAllIntern();
						break;
					case 9:
						obj.terminate();
					default:
						System.out.println("====== you have to choose 1 to 8");
					}
				} while (true);
			} catch (InputMismatchException ex) {
				System.out.println("====== you have to choose 1 to 8");
			}

		}
	}
}
