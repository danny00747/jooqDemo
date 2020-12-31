package com.tej.JooQDemo;

import com.tej.JooQDemo.jooq.sample.model.tables.pojos.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class BookController {

    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/teachers")
    public List<Book> getBooks(){
        return this.bookService.getBooks();
    }

    @PostMapping("/teachers")
    public void postBook(@RequestBody Book book){
        this.bookService.insertBook(book);
    }
}
