package org.example.session08.models.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.example.session08.validations.ExistingBookId;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BorrowCreateDTO {

    @NotBlank(message = "Username không được để trống")
    private String username;

    @NotNull(message = "BookId không được để trống")
    @ExistingBookId 
    private Long bookId;
}