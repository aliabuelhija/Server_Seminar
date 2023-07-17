package  CountryAPI;


import java.util.Map;

import com.fasterxml.jackson.annotation.JsonSetter;

public class Country {
    private String name;
    private String callingCode;
    private String region;
    private String capital;
    private String smallFlag;
    
    
	public Country() {

	}

	public Country(String name, String callingCode, String region, String capital, String smallFlag) {
		super();
		this.name = name;
		this.callingCode = callingCode;
		this.region = region;
		this.capital = capital;
		this.smallFlag = smallFlag;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCallingCode() {
		return callingCode;
	}


	public void setCallingCode(String callingCode) {
		this.callingCode = callingCode;
	}


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}


	public String getCapital() {
		return capital;
	}


	public void setCapital(String capital) {
		this.capital = capital;
	}


	public String getSmallFlag() {
		return smallFlag;
	}


	@JsonSetter("flag")
	public void setSmallFlag(Map<String, String> flag) {
	    this.smallFlag = flag.get("small");
	}

	
	
}

