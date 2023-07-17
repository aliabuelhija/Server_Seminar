package CountryAPI;


import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface CountryCrud extends MongoRepository<Country, String> {
	Optional<Country> findByName(String name);
    
    @Query(value = "{'name': ?0}", fields = "{'callingCode': 1, '_id': 0}")
    Optional<String> findCallingCodeByName(String name);
    
    
    @Query(value = "{'callingCode': ?0}", fields = "{'name': 1, '_id': 0}")
    Optional<String> findNameByCallingCode(String callingCode);
    
    
    @Query(value = "{'name': ?0}", fields = "{'region': 1, '_id': 0}")
    Optional<String> findRegionByName(String name);
    
    
    @Query(value = "{'name': ?0}", fields = "{'capital': 1, '_id': 0}")
    Optional<String> findCapitalByName(String name);
    
    
    @Query(value = "{'name': ?0}", fields = "{'smallFlag': 1, '_id': 0}")
    Optional<String> getFlag(String name);
}
