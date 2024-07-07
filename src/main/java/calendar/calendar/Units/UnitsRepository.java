package calendar.calendar.Units;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UnitsRepository extends MongoRepository<Units, String> {
    
}
