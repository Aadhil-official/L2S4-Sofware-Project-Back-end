package Software.Project.MongoSpring.Service;

import Software.Project.MongoSpring.Exception.TestCollectionException;
import Software.Project.MongoSpring.Test1.TestClass1;

import java.sql.SQLIntegrityConstraintViolationException;

public interface TestService {
    public void createTset(TestClass1 tests) throws SQLIntegrityConstraintViolationException, TestCollectionException;

    void createTest(TestClass1 tests) throws SQLIntegrityConstraintViolationException, TestCollectionException;
}
