package com.bmicalculator;

public class MainOperations {
	String name;
	float weight;
	float height;
	float bmi;

	// Calculating BMI value based on the height in meters and weight in
	// kilograms
	public float bmiKgMeters(float weight, float height) {//
		this.weight = weight;
		this.height = height;
		float Bmi = weight / (height * height);
		return Bmi;
	}

	// Calculating BMI value based on the height in inches and weight in pounds
	public float bmiPoundsInches(float weight, float height) {
		this.weight = weight;
		this.height = height;
		float BMI = 703 * (weight / (height * height));
		return BMI;
	}

	// Calculating Height value based on the BMI and weight in kilograms
	public float calHeight(float bmi, float weight) {
		this.bmi = bmi;
		this.weight = weight;
		float height = weight / bmi;
		float exactHeight = (float) Math.sqrt(height);
		return exactHeight;
	}

	// Calculating the Weight based on the Height in meters and BMI value
	public float calWeight(float height, float bmi) {
		this.height = height;
		this.bmi = bmi;
		float weight = bmi * (height * height);
		return weight;
	}

}
