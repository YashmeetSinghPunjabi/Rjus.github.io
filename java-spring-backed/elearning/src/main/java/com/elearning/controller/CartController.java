package com.elearning.controller;

import com.elearning.dto.CourseDTO;
import com.elearning.models.Cart;
import com.elearning.models.Course;
import com.elearning.models.Student;
import com.elearning.repository.CartRepository;
import com.elearning.repository.CourseRepository;
import com.elearning.repository.StudentRepository;
import org.apache.catalina.connector.Request;
import org.graalvm.compiler.core.GraalCompiler;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
@CrossOrigin
@RestController
public class CartController {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CartRepository cartRepository;


    @GetMapping
    @RequestMapping("/add-course-to-cart/{studentId}/{courseId}")
    public void addToCart(@PathVariable(value = "studentId") int studentId, @PathVariable(value = "courseId") int courseId) {

        Student student = studentRepository.findById(studentId).get();
        Cart cart = student.getCart();
        Course course = courseRepository.findById(courseId).get();

        List<Course> courses = cart.getCourses();
        courses.add(course);

        cartRepository.save(cart);


    }


    @RequestMapping("/get-cart-courses/{studentId}")
    public List<CourseDTO> getCartCourses(@PathVariable(value = "studentId") int studentId) {
        Student student = studentRepository.findById(studentId).get();
        Cart cart = student.getCart();
        List<Course> courses = cart.getCourses();
        List<CourseDTO> courseDTOS = new LinkedList<>();

        for (Course course : courses) {
            CourseDTO courseDTO = new CourseDTO();
            courseDTO.setCourseId(course.getCourseId());
            courseDTO.setCourseName(course.getCourseName());
            courseDTO.setPrice(course.getPrice());
            courseDTO.setAuthor(course.getAuthorName());
            courseDTO.setDiscountedPrice(course.getDiscountedPrice());

            courseDTOS.add(courseDTO);


        }
        return courseDTOS;


    }

    @RequestMapping("/delete-from-cart/{studentId}")
    public void deleteFromCart(@PathVariable(value = "studentId") int studentId) {
        int i=0;
        Student s = studentRepository.findById(studentId).get();
        Cart c=studentRepository.findById(studentId).get().getCart();
        c.setCourses(null);
        cartRepository.save(c);


    }
    @RequestMapping("/delete-from-cart-id/{studentId}/{courseId}")
    public void deleteFromCart(@PathVariable(value = "studentId") int studentId,@PathVariable(value = "courseId") int courseId) {
        Cart c = studentRepository.findById(studentId).get().getCart();
        List<Course> course = c.getCourses();
        course.removeIf(element->(element.getCourseId()==courseId));
        c.setCourses(course);
        cartRepository.save(c);

    }
    @RequestMapping("/total-cart-value/{studentId}")
    int totalCartValue(@PathVariable(value = "studentId") int studentId)
    {
        int totalCart=0;
        Cart c= studentRepository.findById(studentId).get().getCart();
        List<Course> courses= c.getCourses();
        for(Course course:courses)
        {
            totalCart=totalCart+course.getDiscountedPrice();
        }

        return totalCart;
    }

}