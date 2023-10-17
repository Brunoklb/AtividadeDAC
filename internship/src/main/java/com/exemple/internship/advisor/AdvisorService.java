package com.exemple.internship.advisor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdvisorService {

    private final AdvisorRepository advisorRepository;

    public AdvisorService(AdvisorRepository advisorRepository) {
        this.advisorRepository = advisorRepository;
    }

    // Insertion
    public Advisor insertAdvisor(Advisor advisor) {
        return advisorRepository.save(advisor);
    }

    // Update
    public Advisor updateAdvisor(Advisor advisor) {
        return advisorRepository.save(advisor);
    }

    // Deletion
    public void deleteAdvisor(Long id) {
        advisorRepository.deleteById(id);
    }

    // List all advisors
    public List<Advisor> getAllAdvisors() {
        return advisorRepository.findAll();
    }

    // Filtering: Select an advisor by ID
    public Optional<Advisor> getAdvisorById(Long id) {
        return advisorRepository.findById(id);
    }
}
