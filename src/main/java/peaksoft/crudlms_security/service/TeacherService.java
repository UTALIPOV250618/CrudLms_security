package peaksoft.crudlms_security.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.crudlms_security.model.Teacher;
import peaksoft.crudlms_security.repository.TeacherRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository repository;

    public List<Teacher> getAllTeachers(){
        return repository.findAll();
    }
    public Teacher getTeacherById(long id){
        return repository.findById(id).get();
    }
    public void saveTeacher(Teacher teacher){
        repository.save(teacher);
    }
    public void deleteTeacher(long id){
        repository.deleteById(id);
    }
}
