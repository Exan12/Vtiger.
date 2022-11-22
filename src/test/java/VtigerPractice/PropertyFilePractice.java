package VtigerPractice;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFilePractice {

	public static void main(String[] args) throws Throwable 
	{
		// Load the file into java stream
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		
		// Create object of properties file
		Properties pobj = new Properties();
		
		// Load file input stream into properties
		pobj.load(fis);
		
		// use the keys to read values
		String BROWSER = pobj.getProperty("browser");
		System.out.println(BROWSER);
		
		String URL = pobj.getProperty("url");
		System.out.println(URL);
		
		String USERNAME = pobj.getProperty("username");
		System.out.println(USERNAME);
		
		String PASSWORD = pobj.getProperty("password");
		System.out.println(PASSWORD);
		
	}

}
