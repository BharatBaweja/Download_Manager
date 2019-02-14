package com.ncu.validators;
import java.util.regex.*;
import java.io.*;
import java.lang.*;
import com.ncu.exceptions.*; 

class Validator{
		static final String URL_REGEX =
			"^((((https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))" +
			"(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)" +
			"([).!';/?:,][[:blank:]])?$";
	Pattern URL_PATTERN = Pattern.compile(URL_REGEX);
	private void  URLValidator(String url) throws UrlException{
	Matcher matcher = URL_PATTERN.matcher(url);
		boolean match= matcher.matches();
		if(match==false || url==null)
		throw new UrlException(""); 
		}
		private void CheckDirectory(String outputDirectory) throws PathException{
			 File dir = new File(outputDirectory);
             // Tests whether the directory denoted by this abstract pathname exists.
    		 boolean exists = dir.exists();
    		 if(outputDirectory==null||exists==false)
    		 	throw new PathException("");
		}
	}