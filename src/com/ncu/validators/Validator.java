package com.ncu.validators;
import java.util.regex.*;
import java.util.Properties;
import java.io.*;
import java.lang.*;
import com.ncu.exceptions.*; 
import org.apache.log4j.*;


public class Validator{
	String url;
	String outputDirectory;
	
		static final String URL_REGEX =
			"^((((https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))" +
			"(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)" +
			"([).!';/?:,][[:blank:]])?$";
	Pattern URL_PATTERN = Pattern.compile(URL_REGEX);
	private void  URLValidator(String url) throws UrlException
	{
	Matcher matcher = URL_PATTERN.matcher(url);
		boolean match= matcher.find();
		if(match==false || url==null)
		throw new UrlException(""); 
		}
		private void CheckDirectory(String outputDirectory) throws PathException{
			 File dir = new File(outputDirectory);
             // Tests whether the directory denoted by this abstract pathname exists.
    		 boolean exists = dir.exists();
    		 if(outputDirectory.length()==0||exists==false)
    		 	throw new PathException("");
		}
	public boolean Test(){
		Logger logger = Logger.getLogger(Validator.class);
		String log4jConfigFile = System.getProperty("user.dir")
			+ File.separator + "configs/logger/logger.properties";
		PropertyConfigurator.configure(log4jConfigFile);
		Properties prop = new Properties();

			//Validator v = new Validator();
			try{
			URLValidator(url);
			CheckDirectory(outputDirectory);
			}
			catch(UrlException e){
				logger.error("\n\n" +e+prop.getProperty("UrlException")+"\n");		
			}
			catch(PathException e){
			 logger.error("\n\n" +e+prop.getProperty("PathException")+"\n");;
			}
		return false;
	}
}