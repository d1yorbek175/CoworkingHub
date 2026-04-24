package org.example.coworkhub.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Zone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne
    private Long address_id;
    private String description;
    private String price;
    @Enumerated(EnumType.STRING)
    private Tolovturi tolovturi;
    private String sigim;
    private String reyting;
    private String image_url;
    private String qulayliklar;
    private LocalDateTime createddate = LocalDateTime.now();

}


