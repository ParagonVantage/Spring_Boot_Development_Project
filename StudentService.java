import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.springdemo.dto.StudentRequestDTO;
import com.example.springdemo.dto.StudentResponseDTO;
import com.example.springdemo.exception.StudentNotFoundException;
import com.example.springdemo.model.Course;
import com.example.springdemo.model.Student;
import com.example.springdemo.repository.StudentRepository;


@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public Student save(Student s) { return repo.save(s); }

    public List<Student> getAll() { return repo.findAll(); }

    public Student getById(Long id) { return repo.findById(id).orElseThrow(() -> new StudentNotFoundException(id)); }

    public void deleteById(Long id) { repo.deleteById(id); }
    
    public StudentResponseDTO createStudent(StudentRequestDTO dto) {

    Student student = new Student();
    student.setName(dto.getName());
    student.setAge(dto.getAge());

    if (dto.getCourses() != null) {
        List<Course> courses = dto.getCourses().stream()
            .map(name -> new Course(name))
            .collect(Collectors.toList());

        student.setCourses(courses);
    }

    Student saved = repo.save(student);

    List<String> courseNames = saved.getCourses().stream()
        .map(Course::getCourseName)
        .collect(Collectors.toList());

    return new StudentResponseDTO(
        saved.getId(),
        saved.getName(),
        saved.getAge(),
        courseNames
    );
}

}

