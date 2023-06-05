package com.elearning.controller;

import com.elearning.models.Admin;
import com.elearning.repository.AdminRepository;
import com.elearning.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@CrossOrigin
@RestController
public class AdminController  {
    @Autowired
    AdminRepository adminRepository;
    @RequestMapping("/add-admin")
    public Admin addAdmin(@RequestBody  Admin admin)
    {
        return adminRepository.save(admin);
    }
    @RequestMapping("/get-admin")
    public List<Admin> getAdmin()
    {
        return (List<Admin>)adminRepository.findAll();
    }
    @RequestMapping("/delete-admin")
    public void deleteCourse(@RequestBody int i)

    {
        adminRepository.deleteById(i);

    }

}
