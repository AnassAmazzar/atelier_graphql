package ma.emsi.inventoryservice.service.mapping;

import ma.emsi.inventoryservice.dao.entities.Creator;
import ma.emsi.inventoryservice.dao.entities.Video;
import ma.emsi.inventoryservice.service.dto.CreatorDto;
import ma.emsi.inventoryservice.service.dto.VideoDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class CreatorMapping {
    private ModelMapper modelMapper = new ModelMapper();

    //fromClasstoClassDto
    public CreatorDto fromCreatortoCreatorDto(Creator creator){
        return modelMapper.map(creator, CreatorDto.class);
    }
    //fromClassDtotoClass
    public Creator fromCreatorDtotoCreator(CreatorDto creatorDto){
        return modelMapper.map(creatorDto, Creator.class);
    }
}
