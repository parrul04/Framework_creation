package com.framework.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private Properties prop;
	
	String path = "./src/test/resources/config/config.properties";
	
	/**
	 * This method will read the config.properties file
	 * @return it returns Properties object prop
	 */
	public Properties init_prop() {
		
		prop = new Properties();
		
		try {
			FileInputStream file =new FileInputStream(path);
			prop.load(file);
		}
		catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} 
		catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return prop;
	}
	
//	public String getReportConfigPath(){
//		String reportConfigPath = prop.getProperty("reportConfigPath");
//		if(reportConfigPath!= null) return reportConfigPath;
//		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
//	}
	
	

}
