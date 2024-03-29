package com.ceklov.spring5webapp.repository;

import com.ceklov.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
