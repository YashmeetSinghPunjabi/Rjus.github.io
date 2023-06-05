package com.elearning.models;

import com.sun.istack.NotNull;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
     int courseId;
    @Column @NotNull String courseName;
    @Column @NotNull String author;
    @Column @NotNull int price;
    @Column @NotNull int discountedPrice;
    @Column @NotNull String description;


    public byte[] getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(byte[] courseImage){
        this.courseImage = courseImage;
    }


    @Lob
    @Column @NotNull byte[] courseImage;
    @Column @NotNull String courseVideo;
    @ManyToMany(mappedBy = "courses")
    List<Cart> cart=new ArrayList<>();

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String name) {
        this.courseName= name;
    }

    public String getAuthorName() {
        return author;
    }

    public void setAuthorName(String authorName) {
        this.author = authorName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(int discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getCourseVideo() {
        return courseVideo;
    }

    public void setCourseVideo(String courseVideo) {
        this.courseVideo = courseVideo;
    }

    public List<Cart> getCart() {
        return cart;
    }

    public void setCart(List<Cart> cart) {
        this.cart = cart;
    }






}
