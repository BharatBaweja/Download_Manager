package com.ncu.validators;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;
import java.lang.*;
import exceptions.*;

// Java program to validate an url in Java
class URLValidator
{
	public static final String URL_REGEX =
			"^((((https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))" +
			"(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)" +
			"([).!';/?:,][[:blank:]])?$";
	Pattern URL_PATTERN = Pattern.compile(URL_REGEX);
	boolean urlValidator(String url)  throws UrlException 
	{ 
		Matcher matcher = URL_PATTERN.matcher(url);
		boolean match= matcher.matches();
	 try{
		 if (url == null||match == false)
			return false;
	    
	     }
	catch(UrlException e){
	System.out.println(" Exception: " +e.getMessage());
    }
}
}
 
class CheckIfDirectoryExists
 {
	public boolean CheckIfDirectoryExists(String outputDirectory) throws PathException
	{       
         
        try{
			 File dir = new File(outputDirectory);
             // Tests whether the directory denoted by this abstract pathname exists.
    		 boolean exists = dir.exists();
        	 return exists;  

			 if(exists == false ){}
			}
		catch(PathException e)
		{
			System.out.println("Exception: "+e.getMessage());
		}
	}	
			
}

public    class TestValidator{
	public static void main(String args[])
	{
		URLValidator url1 = new URLValidator();
		String url = "https:/www.github.c/";
		boolean urlVal = url1.urlValidator(url);
		// Validate an url
		if (urlVal) {
			System.out.print("The URL " + url + " is valid");
		}
		else {
			System.out.print("The URL " + url + " isn't valid");
		}
		CheckIfDirectoryExists chkDirect = new CheckIfDirectoryExists();
		boolean chk = chkDirect.CheckIfDirectoryExists("sdiuugvig");
		if (chk) {
			System.out.println("The path  is valid");
		}
		else {
			System.out.println("The path  isn't valid");
		}
	





	}
}