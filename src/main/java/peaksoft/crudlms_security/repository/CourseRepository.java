package peaksoft.crudlms_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.crudlms_security.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}