package CountryAPI.restAPI;

import org.springframework.web.bind.annotation.RestController;

import CountryAPI.Country;
import CountryAPI.CountryCrud;
import CountryAPI.CountryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.MediaType;

import java.util.List;

@RestController
public class CountryAPIController {
	private CountryService countryService;
	private CountryCrud countryRepository;

	@Autowired
	public CountryAPIController(CountryService countryService, CountryCrud countryRepository) {
		this.countryService = countryService;
		this.countryRepository = countryRepository;
	}

	@RequestMapping(path = "/superapp/countries/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void saveAllCountries() {
		List<Country> countries = countryService.getAllCountries();
		countryRepository.saveAll(countries);
	}

	@RequestMapping(path = "/country/{country}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Country saveAllCountries(@PathVariable("country") String country) {

		return countryService.getCountryByName(country);
	}
	
	
	
	
	

	@RequestMapping(path = "calingcode/{country}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String findCallingCodeByName(@PathVariable("country") String country) {

		return countryService.findCallingCodeByName(country);
	}

	@RequestMapping(path = "country/calingcode/{calingcode}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String findNameByCalingCode(@PathVariable("calingcode") String calingcode) {

		return countryService.findNameByCallingCode(calingcode);
	}

	@RequestMapping(path = "capital/{country}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String findCapitalByName(@PathVariable("country") String country) {

		String s = countryService.findCapitalByName(country);
		return s ;
	}

	@RequestMapping(path = "region/{country}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String findRegionByName(@PathVariable("country") String country) {

		return countryService.findRegionByName(country);
	}

	@RequestMapping(path = "flag/{country}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String findFlagByName(@PathVariable("country") String country) {

		return countryService.findFlagByName(country);
	}

}
