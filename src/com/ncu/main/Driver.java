package com.ncu.main;
import com.ncu.exceptions.*;
import com.ncu.validators.*;
import com.ncu.processors.*;
import java.util.*;
import java.io.*;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

//Main driver program
class Driver{
	static String log4jConfigFile = System.getProperty("user.dir") + File.separator + "configs\\logger\\logger.properties"; 
	static Logger logger;
	public static void main(String... args){
		Validator check = new Validator();
		String url;
		String status;
		
		String outputDirectory;
		Scanner in = new Scanner(System.in);
		System.out.println("---------------------------------");
		System.out.println("\t DOWNLOAD MANAGER");
		System.out.println("---------------------------------");
		logger = Logger.getLogger(Driver.class);

    	PropertyConfigurator.configure(log4jConfigFile);
		logger.info("\n Please copy the link:\n");
		url = in.nextLine();
		logger.info("\n Please enter outputDirectory: \n");
		outputDirectory = in.nextLine();
		//validate the output Directory and URL
		check.Test(url,outputDirectory);
		if(check.Test(url,outputDirectory)==false){
		logger.info("Please enter correct details");
		logger.info("Please enter the correct link");
		url = in.nextLine();
		logger.info("Please enter outputDirectory");
		outputDirectory = in.nextLine();
			
		}
		Download downLoad = new Download();
		try{
			downLoad.downloadFile(url,outputDirectory);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		if(check.Test(url,outputDirectory)==true){
			status="Success";
	}
			else{
				status="Fail";
			}
		CreateFile obj = new CreateFile();
		obj.New(url,status);
	}
}