package com.advpro.profiling.tutorial.service;

import com.advpro.profiling.tutorial.model.Student;
import com.advpro.profiling.tutorial.model.StudentCourse;
import com.advpro.profiling.tutorial.repository.StudentCourseRepository;
import com.advpro.profiling.tutorial.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author muhammad.khadafi
 */
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentCourseRepository studentCourseRepository;

    public List<StudentCourse> getAllStudentsWithCourses() {
        return studentCourseRepository.findAll();
    }

    public Optional<Student> findStudentWithHighestGpa() {
        return studentRepository.findStudentWithHighestGpa();
    }

    public String joinStudentNames() {
        List<Student> students = studentRepository.findAll();
//        String result = "";
//        for (Student student : students) {
//            result += student.getName() + ", ";
//        }
//        return result.substring(0, result.length() - 2);
        StringBuilder result = new StringBuilder();
        for (Student student : students) {
            result.append(student.getName()).append(", ");
        }
        return result.length() > 0 ? result.substring(0, result.length() - 2) : "";
    }
}

