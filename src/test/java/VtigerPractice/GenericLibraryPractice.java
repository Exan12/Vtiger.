package VtigerPractice;

import java.util.Random;

public class GenericLibraryPractice {

	public static void main(String[] args) 
	{
		Random ran = new Random();
		int value1 = ran.nextInt(500);
		System.out.println(value1);
		
		int value2 = ran.nextInt(500);
		System.out.println(value2);
		GenericLibraryPractice.add(value1 , value2);
	}
	
	public static int add(int a,int b)
	{
		int c = a+b;
		System.out.println(c);
		return c;
	}

}
