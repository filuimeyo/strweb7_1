package by.iba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {
    private int id;
    private String name;
    private String phone;
    private String email;


    public Person(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public Person(Person person) {
        this.id = person.id;
        this.name = person.name;
        this.phone = person.phone;
        this.email = person.email;
    }




}
