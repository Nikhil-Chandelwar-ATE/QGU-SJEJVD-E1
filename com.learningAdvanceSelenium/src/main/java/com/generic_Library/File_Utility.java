package com.generic_Library;

import java.io.FileInputStream;
import java.util.Properties;

public class File_Utility {

	public static String getPropertyValue(String key) throws Throwable {
		
		//Java Representation Object of external file
				FileInputStream fis = new FileInputStream("./src/test/resources/commanData/commanData.properties");
				
				//Class which is used to work on properties file
				Properties prop = new Properties();
				
				//To load all the keys in Properties class
				prop.load(fis);
				
				String value = prop.getProperty(key);
				
				return value;
	}
}
