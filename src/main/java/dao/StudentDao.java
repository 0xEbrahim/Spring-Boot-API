package dao;

import entity.Student;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface StudentDao {
    void save(Student student);
    List<Student> findAll();
    Student findById(int id);
    void updateById( Student theStudent);
    void deleteById(int id);
}
