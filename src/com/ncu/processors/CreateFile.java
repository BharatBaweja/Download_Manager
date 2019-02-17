package com.ncu.processors;
import java.util.*;
import java.io.*;
import java.lang.*;
import com.ncu.processors.*;
public class CreateFile
{
  public void New(String fileName,String status)// void New(String url, String status )
   {
	 try{
	 	//String m =(System.getProperty("user.dir") + File.separator + "file"+ File.seperator + "file.txt"); 
		File obj = new File("C:\\Users\\Dell\\Desktop\\Download_Manager\\file\\file.txt");
		for(int i=1;i<=2;i++)
		{
			if(obj.exists())
			{
				break;
			}
			else
			{
				obj.createNewFile();
			}
			
		}

	  FileWriter myWriter = new FileWriter("C:\\Users\\Dell\\Desktop\\Download_Manager\\file\\file.txt");
      myWriter.write(fileName);
      myWriter.write("\t\t"+status);//myWriter.write("url\status")
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
      }

	  catch (IOException e) 
	  {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
	}
}
