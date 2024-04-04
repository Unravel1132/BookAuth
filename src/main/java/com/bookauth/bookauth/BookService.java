package com.bookauth.bookauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;


    public List<Book> allBooks() {
        return bookRepository.findAll();
    }

    public Book postBook(Book book) {

        return bookRepository.save(book);
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Book puBookNew(Long id, Book puBookNew) {
        Book books = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("\"Book not found with id: \" + id)"));
        books.setTitle(puBookNew.getTitle());
        books.setAuthor(puBookNew.getAuthor());
        return bookRepository.save(books);
    }


    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
