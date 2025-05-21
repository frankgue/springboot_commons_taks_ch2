package com.gkfcsolution.springboot_commons_taks_ch2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T, ID>  extends CrudRepository<T, ID> {
    <S extends T> S save(S entity);
    Iterable<T> findAll();
}
