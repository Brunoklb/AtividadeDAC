package com.exemple.internship.internship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InternshipService {

    private final InternshipRepository internshipRepository;

    public InternshipService(InternshipRepository internshipRepository) {
        this.internshipRepository = internshipRepository;
    }

    // Insertion
    public Internship insertInternship(Internship internship) {
        return internshipRepository.save(internship);
    }

    // Update
    public Internship updateInternship(Internship internship) {
        return internshipRepository.save(internship);
    }

    // Deletion
    public void deleteInternship(Long id) {
        internshipRepository.deleteById(id);
    }

    // List all internships
    public List<Internship> getAllInternships() {
        return internshipRepository.findAll();
    }

    // Filtering: Select an internship by ID
    public Optional<Internship> getInternshipById(Long id) {
        return internshipRepository.findById(id);
    }

    // Filtering: Select an internship of a student by registration
    public List<Internship> getInternshipsByStudentRegistration(String registration) {
        return internshipRepository.findByStudentRegistration(registration);
    }
}

