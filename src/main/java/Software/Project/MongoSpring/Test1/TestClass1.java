package Software.Project.MongoSpring.Test1;

import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "test1")
public class TestClass1 {
    @Id
    private String id;

    @NotNull(message="Test cannot be null")
    private String test;

    @NotNull(message="Description cannot be null")
    private String description;

    @NotNull(message="Completion cannot be null")
    private Boolean completed;
    private Date createdAt;
    private Date updatedAt;


}
