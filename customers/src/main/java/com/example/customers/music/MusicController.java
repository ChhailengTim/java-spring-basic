package com.example.customers.music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/musics")
public class MusicController{

    private final MusicService musicService;

    @Autowired
    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }

    @GetMapping()
    public List<MusicModel> getAllMusic(){
        return musicService.getAllMusic();
    }

    @PostMapping()
    public ResponseEntity<MusicModel> addNewModel(@RequestBody MusicModel musicModel){
        return musicService.addNewMusic(musicModel);
    }

    @DeleteMapping(path = "{musicId}")
    public ResponseEntity<String> deleteMusic(
            @PathVariable("musicId") Long musicId
    ){
       return musicService.deleteMusic(musicId);
    }

    @PutMapping(path = "{musicId}")
    public ResponseEntity<MusicModel> updateMusic(
            @PathVariable("musicId") Long musicId,
            @RequestBody MusicModel musicDetail
    ){
        return musicService.updateMusic(musicId, musicDetail);
    }
}
