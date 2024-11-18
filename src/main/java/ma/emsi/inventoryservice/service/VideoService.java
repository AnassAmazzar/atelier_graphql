package ma.emsi.inventoryservice.service;

import ma.emsi.inventoryservice.dao.entities.Creator;
import ma.emsi.inventoryservice.dao.entities.Video;
import ma.emsi.inventoryservice.dao.repository.CreatorRepository;
import ma.emsi.inventoryservice.dao.repository.VideoRepository;
import ma.emsi.inventoryservice.service.dto.CreatorDto;
import ma.emsi.inventoryservice.service.dto.VideoDto;
import ma.emsi.inventoryservice.service.mapping.CreatorMapping;
import ma.emsi.inventoryservice.service.mapping.VideoMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService implements VideoServiceManager{
    @Autowired
    VideoRepository videoRepository;
    @Autowired
    CreatorRepository creatorRepository;
    @Autowired
    VideoMapping videoMapping;
    @Autowired
    CreatorMapping creatorMapping;

    @Override
    public List<Video> videoList() {
        return videoRepository.findAll();
    }

    @Override
    public VideoDto saveVideo(VideoDto videoDto) {
        Creator creator = creatorMapping.fromCreatorDtotoCreator(videoDto.getCreatorDto());
        CreatorDto creatorDto = creatorMapping.fromCreatortoCreatorDto(creatorRepository.findByEmail(creator.getEmail()));
        videoDto.setCreatorDto(creatorDto);
        return videoMapping.fromVideotoVideoDto(videoRepository.save(videoMapping.fromVideoDtotoVideo(videoDto)));
    }

    @Override
    public VideoDto getVideoById(Integer id) {
        Video video = videoRepository.findById(id).get();
        VideoDto videoDto = videoMapping.fromVideotoVideoDto(video);
        return videoDto;
    }

    @Override
    public VideoDto updateVideo(VideoDto videoDto) {
        Creator creator = creatorMapping.fromCreatorDtotoCreator(videoDto.getCreatorDto());
        CreatorDto creatorDto = creatorMapping.fromCreatortoCreatorDto(creatorRepository.findByEmail(creator.getEmail()));
        videoDto.setCreatorDto(creatorDto);
        return videoMapping.fromVideotoVideoDto(videoRepository.save(videoMapping.fromVideoDtotoVideo(videoDto)));
    }
}
