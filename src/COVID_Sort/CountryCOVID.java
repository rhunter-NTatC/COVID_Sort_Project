package COVID_Sort;

/*
 * Stores a single countries COVID Data
 * 
 * I believe it's what was reported that day, 
 * but may be the previous day's data.
 * 
 * source for data:
 * https://documenter.getpostman.com/view/10808728/SzS8rjbc?version=latest#00030720-fae3-4c72-8aea-ad01ba17adf8
 * 
 * 
 */


public class CountryCOVID {

	private String country;
	private String countryCode;
	private String slug;
	private int newConfirmed;
	private int totalConfirmed;
	private int newDeaths;
	private int totalDeaths;
	private int newRecovered;
	private int totalRecovered;
	private String date;
	
	public CountryCOVID(String country,
						String countryCode,
						String slug,
						int newConfirmed,
						int totalConfirmed,
						int newDeaths,
						int totalDeaths,
						int newRecovered,
						int totalRecovered,
						String date) {
		
		this.country = country;
		this.countryCode = countryCode;
		this.slug = slug;
		this.newConfirmed = newConfirmed;
		this.totalConfirmed = totalConfirmed;
		this.newDeaths = newDeaths;
		this.totalDeaths = totalDeaths;
		this.newRecovered = newRecovered;
		this.totalRecovered = totalRecovered;
		this.date = date;
	}
	
	
	/*
	 * GETTER METHODS
	 */
	public String getCountry() { return country;}
	public String getCountryCode() { return countryCode;}
	public String getSlug() { return slug;}
	public int getNewConfirmed() { return newConfirmed;}
	public int getTotalConfirmed() { return totalConfirmed;}
	public int getNewDeaths() { return newDeaths;}
	public int getTotalDeaths() { return totalDeaths;}
	public int getNewRecovered() { return newRecovered;}
	public int getTotalRecovered() { return totalRecovered;}
	public String getdate() { return date;}
	
	
	@Override
	public String toString() {
		return String.format("   %-31s   %2s   %-32s %,11d   %,11d  %,11d    %,11d    %,11d    %,11d     %s",
							country, countryCode, slug, newConfirmed, totalConfirmed,
							newDeaths, totalDeaths, newRecovered, totalRecovered, date);
	}
	
	
}
