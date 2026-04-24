package org.example.coworkhub.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    @Column(nullable = false , unique = true)
    private String email;
    private String password;
    private LocalDateTime createddate = LocalDateTime.now();

    @OneToOne
    private Long zone_id;

}
