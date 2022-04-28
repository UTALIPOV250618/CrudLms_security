package peaksoft.crudlms_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.crudlms_security.model.Company;



@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}