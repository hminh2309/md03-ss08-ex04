package org.example.session08.services;

import org.example.session08.exceptions.ResourceNotFoundException;
import org.example.session08.models.dtos.BookCreateDTO;
import org.example.session08.models.dtos.BookUpdateStockDTO;
import org.example.session08.models.entities.Book;
import org.example.session08.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    private final String UPLOAD_DIR = "src/main/resources/uploads/";

    public Book createBook(BookCreateDTO dto) {
        String coverUrl = null;
        MultipartFile file = dto.getCoverImage();

        if (file != null && !file.isEmpty()) {
            try {
                Path uploadPath = Paths.get(UPLOAD_DIR);
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }

                String filename = file.getOriginalFilename();
                Path filePath = uploadPath.resolve(filename);
                Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

                coverUrl = UPLOAD_DIR + filename;
            } catch (IOException e) {
                throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
            }
        }

        Book book = Book.builder()
                .title(dto.getTitle())
                .author(dto.getAuthor())
                .stock(dto.getStock())
                .coverUrl(coverUrl)
                .build();

        return bookRepository.save(book);
    }

    public Book updateBook(Long id, BookUpdateStockDTO dto) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book with id " + id + " not found"));

        book.setStock(dto.getStock());
        return bookRepository.save(book);
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book with id " + id + " not found"));
    }
}