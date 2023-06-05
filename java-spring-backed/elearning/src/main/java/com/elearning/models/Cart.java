package com.elearning.models;

import jdk.jfr.DataAmount;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Entity

public class Cart {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int cartId;

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @ManyToMany
    @JoinTable(
            name = "cart_course_mapping",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    List<Course> courses=new LinkedList<>();

    @OneToOne(mappedBy = "cart")
    Student student;






}
