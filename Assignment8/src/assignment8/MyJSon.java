package assignment8;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;



public class MyJSon {
	private static ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
	private static BufferedReader bufferedReader;
	private static String currentLine;
	private static String[] words;
	private  static ArrayList<Vehicle> readAndGetVehicles(File file) throws NumberFormatException, IOException{
		
		bufferedReader = new BufferedReader(new FileReader(file));
		while ((currentLine = bufferedReader.readLine()) != null) {
			if(currentLine.length()==0) continue;
			currentLine =currentLine.trim();
			words=currentLine.split("~"); 			
			Vehicle vehicle= new Vehicle(words);	 
			vehicleList.add(vehicle);						
		}
		return vehicleList;	
	}
	public static String getJsonString(ArrayList<Vehicle> vehicles) {
		
		String jasonString="";
		for(int i=0;i<vehicles.size();i++) {
			Vehicle v= vehicles.get(i);
			
			jasonString+="\n{\n"
								+"\"id\" : " + "\""+v.id+"\""+",\n"
								+"\"category\" : " + "\""+v.category+"\""+",\n"
								+"\"year\" : " + "\""+v.year+"\""+",\n"
								+"\"make\" : " + "\""+v.make+"\""+",\n"
								+"\"model\" : " + "\""+v.model+"\""+",\n"
								+"\"trim\" : " + "\""+v.trim+"\""+",\n"
								+"\"type\" : " + "\""+v.type+"\""+",\n"
								+"\"price\" : " + "\""+v.price+"\""+",\n"
								+"\"photo\" : " + "\""+v.photo+"\""+",\n"
								+"},";
	
			if(i==vehicles.size()-1) {
				jasonString+=jasonString.substring(0, jasonString.length()-1)+"\n]\n}";
			}

		}
		return jasonString;
	}
	public static void writeToFile(String inputToWrite, String filePath) throws IOException {
		File file= new File(filePath+"\\vehicleRecord.txt");
		BufferedWriter bw =new BufferedWriter(new FileWriter(file));
		bw.write(inputToWrite);
		bw.close();
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		File file = new File("files\\vehicle.txt");
		ArrayList<Vehicle> vehicles=readAndGetVehicles(file);
		String s = getJsonString(vehicles);		
		writeToFile(s, file.getParent());		
	}

}

