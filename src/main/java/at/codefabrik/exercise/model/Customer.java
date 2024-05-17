package at.codefabrik.exercise.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
    private String id;
    //@NotBlank
    private String firstname;
    //@NotBlank
    private String lastname;
    public Customer() {
    }
}
