package ma.emsi.inventoryservice.service.mapping;

import ma.emsi.inventoryservice.dao.entities.Video;
import ma.emsi.inventoryservice.service.dto.VideoDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class VideoMapping {
    private ModelMapper modelMapper = new ModelMapper();

    //fromClasstoClassDto
    public VideoDto fromVideotoVideoDto(Video video){
        return modelMapper.map(video, VideoDto.class);
    }
    //fromClassDtotoClass
    public Video fromVideoDtotoVideo(VideoDto videoDto){
        return modelMapper.map(videoDto, Video.class);
    }
}
