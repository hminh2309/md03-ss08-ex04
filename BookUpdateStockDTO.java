package org.example.session08.models.dtos;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookUpdateStockDTO {

    @Min(value = 0, message = "Stock must be a non-negative integer.")
    private Integer stock;
}