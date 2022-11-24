package Vtiger.GenericLibraries;

import java.util.Scanner;

public class ReverseAString {

	public static void main(String[] args) 
	{
		String rev = "";
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String Data: ");
		String Word = sc.next();
		int length = Word.length();
		System.out.println("The Length of the Word is: "+length);
		for (int i=length-1;i>=0;i--)
		{
			rev = rev+Word.charAt(i);
		}
		System.out.println("The Reverse of the String Data is: "+rev);
		
	}

}
