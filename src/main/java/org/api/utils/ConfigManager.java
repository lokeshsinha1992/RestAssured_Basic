package org.api.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

	private static ConfigManager manager;
	private final Properties prop = new Properties();

	private ConfigManager() throws IOException {

//		InputStream inputStream = ConfigManager.class.getResourceAsStream(".resources/config.properties");
//		prop.load(inputStream);
//		System.out.println("Inside config mange" + inputStream.toString());
		
		
		
		try {
			FileInputStream ip = new FileInputStream("./resources/config.properties");
			
			try {
				
				prop.load(ip);		
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Configuration properties not found");
		}
		

	}

	public static ConfigManager getInstance(){
		if(manager==null){
			synchronized (ConfigManager.class){
				try {
					manager = new ConfigManager();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return manager;
	}



	public String getString(String key){
		return System.getProperty(key,prop.getProperty(key));
	}
}
