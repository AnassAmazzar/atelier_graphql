package ma.emsi.inventoryservice.service.dto;

import jakarta.persistence.OneToMany;
import lombok.*;
import ma.emsi.inventoryservice.dao.entities.Video;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CreatorDto {
    String name;
    String email;
    private List<Video> videoList;
}
