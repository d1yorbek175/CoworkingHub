package org.example.coworkhub.dto;

import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String firstname;
    @Column(nullable = false , unique = true)
    private String email;
    private String password;
    private LocalDateTime createddate = LocalDateTime.now();

    @OneToOne
    private Long zone_id;
}
