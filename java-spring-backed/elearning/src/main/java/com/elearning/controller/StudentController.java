package com.elearning.controller;

import com.elearning.dto.CourseDTO;
import com.elearning.dto.StudentDTO;
import com.elearning.models.Cart;
import com.elearning.models.Course;
import com.elearning.models.Student;
import com.elearning.repository.CartRepository;
import com.elearning.repository.StudentRepository;
import com.elearning.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
@CrossOrigin
@RestController
public class StudentController {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    StudentService studentService;

    @Autowired
    CartRepository cartRepository;
    @RequestMapping("/get-student")
    public List<StudentDTO> getStudent() {

        List<Student> students=studentRepository.findAll();
        List<StudentDTO> studentDTO=new LinkedList<>();

        for(Student s:students)
        {
            StudentDTO student=new StudentDTO();
            student.setStudentId(s.getStudentId());
            student.setAddresh(s.getAddresh());
            student.setEmailId(s.getEmailId());
            student.setGender(s.getGender());
            student.setUserName(s.getUserName());
            student.setPassword(s.getPassword());
            student.setName(s.getName());
            studentDTO.add(student);
        }
        return  studentDTO;
    }

    @RequestMapping("/add-student")
    public Student addStudent(@RequestBody Student student)
    {
        Cart cart=cartRepository.save(new Cart());
        student.setCart(cart);
        return studentRepository.save(student);
    }
    @RequestMapping("/delete-student/{id}")
    public void deleteStudent(@PathVariable(value="id") int i)

    {
        studentRepository.deleteById(i);

    }
    @RequestMapping("get-profile/{studentId}")
    StudentDTO getProfile(@PathVariable(value="studentId") int studentId)
    {

        studentService.getProfile(studentId);

    }
    @RequestMapping("update-profile/{studentId}")
    void updateprofile(@RequestBody StudentDTO student ,@PathVariable(value = "studentId") int studentId)
    {  System.out.println(student.getName());
        System.out.println(studentRepository.findById(studentId).get());
       Student student1=studentRepository.findById(studentId).get();
       student1.setName(student.getName());
       student1.setAddresh(student.getAddresh());
       student1.setGender(student.getGender());
       student1.setEmailId(student.getEmailId());
       student1.setUserName(student.getName());
       student1.setPhoneNumber(student.getPhoneNumber());
       System.out.println(student1.getName());
       studentRepository.save(student1);

    }
}
