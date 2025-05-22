package com.gkfcsolution.springboot_commons_taks_ch2.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class CourseDto {
    private long id;
    private String name;
    private String category;
    private int rating;
    private String description;

    public CourseDto(long id, String name, String category, int rating, String description) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.rating = rating;
        this.description = description;
    }
}
