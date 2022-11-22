package VtigerPractice;

import Vtiger.GenericLibraries.PropertyFileLibrary;
import Vtiger.GenericLibraries.ExcelFileLibrary;
import Vtiger.GenericLibraries.JavaLibrary;

public class GeneralLibraryPractice {

	public static void main(String[] args) throws Throwable
	{
		JavaLibrary jLib = new JavaLibrary();
		PropertyFileLibrary pLib = new PropertyFileLibrary();
		ExcelFileLibrary eLib = new ExcelFileLibrary();
		
		// using java Library
		int rn = jLib.getRandomNumber();
		System.out.println(rn);
		
		String date = jLib.getSystemDate();
		System.out.println(date);
		
		String dateinformat = jLib.getSystemDateInFormat();
		System.out.println(dateinformat);
		
		// using Property file Library
		String BROWSER = pLib.getpropertyfile("browser");
		System.out.println(BROWSER);
		
		String USERNAME = pLib.getpropertyfile("username");
		System.out.println(USERNAME);
		
		String PASSWORD = pLib.getpropertyfile("password");
		System.out.println(PASSWORD);
		
		String URL = pLib.getpropertyfile("url");
		System.out.println(URL);
		
		// using Excel File Library
		String data = eLib.readDataFromExcel("Contacts",1,2);
		System.out.println(data);
		
		int count = eLib.getRowCount("Organization");
		System.out.println(count);
		
		eLib.writeDataToExcel("Organization", 8, 8, "I AM KIRAN");
		eLib.writeDataToExcel("Contacts", 4, 8 , "NAVEEN");
	}

}
