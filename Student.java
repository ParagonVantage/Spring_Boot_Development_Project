import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;
    
    @Min(value = 10, message = "Age must be non-negative")
    @Max(value = 100, message = "Age must be less than or equal to 150")
    private int age;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name="student_courses", //joined table name
        joinColumns = @JoinColumn(name="student_id"), //FK REFERENCING STUDENT
        inverseJoinColumns = @JoinColumn(name="course_id") //FK REFERENCING COURSE
    )
    private List<Course> courses = new ArrayList<>();

    public Student() {}

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.courses = null;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public List<Course> getCourses() { return courses; }
    public void setCourses(List<Course> courses) { this.courses = courses; }
}

