package com.exemple.internship.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    // Insertion
    public Company insertCompany(Company company) {
        return companyRepository.save(company);
    }

    // Update
    public Company updateCompany(Company company) {
        return companyRepository.save(company);
    }

    // Deletion
    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }

    // List all companies
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    // Filtering: Select a company by ID
    public Optional<Company> getCompanyById(Long id) {
        return companyRepository.findById(id);
    }
}
