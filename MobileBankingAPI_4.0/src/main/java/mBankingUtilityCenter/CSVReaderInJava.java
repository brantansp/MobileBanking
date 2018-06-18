package mBankingUtilityCenter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVReaderInJava {

	public static final String delimiter = ",";

	public static void main(String[] args) throws IOException {
		csvReader("");
	}
	
	public static void csvReader(String path)
	{
		String csvFile = path ;
		//csvFile = "C:/Users/brantansp/Desktop/data.csv";
		String line = "";
		String cvsSplitBy = ",";
		Map<String, List<String>> list = new HashMap<String, List<String>>();
		List<String> lst = new ArrayList<String>();

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			String header = br.readLine();
			System.out.println("Key : " + header);
			int remLine = 0;
			while ((line = br.readLine()) != null) {
				String[] input = line.split(cvsSplitBy);
				for (int i = 0; i < input.length; i++) {
					lst.add(input[i]);
				}
				remLine++;
			}
			System.out.println("Value : " + lst);
			System.out.println("Total No.of Value : " + remLine);
			for (int i = 0; i < header.split(",").length; i++) {
				List<String> collq = new ArrayList<String>();
				for (int k = i; k < lst.size(); k = k+ header.split(",").length) {
					collq.add(lst.get(k));
					list.put(header.split(",")[i], collq);
				}
			}

			for (String Key : list.keySet()) {
				List<String> fruit = list.get(Key);
				System.out.println("\nKey :" + Key);
				System.out.println("Value : " + fruit);
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
}
