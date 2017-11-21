package assignment8;

import java.io.IOException;
import java.util.Scanner;

public class FileCounter{

	   private int characterCount, wordCount, lineCount;
	   
	   public FileCounter(){
	      
	   }

	   public void read(Scanner in) throws IOException {
		  // BufferedReader bR = new BufferedReader();
		   while(in.hasNextLine()){
			   String line= in.nextLine(); lineCount++;
			   String trimmedLine = line.trim();
			   characterCount+= trimmedLine.length();
			   String[] words=trimmedLine.split(" +");
			   wordCount+=words.length;
		   }
	   }
	   //count character
	   public int getCharacterCount() {
		   
		   return characterCount;
	   }
	   //count word
	   public int getWordCount() {
		   
		   return wordCount;
	   }
	   //count line
	   public int getLineCount() {
		   
		   return lineCount;
	   }
	    
}
