package com.gkfcsolution.springboot_commons_taks_ch2.repository;

import com.gkfcsolution.springboot_commons_taks_ch2.dto.AuthorCourseDto;
import com.gkfcsolution.springboot_commons_taks_ch2.model.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
    @Query("SELECT new com.gkfcsolution.springboot_commons_taks_ch2.dto.AuthorCourseDto(c.id, a.name, c.name, c.description) FROM AUTHOR a, COURSE c, AUTHOR_COURSE ac WHERE a.id = ac.authorId AND c.id = ac.courseId AND ac.authorId = ?1")
    Iterable<AuthorCourseDto> getAuthorCourseInfo(long id);
}
