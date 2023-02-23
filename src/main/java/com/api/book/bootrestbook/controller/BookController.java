package com.api.book.bootrestbook.controller;

import com.api.book.bootrestbook.entities.Book;
import com.api.book.bootrestbook.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController
{
    // here inject booksService class
    @Autowired
    private BookService bookService;

    // get all books handler
    @GetMapping("/books")
   public List<Book> getBooks()
    {
       return this.bookService.getAllBooks();
   }

   // get single book handler
   @GetMapping("/books/{id}")
    public Book getBook(@PathVariable("id") int id)
   {
       return this.bookService.getBookById(id);
   }

   // new book handler
    @PostMapping("/books")
    public Book addBook(@RequestBody Book book)
    {
      Book b = this.bookService.addBook(book);
      System.out.println(b);
       return b;
    }

    // delete book handler
    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable("bookId") int bookId)
    {
        this.bookService.deleteBook(bookId);
    }

    // update the book handler
    @PutMapping("/books/{bookId}")
    public Book updateBook(@RequestBody Book book,@PathVariable("bookId") int bookId)
    {
       this.bookService.updateBook(book,bookId);
       return book;
    }

}















/*
    public List<Book> getBooks()
    {
        // create object for sending data as json
        // this data not come as json because here we create object manually
//       Book book = new Book();
//       book.setId(111);
//       book.setTitle("Java Complete Reference");
//       book.setAuthor("By Jitendra Verma");
//       return book;
    }

 */