package com.ncu.validators;
import java.util.regex.*;
import java.io.*;
import java.lang.*;
import com.ncu.exceptions.*; 

class Validator{
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
		boolean match= matcher.matches();
		if(match==false || url==null)
		throw new UrlException(""); 
		}
		private void CheckDirectory(String outputDirectory) throws PathException{
			 File dir = new File(outputDirectory);
             // Tests whether the directory denoted by this abstract pathname exists.
    		 boolean exists = dir.exists();
    		 if(outputDirectory.length()==0||exists==false)
    		 	throw new PathException("error");
		}
	public boolean Test(){
			//Validator v = new Validator();
			try{
			URLValidator(url);
			CheckDirectory(outputDirectory);
			}
			catch(UrlException e){
				e.printStackTrace();
			}
			catch(PathException e){
				e.printStackTrace();
			}
		return false;}

	}
	class TestValidator{
		public static void main(String args[]){
			Validator val = new Validator();
			String outputDirectory = "scss";
			String url = "https://www.techiedelight.com/validate-url-java/";
			System.out.println("SAA");
			System.out.println(val.Test()); 
		}
	}