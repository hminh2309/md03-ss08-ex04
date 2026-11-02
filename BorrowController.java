package org.example.session08.controllers;

import jakarta.validation.Valid;
import org.example.session08.models.dtos.BorrowCreateDTO;
import org.example.session08.models.entities.Borrow;
import org.example.session08.services.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/borrows")
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    @PostMapping
    public ResponseEntity<Borrow> createBorrow(@Valid @RequestBody BorrowCreateDTO dto) { // Dùng @Valid @RequestBody[cite: 28]
        Borrow savedBorrow = borrowService.createBorrow(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBorrow);
    }
}