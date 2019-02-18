package com.ncu.processors;
import java.util.*;
import java.io.*;
import java.lang.*;
import com.ncu.processors.*;
public class CreateFile
{
  public void New(String fileName,String status)
   {
   
	 try{
	 	String m =(System.getProperty("user.dir") + File.separator + "file\\file.txt"); 
		File obj = new File(m);
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

	  FileWriter myWriter = new FileWriter(m, true);
	  BufferedWriter bout = new BufferedWriter(myWriter);
      bout.write( fileName+ "\t" + status +"\n");
      bout.newLine();
      bout.close();
      }
	  catch (IOException e) 
	  {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
	}
}
