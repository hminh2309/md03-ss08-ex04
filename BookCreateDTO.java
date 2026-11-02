package org.example.session08.models.dtos;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookCreateDTO {
    private String title;
    private String author;
    private Integer stock;
    private MultipartFile coverImage;
}