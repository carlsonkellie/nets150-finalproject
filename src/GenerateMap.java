import java.io.*;
import java.util.*;

public class GenerateMap {

	private HashMap<String, HashMap<String, Double>> map = new HashMap<String, HashMap<String, Double>>();
	BufferedReader br;

	public GenerateMap(String filename) {
		try {
			br = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public HashMap<String, HashMap<String, Double>> tradeMap() {
		try {
			String line = br.readLine();
			while ((line = br.readLine()) != null) {
				String[] values = line.split("\",");
				String country = values[4];
				country = country.replaceAll("^\"|\"$", "");

				if (country.equals("United States of America") || country.equals("United Kingdom")
						|| country.equals("Turkey") || country.equals("Sweden") || country.equals("Singapore")
						|| country.equals("Philippines") || country.equals("Australia and New Zealand")
						|| country.equals("Netherlands") || country.equals("Mexico") || country.equals("Japan")
						|| country.equals("India") || country.equals("Hong Kong, China") || country.equals("Guatemala")
						|| country.equals("Germany") || country.equals("France") || country.equals("Costa Rica")
						|| country.equals("Colombia") || country.equals("Canada") || country.equals("Brazil")) {
					if (!map.containsKey(country)) {
						map.put(country, new HashMap<String, Double>());
					}
					HashMap<String, Double> partners = map.get(country);

					String partner = values[6].replaceAll("^\"|\"$", "");
					if (partner.equals("United States of America") || partner.equals("United Kingdom")
							|| partner.equals("Turkey") || partner.equals("Sweden") || partner.equals("Singapore")
							|| partner.equals("Philippines") || partner.equals("Australia and New Zealand")
							|| partner.equals("Netherlands") || partner.equals("Mexico") || partner.equals("Japan")
							|| partner.equals("India") || partner.equals("Hong Kong, China")
							|| partner.equals("Guatemala") || partner.equals("Germany") || partner.equals("France")
							|| partner.equals("Costa Rica") || partner.equals("Colombia") || partner.equals("Canada")
							|| partner.equals("Brazil")) {
						String value = values[values.length - 1].replaceAll("^\"|\"$", "");
						Double numValue = Double.parseDouble(value);
						partners.put(partner, numValue);

						System.out.print(country);
						System.out.print(" - " + partner);
						System.out.println(" : " + value);
					}
				}
			}
		} catch (IOException e) {

		}

		return map;
	}

	public HashMap<String, HashMap<String, Double>> airMap() {
		try {
			String line = br.readLine();
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				String origin = values[3];
				origin = origin.replaceAll("^\"|\"$", "");

				if (origin.equals("United States") || origin.equals("United Kingdom") || origin.equals("Turkey")
						|| origin.equals("Sweden") || origin.equals("Singapore") || origin.equals("Philippines")
						|| origin.equals("Australia") || origin.equals("New Zealand") || origin.equals("Netherlands")
						|| origin.equals("Mexico") || origin.equals("Japan") || origin.equals("India")
						|| origin.equals("Hong Kong") || origin.equals("Guatemala") || origin.equals("Germany")
						|| origin.equals("France") || origin.equals("Costa Rica") || origin.equals("Colombia")
						|| origin.equals("Canada") || origin.equals("Brazil")) {
					if (!map.containsKey(origin)) {
						map.put(origin, new HashMap<String, Double>());
					}

					HashMap<String, Double> destinations = map.get(origin);

					String destination = values[5].replaceAll("^\"|\"$", "");
					if (destination.equals("United States") || destination.equals("United Kingdom") || destination.equals("Turkey")
							|| destination.equals("Sweden") || destination.equals("Singapore") || destination.equals("Philippines")
							|| destination.equals("Australia") || destination.equals("New Zealand")
							|| destination.equals("Netherlands") || destination.equals("Mexico") || destination.equals("Japan")
							|| destination.equals("India") || destination.equals("Hong Kong") || destination.equals("Guatemala")
							|| destination.equals("Germany") || destination.equals("France") || destination.equals("Costa Rica")
							|| destination.equals("Colombia") || destination.equals("Canada") || destination.equals("Brazil")) {
						if (destinations.containsKey(destination)) {
							Double numFlights = destinations.get(destination);
							numFlights++;
							destinations.put(destination, numFlights);
						} else {
							destinations.put(destination, 1.0);
						}

						 System.out.print(origin);
						 System.out.println(" - " + destination);
					}
				}
			}
		} catch (IOException e) {

		}
		return map;
	}
}
