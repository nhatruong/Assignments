package assignment6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ParseMethod {
	public static void parse(File file){
	      RandomAccessFile input = null;
	      String line = null;
	      
	      try {
	          	input = new RandomAccessFile(file, "r");
	          	while ((line = input.readLine()) != null) {
	          		System.out.println(line);
	          }
	          return;
	      } 
	      catch(FileNotFoundException ex) {
	    	  
	      }
	      catch(IOException ex) {
	    	  
	      }
	      finally {
	            if (input != null) {
	              try {
					input.close();
				} catch (IOException e) {					
					
				}
	            }
	        }
	  }  

}
