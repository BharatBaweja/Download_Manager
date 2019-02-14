package src .main;
import src.exceptions.*;
import src.validators.*;
import src.processor.*;
import java.util.*;
//Main driver program
class Driver{
	public static void main(String args[]){
		String url;
		String outputDirectory;
		Scanner in = new Scanner(System.in);
		System.out.println("---------------------------------");
		System.out.println("\t DOWNLOAD MANAGER");
		System.out.println("---------------------------------");
		System.out.println("Please copy the link");
		url = in.nextLine();
		//for validating the url
		URLValidator linkValidator = new URLValidator();
		boolean linkVal = linkValidator.urlValidator(url);
		/*if(linkVal)
			System.out.println("Link is valid");
		else{
			System.out.println("Link is not valid");
			System.out.println("Please enter a valid link");
			url = in.nextLine();
		}*/
		//for validating the path
		System.out.println("Please enter the path for download");
		outputDirectory = in.nextLine();
		CheckIfDirectoryExists pathvalidator = new CheckIfDirectoryExists();
		boolean pathVal = pathValidator.CheckIfDirectoryExists(outputDirectory);
		/*if(pathVal)
			System.out.println("Path is valid");
		else{
			System.out.println("Path is not valid ,please enter a valid path");
			outputDirectory = in.nextLine();
		}*/

		FileDownloadTest download = new FileDownloadTest();

	}
}