package com.bmicalculator;

import java.util.Scanner;

//testing class no need to do anything 
public class FileStoring{
	
	public static void main(String[] args) {
		
//	public void fileDetails() {
//		try{
//	        FileWriter fw=new FileWriter("/Users/venkat/Desktop/Newtask/BMIcalculator/war/InternDetails.txt");
//	       ModifiedBMI obj = new ModifiedBMI();
//	      //  obj.addIntern();
//	        String val=obj.name+" "+obj.height+" "+obj.weight;
//	        fw.write(val);    
//	        fw.close();
//			}catch(IOException e){
//				System.out.println(e);
//			}
//		
//		finally{
//			System.out.println("==============");
//		}
		Scanner sc=new Scanner(System.in);
		
		while (true)
		{
		   // Get user input.
			System.out.println("Ener value : ");
		   String input = sc.nextLine();
		   

		   try
		   {
		     int side = Integer.parseInt(input);

		      break;
		   }
		   catch (NumberFormatException ex)
		   {
		      // Inform user of invalid input.
		     // System.out.println("Invalid input. Enter a natural number.");
		   }
		}
		
		}

	
	
	
	
}
