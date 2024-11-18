package ma.emsi.inventoryservice.web;


import ma.emsi.inventoryservice.dao.entities.Creator;
import ma.emsi.inventoryservice.dao.entities.Video;
import ma.emsi.inventoryservice.service.CreatorServiceManager;
import ma.emsi.inventoryservice.service.VideoServiceManager;
import ma.emsi.inventoryservice.service.dto.CreatorDto;
import ma.emsi.inventoryservice.service.dto.VideoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Stream;

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

    @SubscriptionMapping
    public Flux<CreatorDto> notifyVideoChange(){
        System.out.println("SubscriptionMapping Entry");
        return Flux.fromStream(
            Stream.generate(()->{
            System.out.println("SubscriptionMapping Entry Flux");
              try {
                  Thread.sleep(1000);
              }catch (InterruptedException e){
                  throw new RuntimeException(e);
              }
              CreatorDto creatorDto = CreatorDto.builder().name("chawki").email("chawki@gmail.com").build();
              CreatorDto cdto = creatorServiceManager.addCreatorDto(creatorDto);
              //VideoDto videoDto = videoServiceManager.getVideoById(1);
              //videoDto.setCreatorDto(cdto);
              //videoServiceManager.updateVideo(videoDto);
              System.out.println("SubscriptionMapping : " + cdto);
              return cdto;
            })
        );
    }
    /*End Code For Creator*/

}
