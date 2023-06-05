package com.elearning.service;

import com.elearning.dto.StudentDTO;
import com.elearning.models.Student;
import com.elearning.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


public class StudentService {

    @Autowired
    StudentRepository studentRepository;

public    StudentDTO getProfile(int studentId)
    {
        Student student=studentRepository.findById(studentId).get();
        StudentDTO studentDTO =new StudentDTO();
        studentDTO.setStudentId(student.getStudentId());
        studentDTO.setName(student.getName());
        studentDTO.setAddresh(student.getAddresh());
        studentDTO.setEmailId(student.getEmailId());
        studentDTO.setGender(student.getGender());
        studentDTO.setPhoneNumber(student.getPhoneNumber());
        studentDTO.setUserName(student.getUserName());
        return studentDTO;

    }
}
