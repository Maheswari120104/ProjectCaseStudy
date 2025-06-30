package com.hexaware.finance.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {
  public static String getPropertyString(String fileName) {
	  Properties props=new Properties();
	  try(InputStream input=PropertyUtil.class.getClassLoader().getResourceAsStream(fileName)){
		if(input==null) {
			throw new RuntimeException("unable to find"+fileName);
		}
		props.load(input);
		String host=props.getProperty("hostname");
		String port=props.getProperty("port");
		String db=props.getProperty("dbname");
		String user=props.getProperty("username");
		String pass=props.getProperty("password");
		return "jdbc:mysql://localhost:3306/financeManagement"+host+":"+port+"/"+db+"?user="+user+"&password="+pass;
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new RuntimeException("error reading property file"+e.getMessage());
	}
	  
  }
}
