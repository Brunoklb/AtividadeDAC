package com.exemple.internship.student;

import com.exemple.internship.advisor.Advisor;
import com.exemple.internship.company.Company;
import com.exemple.internship.internship.Internship;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    private Advisor advisor;

    @ManyToOne
    private Company company;

    @OneToMany(mappedBy = "student")
    private List<Internship> internships;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Advisor getAdvisor() {
        return advisor;
    }

    public void setAdvisor(Advisor advisor) {
        this.advisor = advisor;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Internship> getInternships() {
        return internships;
    }

    public void setInternships(List<Internship> internships) {
        this.internships = internships;
    }

}
