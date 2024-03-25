package Software.Project.MongoSpring.Exception;

public class TestCollectionException extends Exception {
private static final long serialVersionUID = 1L;
public TestCollectionException(String message){
 super(message);
}
public static String NotFoundException(String id){
    return "Test with "+id+"not found!";
}
public static String TestAlreadyExists(){
    return "Test with given name already exists";
}
}
