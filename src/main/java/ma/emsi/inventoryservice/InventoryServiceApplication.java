package ma.emsi.inventoryservice;

import ma.emsi.inventoryservice.dao.entities.Creator;
import ma.emsi.inventoryservice.dao.entities.Video;
import ma.emsi.inventoryservice.dao.repository.CreatorRepository;
import ma.emsi.inventoryservice.dao.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {
	@Autowired
	CreatorRepository creatorRepository;
	@Autowired
	VideoRepository videoRepository;

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(){
		return args ->{
			List<Creator> creators = List.of(
					new Creator(1,"Alice Dupont", "alice.dupont@example.com", null),
					new Creator(2,"Bob Martin", "bob.martin@example.com", null),
					new Creator(3,"Clara Delaunay", "clara.delaunay@example.com", null),
					new Creator(4,"Daniel Perrin", "daniel.perrin@example.com", null),
					new Creator(5,"Emma Laurent", "emma.laurent@example.com", null)
			);
			creatorRepository.saveAll(creators);

			int i=10;
			//List<Video> videos= new ArrayList<>();
			for(Creator creator : creators){
				List<Video> videos = List.of(
						new Video(i,"Introduction to JavaScript", "https://example.com/js101",
								"A beginner-friendly introduction to JavaScript.", LocalDate.now(), creator),
						new Video(++i,"Advanced CSS Tips", "https://example.com/css-tips",
								"Learn advanced CSS techniques for styling.", LocalDate.now(), creator)

				);
				i++;
				videoRepository.saveAll(videos);
			}
		};
	}

}
