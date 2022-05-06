package peaksoft.crudlms_security.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.crudlms_security.model.Course;
import peaksoft.crudlms_security.repository.CourseRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;


    public List<Course> getAllCourse(){
        return courseRepository.findAll();
    }

    public Course getById(long id){
        return courseRepository.findById(id).get();
    }

    public void deleteById(long id){
        courseRepository.deleteById(id);
    }
    public void saveCourse(Course course){
        courseRepository.save(course);
    }
}
