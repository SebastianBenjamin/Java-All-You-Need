package org.example;

import jakarta.persistence.*;

@Entity
@Table(name ="students_data")
public class Student {
    public Student(){

    }
    public Student(String id, String firstName, String lastName, String email, String date) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.date=date;
        this.id= id;
    }
    @Id //primary key
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private String id;
    @Column(name="First_Name")
    private String firstName;
    @Column(name="Last_Name")
    private String lastName;
    @Column(name="Email")
    private String email;
    @Column(name="date")
    private String date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
