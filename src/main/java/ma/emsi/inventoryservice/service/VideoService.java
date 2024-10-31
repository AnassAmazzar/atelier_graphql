package ma.emsi.inventoryservice.service;

import ma.emsi.inventoryservice.dao.entities.Video;
import ma.emsi.inventoryservice.dao.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService implements VideoServiceManager{
    @Autowired
    VideoRepository videoRepository;

    @Override
    public List<Video> videoList() {
        return videoRepository.findAll();
    }
}
