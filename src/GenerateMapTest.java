import java.io.*;
import java.util.HashMap;

public class GenerateMapTest {

	public static void main(String[] args) {
		GenerateMap tradeMap = new GenerateMap("Trade Data.csv");
		HashMap<String, HashMap<String, Double>> filteredMap = tradeMap.tradeMap();
		
		FileWriter csvWriter;
		try {
			csvWriter = new FileWriter("TradeFiltered.csv");
			csvWriter.append("Country 1");
			csvWriter.append(",");
			csvWriter.append("Country 2");
			csvWriter.append(",");
			csvWriter.append("Trade Value");
			csvWriter.append("\n");
			
			for (String partners: filteredMap.keySet()) {
				HashMap<String, Double> partnerSet = filteredMap.get(partners);
				for (String partner : partnerSet.keySet()) {
					double value = partnerSet.get(partner);
					
					csvWriter.append(partners + ",");
					csvWriter.append(partner + ",");
					csvWriter.append(value + "\n");
				}
			}
			
			csvWriter.flush();
			csvWriter.close();
			
		} catch (IOException e) {
			
		}
		
		GenerateMap airMap = new GenerateMap("Airline.csv");
		airMap.airMap();
		
		FileWriter csvWriter1;
		try {
			csvWriter1 = new FileWriter("AirFiltered.csv");
			csvWriter1.append("Country 1");
			csvWriter1.append(",");
			csvWriter1.append("Country 2");
			csvWriter1.append(",");
			csvWriter1.append("Trade Value");
			csvWriter1.append("\n");
			
			for (String partners: filteredMap.keySet()) {
				HashMap<String, Double> partnerSet = filteredMap.get(partners);
				for (String partner : partnerSet.keySet()) {
					double value = partnerSet.get(partner);
					
					csvWriter1.append(partners + ",");
					csvWriter1.append(partner + ",");
					csvWriter1.append(value + "\n");
				}
			}
			
			csvWriter1.flush();
			csvWriter1.close();
			
		} catch (IOException e) {
			
		}
	}

}
