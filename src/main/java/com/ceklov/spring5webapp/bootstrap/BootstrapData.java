package com.ceklov.spring5webapp.bootstrap;

import com.ceklov.spring5webapp.model.Author;
import com.ceklov.spring5webapp.model.Book;
import com.ceklov.spring5webapp.model.Publisher;
import com.ceklov.spring5webapp.repository.AuthorRepository;
import com.ceklov.spring5webapp.repository.BookRepository;
import com.ceklov.spring5webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) {

        Publisher galleryBooks = new Publisher("Gallery Books");
        publisherRepository.save(galleryBooks);

        Author douglasAdams = new Author("Douglas", "Adams");
        Book dirkGently = new Book("Dirk Gently's Holistic Detective Agency", "9781476782997");

        douglasAdams.getBooks().add(dirkGently);
        dirkGently.getAuthors().add(douglasAdams);
        dirkGently.setPublisher(galleryBooks);
        galleryBooks.getBooks().add(dirkGently);

        authorRepository.save(douglasAdams);
        bookRepository.save(dirkGently);
        publisherRepository.save(galleryBooks);

        Publisher sybex = new Publisher("Sybex");
        publisherRepository.save(sybex);

        Author scottSelikoff = new Author("Scott", "Selikoff");
        Author jeanneBoyarsky = new Author("Jeanne", "Boyarsky");
        Book ocpJava17StudyGuide = new Book("Oracle Certified Professional Java SE 17 Developer Study Guide", "9781119864585");
        Book ocpJava17PracticeTests = new Book("Oracle Certified Professional Java SE 17 Developer Practice Tests", "9781119864615");

        scottSelikoff.getBooks().add(ocpJava17StudyGuide);
        scottSelikoff.getBooks().add(ocpJava17PracticeTests);
        jeanneBoyarsky.getBooks().add(ocpJava17StudyGuide);
        jeanneBoyarsky.getBooks().add(ocpJava17PracticeTests);
        ocpJava17StudyGuide.getAuthors().add(scottSelikoff);
        ocpJava17StudyGuide.setPublisher(sybex);
        ocpJava17StudyGuide.getAuthors().add(jeanneBoyarsky);
        ocpJava17PracticeTests.getAuthors().add(scottSelikoff);
        ocpJava17PracticeTests.getAuthors().add(jeanneBoyarsky);
        ocpJava17PracticeTests.setPublisher(sybex);
        sybex.getBooks().add(ocpJava17StudyGuide);
        sybex.getBooks().add(ocpJava17PracticeTests);

        authorRepository.save(scottSelikoff);
        authorRepository.save(jeanneBoyarsky);
        bookRepository.save(ocpJava17StudyGuide);
        bookRepository.save(ocpJava17PracticeTests);
        publisherRepository.save(sybex);

        System.out.println("===============================Bootstrapped===================================");
        System.out.println("Number of authors: " + authorRepository.count());
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of publishers: " + publisherRepository.count());
        System.out.println("==============================================================================");
    }
}
