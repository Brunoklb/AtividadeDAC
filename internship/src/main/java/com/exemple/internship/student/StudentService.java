package com.exemple.internship.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Insertion
    public Student insertStudent(Student student) {
        return studentRepository.save(student);
    }

    // Update
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    // Deletion
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    // List all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Filtering: Select a student by ID
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    // Filtering: Select a student by registration number
    public Optional<Student> getStudentByRegistration(String registration) {
        return studentRepository.findByRegistration(registration);
    }
}
