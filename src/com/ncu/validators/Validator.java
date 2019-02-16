package com.ncu.validators;
import java.util.regex.*;
import java.util.Properties;
import java.io.*;
import java.io.FileInputStream;
import java.lang.*;
import com.ncu.exceptions.*; 
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;




 public class Validator{
	String url;
	String outputDirectory;
	String configMessages = System.getProperty("user.dir")+ File.separator + "configs\\constants\\Exception.properties";
	InputStream input ;
	Properties prop = new Properties();
	
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
	public boolean Test(String url,String outputDirectory){
		Logger logger = Logger.getLogger(Validator.class);
		String log4jConfigFile = System.getProperty("user.dir")
			+ File.separator + "configs\\logger\\logger.properties";
		PropertyConfigurator.configure(log4jConfigFile);

			try{
			input = new FileInputStream(configMessages);
			prop.load(input);
			URLValidator(url);
			CheckDirectory(outputDirectory);

			}

			catch(UrlException e){
				logger.error("\n\n" +e+prop.getProperty("UrlException")+"\n");	
				return false;	
			}
			catch(PathException e){
			 logger.error("\n\n" +e+prop.getProperty("PathException")+"\n");
			 return false;
			}
			catch(Exception e){
			logger.error("\n"+e+"\n"+"\n");
			return false;
		}		
		return true;
	}
}
/*class TestValidator{
	public static void main(String args[]){

		Validator val = new Validator();
		String url = "https:/www.youtube.com/";
		String outputDirectory = "C:\\Users\\Dell\\Desktop\\Download_Manager";
		val.Test(url,outputDirectory);
	}
}*/