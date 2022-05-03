package peaksoft.crudlms_security.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.crudlms_security.model.Student;
import peaksoft.crudlms_security.repository.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    public List<Student> getAllStudents(){
        return  repository.findAll();
    }

    public Student getStudentById(long id){
        return repository.findById(id).get();
    }
    public void saveStudent(Student student){
        repository.save(student);
    }
    public void deleteStudent(long id){
        repository.deleteById(id);
    }
}
