package Software.Project.MongoSpring.controller;

import Software.Project.MongoSpring.Exception.TestCollectionException;
import Software.Project.MongoSpring.Service.TestService;
import Software.Project.MongoSpring.Test1.TestClass1;
import Software.Project.MongoSpring.Test2.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class TestController {
    @Autowired
    private TestRepository testRepo;
    @Autowired
    private TestService testService;
    @GetMapping("/tests")
    public ResponseEntity<?> getAllTests(){
        List<TestClass1> tests = testRepo.findAll();
        if (tests.size()>0){
            return new ResponseEntity<List<TestClass1>>(tests, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("No data available", HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/tests")
    public ResponseEntity<?> createTest(@RequestBody TestClass1 tests){
try{

    testService.createTest(tests);
    return new ResponseEntity<TestClass1>(tests,HttpStatus.OK);
}
catch(SQLIntegrityConstraintViolationExceptionException e){
    return new ResponseEntity<>(e.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);
}
catch(TestCollectionException e){
    return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
}
    }

    @GetMapping("/tests/{id}")
    public ResponseEntity<?> getSingleTest(@PathVariable("id")String id){
        Optional<TestClass1>testOptional= testRepo.findById(id);
if(testOptional.isPresent()){
    return new ResponseEntity<>(testOptional.get(),HttpStatus.OK);
}
else{
    return new ResponseEntity<>("Test not found with id"+id,HttpStatus.NOT_FOUND);
}
    }
    @PutMapping("/tests/{id}")
    public ResponseEntity<?> updateById(@PathVariable("id")String id,@RequestBody TestClass1 tests){
        Optional<TestClass1>testOptional= testRepo.findById(id);
        if(testOptional.isPresent()){
           TestClass1 testToSave=testOptional.get();
           //testToSave.setCompleted(tests.getCompleted() !=null ? tests.getCompleted() : testToSave.getCompleted());
            testToSave.setTest(tests.getTest() != null ? tests.getTest() : testToSave.getTest());
            testToSave.setDescription(tests.getDescription() != null ? tests.getDescription() : testToSave.getDescription());
            testToSave.setUpdatedAT(new Date(System.currentTimeMillis()));
            testRepo.save(testToSave);
            return new ResponseEntity<>(testToSave,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Test not found with id"+id,HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/tests/{id}")
    public ResponseEntity<?>deteleById(@PathVariable("id")String id){
        try{
            testRepo.deleteById(id);
            return new ResponseEntity<>("Successfully deleted with id :"+id,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
