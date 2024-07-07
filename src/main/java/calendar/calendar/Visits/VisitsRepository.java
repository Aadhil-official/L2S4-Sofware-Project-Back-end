package calendar.calendar.Visits;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
// import java.time.Month;

@Repository
public interface VisitsRepository extends MongoRepository<Visits, String> {
    long countByDateBetween(LocalDate startOfMonth, LocalDate endOfMonth); //create custom method to group by month
}
