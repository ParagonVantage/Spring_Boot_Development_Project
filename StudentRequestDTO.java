import java.util.List;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class StudentRequestDTO {

    @NotBlank
    private String name;

    @Min(10)
    @Max(120)
    private int age;

    private List<String> courses;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public List<String> getCourses() { return courses; }
    public void setCourses(List<String> courses) { this.courses = courses; }
}

