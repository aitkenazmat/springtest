package kz.hh.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employee")
@Data
public class Employee {
    @Id
    private String id;
    private String lname;
    private String fname;
    private Company company;
    private Department department;
}
