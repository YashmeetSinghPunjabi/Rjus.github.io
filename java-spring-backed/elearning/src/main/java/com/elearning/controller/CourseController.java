package com.elearning.controller;

import com.elearning.dto.CourseDTO;
import com.elearning.models.Cart;
import com.elearning.models.Course;
import com.elearning.models.Student;
import com.elearning.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
@CrossOrigin
@RestController
public class CourseController {
    @Autowired
    CourseRepository courseRepository;

    @RequestMapping("/get-courses")
    public List<CourseDTO> getCourses() {
        List<Course> courses= courseRepository.findAll();
        List<CourseDTO> courseDTOS=new LinkedList<>();

        for(Course course: courses)
        {
            CourseDTO courseDTO=new CourseDTO();
            courseDTO.setCourseId(course.getCourseId());
            courseDTO.setCourseName(course.getCourseName());
            courseDTO.setPrice(course.getPrice());
            courseDTO.setAuthor(course.getAuthorName());
            courseDTO.setDiscountedPrice(course.getDiscountedPrice());
            courseDTO.setCourseImage(course.getCourseImage());
            courseDTO.setCourseVideo(course.getCourseVideo());
            courseDTOS.add(courseDTO);

        }
        return courseDTOS;


    }


    @RequestMapping("/add-course")

    public int  addCourse(@RequestBody Course course) {

        courseRepository.save(course);
        return course.getCourseId();
    }


    @RequestMapping("/add-course-image/{courseId}")
    public void addCourseImage(@PathVariable int courseId,@RequestParam("courseImage") MultipartFile courseImage) throws IOException {
        System.out.println(courseImage);
        byte [] byteArr=courseImage.getBytes();
        Course course = courseRepository.findById(courseId).get();
        course.setCourseImage(byteArr);
        courseRepository.save(course);

    }

    @RequestMapping("/add-course-video/{courseId}")
    public void addCourseVideo(@PathVariable int courseId,@RequestParam("courseVideo") MultipartFile courseVideo) throws IOException{
       String videoFileName=courseVideo.getOriginalFilename();
       courseVideo.transferTo(new File("C:\\elearning\\src\\main\\resources\\Videos\\" + videoFileName));
       Course course=courseRepository.findById(courseId).get();
       course.setCourseVideo("C:\\elearning\\src\\main\\resources\\Videos\\" + videoFileName);
       courseRepository.save(course);
    }

    @RequestMapping("/delete-course/{id}")
    public void deleteCourse(@PathVariable(value = "id")int i)

    {
     courseRepository.deleteById(i);


    }

     @RequestMapping("/update-course")
     public void updateCourse(@RequestBody Course course)
        {
            Course c;
            c=courseRepository.findById(course.getCourseId()).get();

            c.setCourseName(course.getCourseName());
            c.setAuthorName(course.getAuthorName());
            c.setPrice(course.getPrice());
            c.setDiscountedPrice(course.getDiscountedPrice());
            c.setDescription(course.getDescription());
        courseRepository.save(c);


        }
    @RequestMapping("/sort-price-low-to-high")
      public List<Course> sortedByPriceLowToHigh()
      {
           return courseRepository.findAll(Sort.by(Sort.Direction.ASC,"price"));
      }
    @RequestMapping("/sort-price-high-to-low")
    public List<Course> sortedByPriceHighToLow()
    {
        return courseRepository.findAll(Sort.by(Sort.Direction.DESC,"price"));
    }


}