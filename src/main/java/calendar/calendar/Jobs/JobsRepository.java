package calendar.calendar.Jobs;

import java.time.LocalDate;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JobsRepository extends MongoRepository<Jobs, String> {
        long countByDateBetween(LocalDate startOfMonth, LocalDate endOfMonth);  //create custom method to group by month

}
