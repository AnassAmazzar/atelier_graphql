package ma.emsi.inventoryservice.service;


import ma.emsi.inventoryservice.service.dto.CreatorDto;

public interface CreatorServiceManager {
    CreatorDto creatorById(Integer id);
    CreatorDto addCreatorDto(CreatorDto creatorDto);
}
