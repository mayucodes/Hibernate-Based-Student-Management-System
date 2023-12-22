package model;

// Import annotations from the Jakarta Persistence API
import jakarta.persistence.*;

// Declaring the class as an Entity, specifying the table name in the database
@Entity
@Table(name = "student")
public class Student {

    // Declaring the primary key field and specifying its generation strategy
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    // Declaring fields for first name, last name, and email
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    // Default constructor required by JPA
    public Student() {
    }

    // Parameterized constructor for creating a student with specific details
    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Getter and setter methods for each field

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    // Overriding the toString() method to provide a meaningful string representation of the object
    @Override
    public String toString() {
        return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
    }
}
