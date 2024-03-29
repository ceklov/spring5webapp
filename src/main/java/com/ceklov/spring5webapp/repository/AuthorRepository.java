package com.ceklov.spring5webapp.repository;

import com.ceklov.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
