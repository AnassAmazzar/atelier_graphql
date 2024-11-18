package ma.emsi.inventoryservice.service.dto;

import jakarta.persistence.ManyToOne;
import lombok.*;
import ma.emsi.inventoryservice.dao.entities.Creator;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class VideoDto {
    private String name;
    private String url;
    private String description;
    private LocalDate datePublication;
    private CreatorDto creatorDto;
}
