package Util_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class property_reader 
{
	public static Properties dataWarehouse;
	
	public static Properties reader() 
	{
	try {
		FileInputStream istream = new FileInputStream("./src/main/resources/dataWarehouse.properties");
		dataWarehouse = new Properties();
		dataWarehouse.load(istream);
	} 
	catch (FileNotFoundException e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	catch (IOException e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return dataWarehouse;
	}
}
