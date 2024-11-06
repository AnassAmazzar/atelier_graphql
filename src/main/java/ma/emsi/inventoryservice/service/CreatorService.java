package ma.emsi.inventoryservice.service;


import ma.emsi.inventoryservice.dao.repository.CreatorRepository;
import ma.emsi.inventoryservice.service.dto.CreatorDto;
import ma.emsi.inventoryservice.service.mapping.CreatorMapping;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreatorService implements CreatorServiceManager{
    @Autowired
    CreatorRepository creatorRepository;

    @Autowired
    CreatorMapping creatorMapping;

    @Override
    public CreatorDto creatorById(Integer id) {
        return creatorMapping.fromCreatortoCreatorDto(creatorRepository.findById(id).get());
    }

    @Override
    public CreatorDto addCreatorDto(CreatorDto creatorDto) {
        System.out.println("teste output" + creatorRepository.save(creatorMapping.fromCreatorDtotoCreator(creatorDto)));
        return creatorMapping.fromCreatortoCreatorDto(creatorRepository.save(creatorMapping.fromCreatorDtotoCreator(creatorDto)));
    }
}
