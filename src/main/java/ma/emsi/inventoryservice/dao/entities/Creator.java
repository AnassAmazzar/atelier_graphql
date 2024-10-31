package ma.emsi.inventoryservice.dao.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Creator {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer id;
    String name;
    String email;
    @OneToMany(mappedBy = "creator")
    private List<Video> videoList;
}
