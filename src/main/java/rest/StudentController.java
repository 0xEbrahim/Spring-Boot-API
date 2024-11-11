package rest;

import dao.StudentDao;
import entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.StudentService;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentDao studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    // Get all students
    @GetMapping("/")
    public ResponseEntity<List<Student>> findAllStudent(){
        return ResponseEntity.ok(studentService.findAll());
    }

    @PostMapping("/")
    public ResponseEntity<Student> saveStudent(@RequestBody Student theStudent){
        studentService.save(theStudent);
        return ResponseEntity.ok(theStudent);
    }

}
