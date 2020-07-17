package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CSV {
//this method read a CSV file and return a list
	public static List<String[]> read (String file) {
		List<String[]> data = new LinkedList<String[]>();
		String dataRow;
		try {
			BufferedReader bf= new BufferedReader(new FileReader(file));
			
			
			while ((dataRow = bf.readLine())!=null){
			String [] dataRecords = dataRow.split(",");
			data.add(dataRecords);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Could not find the file!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Could not read the file");
			e.printStackTrace();
		}
		return data;
	}
}
