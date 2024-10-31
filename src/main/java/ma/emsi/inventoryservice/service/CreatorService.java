package ma.emsi.inventoryservice.service;

import ma.emsi.inventoryservice.dao.entities.Creator;
import ma.emsi.inventoryservice.dao.repository.CreatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreatorService implements CreatorServiceManager{
    @Autowired
    CreatorRepository creatorRepository;
    @Override
    public Creator creatorById(Integer id) {
        return creatorRepository.findById(id).get();
    }
}
