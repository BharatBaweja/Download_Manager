package com.ncu.processors;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;



public class FileDownloadTest {

public static void main(String[] args) {


 String dirName = "C:\\Downloads";

 try {

 saveFileFromUrlWithJavaIO(
 dirName + "\\ \\  ","");//file name with format, url

 saveFileFromUrlWithCommonsIO(
 dirName + "https://www.google.co.in/search?hl=en&tbm=isch&source=hp&biw=1242&bih=597&ei=-hNlXMDvLZSQwgOtxbCYAw&q=java&oq=java&gs_l=img.3..0l10.126.508..1196...0.0..1.511.1533.3-2j1j1......0....1..gws-wiz-img.....0.9_1b0zfbUwc#imgrc=rT8rqQKh8jt3DM:",
 "http://iiti.ac.in/people/~tanimad/JavaTheCompleteReference.pdf");

 } catch (MalformedURLException e) {
 e.printStackTrace();
 } catch (IOException e) {
 e.printStackTrace();
 }

}
 public static void saveFileFromUrlWithJavaIO(String fileName, String fileUrl)
 throws MalformedURLException, IOException {
 BufferedInputStream in = null;
 FileOutputStream fout = null;
 try {
 in = new BufferedInputStream(new URL(fileUrl).openStream());
 fout = new FileOutputStream(fileName);

byte data[] = new byte[1024];
 int count;
 while ((count = in.read(data, 0, 1024)) != -1) {
 fout.write(data, 0, count);
 }
 } finally {
 if (in != null)
 in.close();
 if (fout != null)
 fout.close();
 }
}
public static void saveFileFromUrlWithCommonsIO(String fileName,String url) throws MalformedURLException,IOException
