package Software.Project.MongoSpring.Test2;
import Software.Project.MongoSpring.Test1.TestClass1;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TestRepository extends MongoRepository<TestClass1, String> {
@Query("{'test':  ?0}")
    Optional<TestClass1>findByTest(String test);
}
