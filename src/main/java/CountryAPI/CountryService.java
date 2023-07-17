package CountryAPI;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CountryService {
    private RestTemplate restTemplate;
    private ObjectMapper objectMapper;
    private CountryCrud countryRepository;

    @Autowired
    public CountryService(RestTemplate restTemplate, ObjectMapper objectMapper, CountryCrud countryRepository) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
        this.countryRepository = countryRepository;
    }

    public List<Country> getAllCountries() {
        ResponseEntity<String> response = restTemplate.getForEntity(
                "https://countryapi.io/api/all?apikey=GGgJnrRFVQsWQ89P1uAiNgX70jr0bhIag2qSmUsS", String.class);
        try {
            Map<String, Country> countryMap = objectMapper.readValue(response.getBody(),
                    new TypeReference<Map<String, Country>>() {});
            return countryMap.values().stream().collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Country getCountryByName(String countryName) {
        String capitalizedFirstLetter = capitalizeFirstLetter(countryName);
        Optional<Country> country = countryRepository.findByName(capitalizedFirstLetter);
        return country.orElse(null);
    }

    public String findCallingCodeByName(String countryName) {
        String capitalizedFirstLetter = capitalizeFirstLetter(countryName);
        Optional<String> callingCode = countryRepository.findCallingCodeByName(capitalizedFirstLetter);
        return callingCode.orElse(null);
    }

    public String findNameByCallingCode(String callingCode) {
        Optional<String> countryName = countryRepository.findNameByCallingCode(callingCode);
        return countryName.orElse(null);
    }

    public String findCapitalByName(String countryName) {
        String capitalizedFirstLetter = capitalizeFirstLetter(countryName);
        Optional<String> capital = countryRepository.findCapitalByName(capitalizedFirstLetter);
        return capital.orElse(null);
    }

    public String findRegionByName(String countryName) {
        String capitalizedFirstLetter = capitalizeFirstLetter(countryName);
        Optional<String> region = countryRepository.findRegionByName(capitalizedFirstLetter);
        return region.orElse(null);
    }

    public String findFlagByName(String countryName) {
        String capitalizedFirstLetter = capitalizeFirstLetter(countryName);
        Optional<String> flag = countryRepository.getFlag(capitalizedFirstLetter);
        return flag.orElse(null);
    }

    private String capitalizeFirstLetter(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }
}
