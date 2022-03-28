package COVID_Sort;

/*
 * Get's COVID Data for all countries
 * 
 * It believe it's the current day's totals, 
 * but may be the previous day's
 * 
 * It gets the data from a Rest API and then 
 * parses it into an ArrayList of CountryCOVID objects
 * 
 * source for data:
 * https://documenter.getpostman.com/view/10808728/SzS8rjbc?version=latest#00030720-fae3-4c72-8aea-ad01ba17adf8
 * specific URL for JSON
 * https://api.covid19api.com/summary
 * 
 */

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSON_COVID_Data {

	private ArrayList<CountryCOVID> data;
	
	public JSON_COVID_Data() {
		this.data = new ArrayList<CountryCOVID>();
		getJSON();
	}
	
	
	public void getJSON() {
		try {
			//create URL object from a string
			URL url = new URL("https://api.covid19api.com/summary");
			
			//cast URL object to HttpURLConnection
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");	//we are getting (not sending or downloading)
			conn.connect();

			// Getting the response code
			int responsecode = conn.getResponseCode();
			
			//Check for possible response error codes
			if (responsecode == 429) {
				throw new RuntimeException("HttpResponseCode: " + responsecode);
			} else {

				String rawJSON = "";  //stores JSON as raw text
				Scanner scanner = new Scanner(url.openStream());  //set to scan from the url stream

				// Write all the JSON data into a string using a scanner
				while (scanner.hasNext()) {
					rawJSON += scanner.nextLine();
				}

				// Close the scanner
				scanner.close();
				//System.out.println(rawJSON);
				
				JSONParser parse = new JSONParser();  //create the parsing object
				// Using the JSON simple library parse the rawJSON String into a JSON object
				JSONObject json = (JSONObject) parse.parse(rawJSON);
				JSONArray countries = (JSONArray) json.get("Countries");
				
				
				
				for (int i = 0; i < countries.size(); i++) {
					JSONObject country = (JSONObject) countries.get(i);
					data.add(new CountryCOVID((String) country.get("Country"), 
											  (String) country.get("CountryCode"), 
											  (String) country.get("Slug"), 
											  ((Long) country.get("NewConfirmed")).intValue(), 
											  ((Long) country.get("TotalConfirmed")).intValue(),
											  ((Long) country.get("NewDeaths")).intValue(), 
											  ((Long) country.get("TotalDeaths")).intValue(),
											  ((Long) country.get("NewRecovered")).intValue(), 
											  ((Long) country.get("TotalRecovered")).intValue(), 
											  (String) country.get("Date")));
																  
				}
				
			}

		} catch (Exception e) {
			e.printStackTrace();  //prints the error codes if the try fails
		}
		
		
		
	}
	
	
	public ArrayList<CountryCOVID> getList() {
		return data;
	}
	
	
	
	
	//Returns list of country data between the given parameters (inclusive)
	public String printRange(int indexLow, int indexHigh) {
		//check that parameters indicate a viable range
		if (indexLow >= indexHigh || indexLow < 0 || indexHigh >= this.data.size()) {
			return "/n/n    Bad Print Range";
		}
		
		String str = "";
		str += "   Country                          Code  Slug                               New Cases   Total Cases   New Deaths   Total Deaths  New Recovered  Total Recovered            Date\n";
		str += "==============================================================================================================================================================================================\n";
		for (int i = indexLow; i <= indexHigh; i++) {
			str += this.data.get(i) + "\n";
		}
		str += "==============================================================================================================================================================================================\n";
		return str;
	}
	
	
	
	
	@Override
	public String toString() {
		String str = "";
		str += "   Country                          Code  Slug                               New Cases   Total Cases   New Deaths   Total Deaths  New Recovered  Total Recovered            Date\n";
		str += "==============================================================================================================================================================================================\n";
		for (CountryCOVID country : data) {
			str += country + "\n";
		}
		str += "==============================================================================================================================================================================================\n";
		return str;
	}
	
	
}
