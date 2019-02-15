import java.util.*;
import java.io.*;
import java.lang.*;


/*public String getTablePath() 
{
		return (System.getProperty("user.dir") + File.separator + "file");
}*/

public class CreateFile
{
  void New()// void New(String url, String status )
   {
	 try{
	 	//String m =(System.getProperty("user.dir") + File.separator + "file"+ File.seperator + "file.txt"); 
		File obj = new File("C:\\Users\\jdars\\Desktop\\Download_Manager\\file\\file.txt");
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

	  FileWriter myWriter = new FileWriter("C:\\Users\\jdars\\Desktop\\Download_Manager\\file\\file.txt");
      myWriter.write(" try ");//myWriter.write("url\tstaus")
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
class Try{
public static void main(String[] args)
{
	CreateFile cf = new CreateFile();
	cf.New();
	
}
}