package com.efocoder;

import com.efocoder.dao.StudentDAO;
import com.efocoder.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
//            createStudent(studentDAO);
            createMultipleStudent(studentDAO);
//            readStudent(studentDAO);
//            readAllStudents(studentDAO);
//            getByLastName(studentDAO);
//            updateStudent(studentDAO);
//            deleteStudent(studentDAO);
        };
    }

    private void deleteStudent(StudentDAO studentDAO) {
        studentDAO.delete(2);
        System.out.println("Successfully deleted student");
    }

    private void updateStudent(StudentDAO studentDAO) {
        var student = studentDAO.findById(1);
        student.setFirstName("Scooby");
        studentDAO.update(student);
    }

    private void getByLastName(StudentDAO studentDAO) {
        var students = studentDAO.findByLastName("Public");

        for (var student : students) {
            System.out.println(student);
        }
    }

    private void readAllStudents(StudentDAO studentDAO) {
        var students = studentDAO.findAll();
        students.forEach(System.out::println);
    }

    private void readStudent(StudentDAO studentDAO) {
        var student = studentDAO.findById(3);
        System.out.println(student);
    }

    private void createMultipleStudent(StudentDAO studentDAO) {
        System.out.println("Creating 3 student objects ...");

        Student tempStudent1 = new Student("John", "Doe", "john@coder.com");
        Student tempStudent2 = new Student("Mary", "Public", "mary@coder.com");
        Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@coder.com");

        System.out.println("Saving the students...");

        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);

    }

    private void createStudent(StudentDAO studentDAO) {
        System.out.println("Creating new student object ...");

        Student tempStudent = new Student("Paul", "Doe", "paul@coder.com");

        System.out.println("Saving the student...");

        studentDAO.save(tempStudent);

        System.out.println("Student saved. ID " + tempStudent.getId());
    }

}

// 0541654978
