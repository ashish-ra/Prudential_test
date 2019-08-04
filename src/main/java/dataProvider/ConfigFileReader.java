package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import enums.DriverType;

public class ConfigFileReader {
	
	
	// Class to read config properties stored at resources\\config.properties
	
	private Properties properties;
	private final String propertyFilePath = "resources\\config.properties";

	public ConfigFileReader() {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Properties file not found at path : " + propertyFilePath); 
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException ignore) {
			}
		}
	}


	public long getImplicitlyWait() {
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if (implicitlyWait != null) {
			try {
				return Long.parseLong(implicitlyWait);
			} catch (NumberFormatException e) {
				throw new RuntimeException("Not able to parse value : " + implicitlyWait + " in to Long");
			}
		}
		return 30;
	}

	public DriverType getBrowser() {
		String browserName = properties.getProperty("browser");
		if (browserName == null || browserName.equals("chrome"))
			return DriverType.chrome;
		else if (browserName.equalsIgnoreCase("firefox"))
			return DriverType.firefox;
		else if (browserName.equals("iexplorer"))
			return DriverType.ie;
		else
			throw new RuntimeException(
					"Browser Name Key value in Configuration.properties is not matched : " + browserName);
	}

}
