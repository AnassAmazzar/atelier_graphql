package ma.emsi.inventoryservice.service.mapping;

import ma.emsi.inventoryservice.dao.entities.Creator;
import ma.emsi.inventoryservice.dao.entities.Video;
import ma.emsi.inventoryservice.dao.repository.CreatorRepository;
import ma.emsi.inventoryservice.dao.repository.VideoRepository;
import ma.emsi.inventoryservice.service.dto.VideoDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VideoMapping {
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private CreatorRepository creatorRepository;
    @Autowired
    private VideoRepository videoRepository;

    //fromClasstoClassDto
    public VideoDto fromVideotoVideoDto(Video video){
        return modelMapper.map(video, VideoDto.class);
    }
    //fromClassDtotoClass
    public Video fromVideoDtotoVideo(VideoDto videoDto){

        Creator creator = creatorRepository.findByEmail(videoDto.getCreator().getEmail());
        Video Video = modelMapper.map(videoDto, Video.class);
        Video.setCreator(creator);
        return Video;
    }
}
