package ma.emsi.inventoryservice.web;


import ma.emsi.inventoryservice.dao.entities.Creator;
import ma.emsi.inventoryservice.dao.entities.Video;
import ma.emsi.inventoryservice.service.CreatorServiceManager;
import ma.emsi.inventoryservice.service.VideoServiceManager;
import ma.emsi.inventoryservice.service.dto.CreatorDto;
import ma.emsi.inventoryservice.service.dto.VideoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
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

    /*Start Code For Video*/
    @QueryMapping
    public List<Video> videoList(){
        return videoServiceManager.videoList();
    }

    @MutationMapping
    public VideoDto saveVideo(@Argument VideoDto videoRequest){
        return videoServiceManager.saveVideo(videoRequest);
    }
    /*End Code For Video*/

    /*Start Code For Creator*/
    @QueryMapping
    public CreatorDto creatorById(@Argument Integer id){
        return creatorServiceManager.creatorById(id);
    }

    @MutationMapping
    public CreatorDto saveCreator(@Argument CreatorDto creatorRequest){
        return creatorServiceManager.addCreatorDto(creatorRequest);
    }
    /*End Code For Creator*/

}
