package com.gkfcsolution.springboot_commons_taks_ch2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "COURSES")
//The @NamedQuery annotation lets you specify the query for the repository method in JPQL format
@NamedQueries({
        @NamedQuery(name = "Course.findAllByRating", query = "select c from Course c where c.rating=?1"),
        @NamedQuery(name = "Course.findAllByCategoryAndRating", query = "SELECT c from Course c where c.category=?1 and c.rating=?2")
})
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "CATEGORY")
    private String category;
    @Min(value = 1, message = "A course should have a minimum of 1 rating")
    @Max(value = 5, message = "A course should have a maximum of 5 rating")
    @Column(name = "RATING")
    private int rating;
    @Column(name = "DESCRIPTION")
    private String description;

    public Course() {
    }

    public Course(String name, String category, int rating, String description) {
        this.name = name;
        this.category = category;
        this.rating = rating;
        this.description = description;
    }

    public Course(long id, String name, String category, int rating, String description) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.rating = rating;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
