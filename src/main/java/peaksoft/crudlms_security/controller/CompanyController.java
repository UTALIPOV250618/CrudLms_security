package peaksoft.crudlms_security.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import peaksoft.crudlms_security.model.Company;
import peaksoft.crudlms_security.service.CompanyService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService service;


    @RequestMapping("/")
    public String viewCompany(Model model){
        List<Company> companyList = service.getAllCompany();
        model.addAttribute("companyList",companyList);

        return "company/company_page";
    }

    @RequestMapping("/new")
    public String createNewCompany(Model model){
        Company company = new Company();
        model.addAttribute("company", company);
        return "company/new_company";
    }
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(@ModelAttribute("company")Company company){
        service.save(company);
        return "redirect:/company/";
    }

}

