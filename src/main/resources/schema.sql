CREATE TABLE authors (
                         id   INT NOT NULL,
                         bio  VARCHAR(255),
                         name VARCHAR(255),
                         PRIMARY KEY (id)
);

CREATE TABLE COURSES (
                         id          INT           NOT NULL,
                         name        VARCHAR(100)  NOT NULL,
                         category    VARCHAR(20)   NOT NULL,
                         rating      INT           NOT NULL,
                         description VARCHAR(1000) NOT NULL,
                         PRIMARY KEY (id)
);

CREATE TABLE authors_courses (
                                 author_id INT NOT NULL,
                                 course_id INT NOT NULL,
                                 PRIMARY KEY (author_id, course_id),
                                 CONSTRAINT course_id_fk FOREIGN KEY (course_id) REFERENCES courses (id),
                                 CONSTRAINT author_id_fk FOREIGN KEY (author_id) REFERENCES authors (id)
);
