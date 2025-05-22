package com.gkfcsolution.springboot_commons_taks_ch2.dto;

public class AuthorCourseDto {
    private long id;// Id du cours
    private String authorName;
    private String courseName;
    private String description;

    public AuthorCourseDto(long id, String authorName, String courseName, String description) {
        this.id = id;
        this.authorName = authorName;
        this.courseName = courseName;
        this.description = description;
    }

    @Override
    public String toString() {
        return "AuthorCourseDto{" +
                "id=" + id +
                ", authorName='" + authorName + '\'' +
                ", courseName='" + courseName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
