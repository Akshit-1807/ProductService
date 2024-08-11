package com.example.productservice;


import com.example.productservice.InheritanceRelation.TablePerClass.*;
//import com.productservice.productservice.services.Productservice;
import com.example.productservice.InheritanceRelation.mappedsuperclass.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner  {

    private MentorRepository mentorRepository;
    private StudentRepository studentRepository;
    private UserRepository userRepository;

    ProductServiceApplication(@Qualifier("tpc_mentorRepository") MentorRepository mentorRepository, StudentRepository studentRepository, UserRepository userRepository){
        this.mentorRepository = mentorRepository;
        this.studentRepository = studentRepository;
        this.userRepository = userRepository;
    }
    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Mentor mentor = new Mentor();
//        mentor.setName("Akshit");
//        mentor.setEmail("Akshit.Gupta@gmail.com");
//        mentor.setAvgRating(4.5);
//
//        mentorRepository.save(mentor);

        Mentor mentor = new Mentor();
        mentor.setName("Akshit");
        mentor.setEmail("Akshit.Gupta@gmail.com");
        mentor.setAvgRating(4.5);
        mentorRepository.save(mentor);

        Student student = new Student();
        student.setName("Akshit");
        student.setEmail("Akshit@gmail.com");
        student.setPsp(87);
        studentRepository.save(student);

        User user = new User();
        user.setName("abc");
        user.setEmail("abc@gmail.com");
        userRepository.save(user);

        //get all the users

        List<User> users = userRepository.findAll();
        for (User user1: users){
            System.out.println(user1.toString());
        }
    }
}
