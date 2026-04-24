package org.example.coworkhub.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ZoneDto {
    private String name;
    private Long address_id;
    private String description;
    private String price;
    private String tolovturi;
    private String sigim;
    private String reyting;
    private String image_url;
    private String qulayliklar;
}
