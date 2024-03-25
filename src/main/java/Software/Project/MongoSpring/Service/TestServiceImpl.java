package Software.Project.MongoSpring.Service;
import Software.Project.MongoSpring.Exception.TestCollectionException;
import Software.Project.MongoSpring.Test1.TestClass1;
import Software.Project.MongoSpring.Test2.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;
import java.util.Optional;

@Service
public class TestServiceImpl implements TestService{
    @Autowired
    private TestRepository testRepo;
    @Override
    public void createTest(TestClass1 tests) throws SQLIntegrityConstraintViolationException, TestCollectionException {
        Optional<TestClass1>testOptional = testRepo.findByTest(tests.getTest());
        if (((Optional<?>) testOptional).isPresent()){
            throw new TestCollectionException(TestCollectionException.TestAlreadyExists());
        }else{
            tests.setCreatedAt(new Date(System.currentTimeMillis()));
            testRepo.save(tests);
    }
}
}

