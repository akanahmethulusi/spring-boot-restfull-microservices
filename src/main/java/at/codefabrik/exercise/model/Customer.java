package at.codefabrik.exercise.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
    private String id;
    private String firstname;
    private String lastname;
    public Customer() {
    }
}
