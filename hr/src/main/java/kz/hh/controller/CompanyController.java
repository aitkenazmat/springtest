package kz.hh.controller;

import kz.hh.document.Company;
import kz.hh.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {
    private CompanyRepository companyRepository;
    @Autowired
    public void setCompanyRepository(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping("/list")
    public List<Company> getList() {
        return companyRepository.findAll();
    }

    @GetMapping("/{id}")
    public Company getCompany(@PathVariable("id") String id) {
        Company company = null;
        Optional<Company> companyOptional = companyRepository.findById(id);
        if (companyOptional.isPresent()) {
            company = companyOptional.get();
        }
        return company;
    }

    @PostMapping
    public Company saveCompany(@RequestBody Company company) {
        return companyRepository.save(company);
    }

    @PutMapping("/{id}")
    public void updateCompany(@PathVariable("id") String id, @RequestBody Company company) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if (companyOptional.isPresent()) {
            Company currentCompany = companyOptional.get();
            currentCompany.setName(company.getName());
            companyRepository.save(currentCompany);
        }
    }

//    @DeleteMapping
//    public void deleteCompany(@RequestBody Company company){
//        companyRepository.delete(company);
//    }
}
