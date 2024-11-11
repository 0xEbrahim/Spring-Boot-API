package rest;

import dao.StudentDao;
import entity.Student;
import exception.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @DeleteMapping("/{studentId}")
    public ResponseEntity<?> deleteStudent(@PathVariable int studentId){
        Student student = studentService.findById(studentId);
        if(student == null)
            throw new ApplicationException("Student not found for id: " + studentId, HttpStatus.NOT_FOUND);
        studentService.deleteById(studentId);
        return ResponseEntity.noContent().build();
    }
}
