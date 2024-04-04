package com.bookauth.bookauth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")

    public List<Book> getAllBooks() {
        return bookService.allBooks();

    }
    @PostMapping("/add")
    public Book bookAdd( Book book){
        return bookService.postBook(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        return bookService.puBookNew(id, updatedBook);
    }


    @DeleteMapping("/delete")
    public void deleteBook(@PathVariable Long id){
        bookService.getBookById(id);
    }
}
