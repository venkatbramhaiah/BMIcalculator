package com.logicalPractice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class RevereseOperations {
public static void main(String[] args) {

/* ========= REVERESE AN ARRAY ==========*/	
	
	String arr[]={"Venkat", "Naveen","Yarramneedi"};
	System.out.println("Before reverese =="+Arrays.toString(arr));
	List<String> list=Arrays.asList(arr);
	Collections.reverse(list);
	String reverese[]=list.toArray(arr);
	System.out.println("After reverese ==="+Arrays.toString(reverese));
	
/* =========   REVERESE AN STRING WITHOUT USING THE PREDIFINED METHODS ============== */	
	
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter a string ");
	String str=sc.next();
	System.out.println("Before reverese == "+str);
	String rev="";
	for(int i=str.length()-1; i>=0;i--){
		rev=rev+str.charAt(i);
	}
	 System.out.println("AFter reverese == "+rev);
	 
}
}
