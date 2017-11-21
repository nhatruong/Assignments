package assignment8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class LyricAnalyzer {

	private HashMap<String, ArrayList<Integer>> map= new HashMap<String, ArrayList<Integer>>();
	private BufferedReader buffReader;
	private String currentLine;
	private String[] words;
	private ArrayList<Integer> arrList;
	private int previousLineLength=0;
	
	public void read(File file) throws IOException {
		buffReader = new BufferedReader(new FileReader(file));
		while ((currentLine = buffReader.readLine()) != null) {
			if(currentLine.length()==0) continue;
			currentLine =currentLine.trim();
			words=currentLine.split(" +"); 
			
			
			for(int i=0; i<words.length; i++) {
				add(words[i], i);					
			}
			
			//keep only previous line length after the first line
			previousLineLength+= words.length;					
		}			
	}
	
	private void add(String lyricWord, int wordPosition) {
		
		if(map.containsKey(lyricWord)) {//contains word
			if(wordPosition == words.length-1) { //store a negative integer for last word in a line
				map.get(lyricWord).add(-(wordPosition+1+ previousLineLength));
			}
			else { //store
				map.get(lyricWord).add(wordPosition+1 +previousLineLength);
			}
			
		}
		else {						
				arrList = new ArrayList<Integer>();
				if(wordPosition == words.length-1) {
					arrList.add(-(wordPosition+1 +previousLineLength));
				}
				else {
					arrList.add(wordPosition+1+ previousLineLength);					
				}
				map.put(lyricWord, arrList);							
		}	
	}
	public void displayWords() {
		Set<String> stringSet =map.keySet();
		
		Object[] arrayKey=stringSet.toArray();
		Arrays.sort(arrayKey);
	
		for(int i=0; i<map.size(); i++) {			
			System.out.print(((String)arrayKey[i]).toUpperCase()+"\t");
			System.out.println(map.get(arrayKey[i]).toString());			
		}
	}
	
	public void writeLyrics(File file) throws IOException {
		BufferedWriter bw =new BufferedWriter(new FileWriter(file));
		
		String[] stringArr= new String[previousLineLength+1];
		for(Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
			String key = entry.getKey();
		
			ArrayList<Integer> position = entry.getValue();
			for(int p : position) {
				if(p < 0) {
					stringArr[-1*p]=key+"\r\n";
				}
				else {
					stringArr[p]=key;
				}				
			}
		}
	
		for(String word: stringArr) {			
			if(word !=null ) {
				if(word.endsWith("\n")) {
					bw.write(word);
				}
				else {
					bw.write(word+" ");
				}
			}			
		}
		bw.close();
	}
	//return unique words in the file
	public int count() {
		ArrayList<String> keyCount= new ArrayList<String>();
		for(Map.Entry<String, ArrayList<Integer>> key :map.entrySet()) {
			String kString= key.getKey().toUpperCase(); 
						
			//System.out.println(kString);
			if(!keyCount.contains(kString))			
				keyCount.add(kString);	//store upper case keys in this temp arraylist	
		}
		return keyCount.size();
	}
	//most frequently used words
	public String mostFrequentWord() {
		int maxElement=0;
		String mostFrequentlyUsedWord="";
		
		for(Map.Entry<String, ArrayList<Integer>> entry :map.entrySet()) {
			String k =entry.getKey();
			if(entry.getValue().size() > maxElement) {
				maxElement = entry.getValue().size();
				mostFrequentlyUsedWord = entry.getKey();
			}		
			else if(entry.getValue().size() == maxElement) {
				mostFrequentlyUsedWord +=" "+entry.getKey()+" ";
			}
		}
		String[] temp=mostFrequentlyUsedWord.split("\\ ");
		Arrays.sort(temp);
		String finalString="";
		for(String i:temp) {
			finalString +=i+", ";
		}
		
		String s=finalString.substring(1, finalString.length()-2);
		return s;
	}
	
	public static void main(String[] args) throws IOException {
		LyricAnalyzer la = new LyricAnalyzer();
		File f= new File("files\\originalLyrics.txt");
		la.read(f);
		la.displayWords();
		
		
		la.writeLyrics(new File(f.getParent()+"\\newLyrics.txt"));
		System.out.println("unique words "+la.count());
		
		System.out.println("most fequently used words are" +la.mostFrequentWord());

	}

}
