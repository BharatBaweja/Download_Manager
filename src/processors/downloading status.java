package url;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.*;

public class Download {

	String link;
	File out;

	public Download(String link, File out){
	 this.link = link;
	 this.out = out;
	}

public void run(){

	try{
		URl url = new URl(link);
				HttpURLConnection http = (HttpURLConnection)url.openConnectio();
				double fileSize = (double)http.getContentLengthLong();
				BufferedInputStream in = new BufferedInputStream(http.getInputStream());
				FileOutputStream fos = new FileOutputStream(this.out);
				BufferedOutputStream bout = new BufferedOutputStream();
				byte[] buffer = new byte[1024];
				double downloaded = 0.00;
				int read = 0;
				double percentdownloaded = 0.00;
				while((read = in.read(buffer, 0, 1024))>=0){
					bout.write (buffer,0,read);
					downloaded += read;
					percentdownloaded = (downloaded*100)/fileSize;
					String percent = String.format("%.4f",percentdownloaded);
					System.out.println("Downloaded" +percent + "% of a file.");
		        }
				bout.close();
				in.close();
				System.out.println("Download complete.");
		      }
			catch(IOExeption ex) {
				ex.printStackTrace();
		}
	}