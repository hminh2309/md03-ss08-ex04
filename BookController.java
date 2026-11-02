package org.example.session08.controllers;

import jakarta.validation.Valid;
import org.example.session08.models.dtos.BookCreateDTO;
import org.example.session08.models.dtos.BookUpdateStockDTO;
import org.example.session08.models.entities.Book;
import org.example.session08.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Book> createBook(@ModelAttribute BookCreateDTO bookCreateDTO) {
        try {
            Book savedBook = bookService.createBook(bookCreateDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<String> updateBookStock(
            @PathVariable Long id,
            @Valid @RequestBody BookUpdateStockDTO bookUpdateStockDTO) {

        bookService.updateBook(id, bookUpdateStockDTO);
        return ResponseEntity.ok("Book stock updated successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        return ResponseEntity.ok(book);
    }
}