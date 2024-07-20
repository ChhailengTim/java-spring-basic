package com.example.customers.music;

import jakarta.persistence.*;

@Entity
public class MusicModel {

        @Id
        @SequenceGenerator(name = "music_sequence",
                sequenceName = "music_sequence",
                allocationSize = 1
        )
        @GeneratedValue(
                strategy = GenerationType.SEQUENCE,
                generator = "music_sequence"
        )
        private Long id;
        private String title;
        private String album;
        private String type;
        private int year;

        // No-argument constructor for JPA
        public MusicModel() {
        }

        // Parameterized constructor for easy instantiation
        public MusicModel(Long id, String title, String album, String type, int year) {
            this.id = id;
            this.title = title;
            this.album = album;
            this.type = type;
            this.year = year;
        }

        // Getters and Setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAlbum() {
            return album;
        }

        public void setAlbum(String album) {
            this.album = album;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = this.type;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        @Override
        public String toString() {
            return "MusicModel{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", album='" + album + '\'' +
                    ", type='" + type + '\'' +
                    ", year=" + year +
                    '}';
        }
}
