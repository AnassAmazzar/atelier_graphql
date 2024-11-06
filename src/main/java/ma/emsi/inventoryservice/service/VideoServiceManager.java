package ma.emsi.inventoryservice.service;

import ma.emsi.inventoryservice.dao.entities.Video;
import ma.emsi.inventoryservice.service.dto.VideoDto;
import java.util.List;

public interface VideoServiceManager {
    List<Video> videoList();
    VideoDto saveVideo(VideoDto videoDto);

}
