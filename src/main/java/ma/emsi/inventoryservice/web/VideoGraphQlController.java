package ma.emsi.inventoryservice.web;


import ma.emsi.inventoryservice.dao.entities.Creator;
import ma.emsi.inventoryservice.dao.entities.Video;
import ma.emsi.inventoryservice.service.CreatorServiceManager;
import ma.emsi.inventoryservice.service.VideoServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class VideoGraphQlController {
    private CreatorServiceManager creatorServiceManager;
    private VideoServiceManager videoServiceManager;

    VideoGraphQlController(CreatorServiceManager creatorServiceManager, VideoServiceManager videoServiceManager){
        this.creatorServiceManager = creatorServiceManager;
        this.videoServiceManager = videoServiceManager;
    }

    @QueryMapping
    public List<Video> videoList(){
        return videoServiceManager.videoList();
    }

    @QueryMapping
    public Creator creatorById(@Argument Integer id){
        return creatorServiceManager.creatorById(id);
    }

}
