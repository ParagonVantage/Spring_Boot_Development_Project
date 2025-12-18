import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springdemo.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> { }

