package Datadriven.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class PropertiesConfig {

Properties p;
	
	public PropertiesConfig() {
		//loading file at run time
		File f=new File("./Configurations/config.properties");
		try {
		FileInputStream fis=new FileInputStream(f);
		p=new Properties();
		p.load(fis);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		}
	
	public String getData(String key)
	{
		return p.getProperty(key);
		
	}

	

}
