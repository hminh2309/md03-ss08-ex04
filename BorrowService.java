package org.example.session08.services;

import org.example.session08.models.dtos.BorrowCreateDTO;
import org.example.session08.models.entities.Borrow;
import org.example.session08.repositories.BorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowService {

    @Autowired
    private BorrowRepository borrowRepository;

    public Borrow createBorrow(BorrowCreateDTO dto) {
        Borrow borrow = Borrow.builder()
                .username(dto.getUsername())
                .bookId(dto.getBookId())
                .build();
        return borrowRepository.save(borrow);
    }
}