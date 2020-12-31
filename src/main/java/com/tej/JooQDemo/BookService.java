package com.tej.JooQDemo;

import com.tej.JooQDemo.jooq.sample.model.Tables;
import com.tej.JooQDemo.jooq.sample.model.tables.pojos.Book;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {

    DSLContext context;

    public BookService(DSLContext context) {
        this.context = context;
    }

    public List<Book> getBooks(){
       return context
                .selectFrom(Tables.BOOK)
                .fetchInto(Book.class);
    }

    public void insertBook(Book book){
        System.out.println("this is the book tile : " + book.getTitle());
        context
                .insertInto(Tables.BOOK, Tables.BOOK.TITLE, Tables.BOOK.AUTHOR)
                .values(book.getTitle(), book.getAuthor())
                .execute();
    }
}
