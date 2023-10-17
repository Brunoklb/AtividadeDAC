package com.exemple.internship.controller;

import com.exemple.internship.advisor.AdvisorService;
import com.exemple.internship.company.Company;
import com.exemple.internship.company.CompanyService;
import com.exemple.internship.internship.Internship;
import com.exemple.internship.internship.InternshipService;
import com.exemple.internship.student.Student;
import com.exemple.internship.student.StudentService;
import org.springframework.aop.Advisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AppController {

    private final StudentService studentService;

    private final CompanyService companyService;

    private final AdvisorService advisorService;

    private final InternshipService internshipService;

    public AppController(StudentService studentService, CompanyService companyService, AdvisorService advisorService, InternshipService internshipService) {
        this.studentService = studentService;
        this.companyService = companyService;
        this.advisorService = advisorService;
        this.internshipService = internshipService;
    }

    // Inserir um estudante
    @PostMapping("/students")
    public Student insertStudent(@RequestBody Student student) {
        return studentService.insertStudent(student);
    }

    // Atualizar um estudante
    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    // Remover um estudante
    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    // Listar todos os estudantes
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Buscar um estudante por ID
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Optional<Student> student = studentService.getStudentById(id);
        if (student.isPresent()) {
            return ResponseEntity.ok(student.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Buscar um estudante por número de registro
    @GetMapping("/students/registration/{registration}")
    public ResponseEntity<Student> getStudentByRegistration(@PathVariable String registration) {
        Optional<Student> student = studentService.getStudentByRegistration(registration);
        if (student.isPresent()) {
            return ResponseEntity.ok(student.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Inserir uma empresa
    @PostMapping("/companies")
    public Company insertCompany(@RequestBody Company company) {
        return companyService.insertCompany(company);
    }

    // Atualizar uma empresa
    @PutMapping("/companies")
    public Company updateCompany(@RequestBody Company company) {
        return companyService.updateCompany(company);
    }

    // Remover uma empresa
    @DeleteMapping("/companies/{id}")
    public void deleteCompany(@PathVariable Long id) {
        companyService.deleteCompany(id);
    }

    // Listar todas as empresas
    @GetMapping("/companies")
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    // Buscar uma empresa por ID
    @GetMapping("/companies/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
        Optional<Company> company = companyService.getCompanyById(id);
        if (company.isPresent()) {
            return ResponseEntity.ok(company.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Inserir um orientador
    @PostMapping("/advisors")
    public Advisor insertAdvisor(@RequestBody Advisor advisor) {
        return (Advisor) advisorService.insertAdvisor((com.exemple.internship.advisor.Advisor) advisor);
    }

    // Atualizar um orientador
    @PutMapping("/advisors")
    public Advisor updateAdvisor(@RequestBody Advisor advisor) {
        return (Advisor) advisorService.updateAdvisor((com.exemple.internship.advisor.Advisor) advisor);
    }

    // Remover um orientador
    @DeleteMapping("/advisors/{id}")
    public void deleteAdvisor(@PathVariable Long id) {
        advisorService.deleteAdvisor(id);
    }

    // Listar todos os orientadores
    @GetMapping("/advisors")
    public List<com.exemple.internship.advisor.Advisor> getAllAdvisors() {
        return advisorService.getAllAdvisors();
    }

    // Buscar um orientador por ID
    @GetMapping("/advisors/{id}")
    public ResponseEntity<Advisor> getAdvisorById(@PathVariable Long id) {
        Optional<com.exemple.internship.advisor.Advisor> advisor = advisorService.getAdvisorById(id);
        if (advisor.isPresent()) {
            return ResponseEntity.ok((Advisor) advisor.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Inserir um estágio
    @PostMapping("/internships")
    public Internship insertInternship(@RequestBody Internship internship) {
        return internshipService.insertInternship(internship);
    }

    // Atualizar um estágio
    @PutMapping("/internships")
    public Internship updateInternship(@RequestBody Internship internship) {
        return internshipService.updateInternship(internship);
    }

    // Remover um estágio
    @DeleteMapping("/internships/{id}")
    public void deleteInternship(@PathVariable Long id) {
        internshipService.deleteInternship(id);
    }

    // Listar todos os estágios
    @GetMapping("/internships")
    public List<Internship> getAllInternships() {
        return internshipService.getAllInternships();
    }

    // Buscar um estágio por ID
    @GetMapping("/internships/{id}")
    public ResponseEntity<Internship> getInternshipById(@PathVariable Long id) {
        Optional<Internship> internship = internshipService.getInternshipById(id);
        if (internship.isPresent()) {
            return ResponseEntity.ok(internship.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Buscar estágios de um estudante por número de registro
    @GetMapping("/internships/student/{registration}")
    public List<Internship> getInternshipsByStudentRegistration(@PathVariable String registration) {
        return internshipService.getInternshipsByStudentRegistration(registration);
    }
}
