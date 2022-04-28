package peaksoft.crudlms_security.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.crudlms_security.model.Company;
import peaksoft.crudlms_security.repository.CompanyRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository repository;


    public List<Company> getAllCompany(){
        return repository.findAll();
    }
}
