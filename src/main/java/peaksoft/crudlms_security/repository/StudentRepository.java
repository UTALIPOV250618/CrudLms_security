package peaksoft.crudlms_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.crudlms_security.model.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}