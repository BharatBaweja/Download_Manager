package com.ncu.main;
import com.ncu.exceptions.*;
import com.ncu.validators.*;
import com.ncu.processors.*;
import java.util.*;
import java.io.*;
//Main driver program
class Driver{
	public static void main(String args[]){
		Validator check = new Validator();
		String url;
		String outputDirectory;
		Scanner in = new Scanner(System.in);
		System.out.println("---------------------------------");
		System.out.println("\t DOWNLOAD MANAGER");
		System.out.println("---------------------------------");
		System.out.println("Please copy the link");
		url = in.nextLine();
		System.out.println("Please enter outputDirectory");
		outputDirectory = in.nextLine();
		//validate the output Directory and URL
		check.Test();
		Download downLoad = new Download();
		try{
			downLoad.downloadFile(url,outputDirectory);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	
	}
}