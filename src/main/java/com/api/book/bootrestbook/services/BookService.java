package com.api.book.bootrestbook.services;

import com.api.book.bootrestbook.entities.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// here create fake service for data if we have not any database.
@Component
public class BookService {
    // create list of book
    private static List<Book> list = new ArrayList<>();

    static {
        list.add(new Book(12, "Java Complete Reference", "XYZ"));
        list.add(new Book(13, "SCJP by catiSerra", "ABC"));
        list.add(new Book(14, "Head First JAva", "MNO"));
    }

    // get all books
    public List<Book> getAllBooks() {
        return list;
    }

    // get single book by id  (list.stream() is method from stream api)
    public Book getBookById(int id) {
        Book book = null;
        book = list.stream().filter(e -> e.getId() == id).findFirst().get();
        return book;
    }
    //add the book
    public Book addBook(Book b)
    {
        list.add(b);
        return b;
    }
    // delete book
    public void deleteBook(int bid)
    {
      list =  list.stream().filter(book ->book.getId()!=bid).collect(Collectors.toList());
    }
    // update the book
    public void updateBook(Book book, int bookId)
    {
       list = list.stream().map(b ->{
            if(b.getId()==bookId){
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
            }
            return b;
        } ).collect(Collectors.toList());
    }
}
