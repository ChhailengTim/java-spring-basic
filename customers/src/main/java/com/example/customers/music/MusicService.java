package com.example.customers.music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MusicService {
    private final MusicRepository musicRepository;

    @Autowired
    public MusicService(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    public List<MusicModel> getAllMusic() {
        return musicRepository.findAll();
    }

    public ResponseEntity<MusicModel> addNewMusic(MusicModel musicModel) {
        MusicModel addMusic = musicRepository.save(musicModel);
        return new ResponseEntity<>(addMusic, HttpStatus.OK);
    }

    public ResponseEntity<String> deleteMusic(Long musicId) {
        boolean exists = musicRepository.existsById(musicId);
        if(!exists){
            throw new IllegalStateException("Music with "+musicId+"does not exist!");
        }else {
            musicRepository.deleteById(musicId);
            return new ResponseEntity<>("Music had been delete", HttpStatus.OK);
        }
    }

    @Transactional
    public ResponseEntity<MusicModel> updateMusic(Long musicId, MusicModel musicDetail) {
        Optional<MusicModel> optionMusic = musicRepository.findById(musicId);
        if(optionMusic.isPresent()){
            MusicModel updateMusic = optionMusic.get();
            updateMusic.setTitle(musicDetail.getTitle());
            updateMusic.setAlbum(musicDetail.getAlbum());
            updateMusic.setType(musicDetail.getType());
            updateMusic.setYear(musicDetail.getYear());
            MusicModel addUpdateMusic = musicRepository.save(updateMusic);
            return new ResponseEntity<>(addUpdateMusic,HttpStatus.OK);
        }{
            return ResponseEntity.notFound().build();
        }
    }
}
