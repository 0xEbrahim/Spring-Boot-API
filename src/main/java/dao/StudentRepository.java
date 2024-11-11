package dao;

import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class StudentRepository implements StudentDao {

    private final EntityManager entityManager;

    @Autowired
    public StudentRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);
        return query.getResultList();
    }

    @Override
    public Student findById(int id) {
        Student student = entityManager.find(Student.class,id);
        return student;
    }

    @Override
    public void updateById(Student theStudent) {
        //theStudent.setId(0);
        entityManager.merge(theStudent);
    }

    @Override
    public void deleteById(int id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }
}
