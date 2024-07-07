package calendar.calendar.Agrements;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AgreementRepository extends MongoRepository<Agreement, String> {
    // Add custom query methods if needed
}

