package org.example.session08.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "borrows")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private Long bookId;
}