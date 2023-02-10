package com.example.demo.service;

import com.example.demo.generated.types.Director;
import com.example.demo.generated.types.Show;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DirectorService {

    public List<Director> directors() {
        List<Director> directors = new ArrayList<>();
        List<Show> guysShows = new ArrayList<>();
        guysShows.add(Show.newBuilder().id("1").build());
        guysShows.add(Show.newBuilder().id("2").build());

        directors.add(Director.newBuilder().id("1").name("Guy Reach").shows(guysShows).build());
        directors.add(Director.newBuilder().id("2").name("Quentin Tarantino").build());

        return directors;
    }
}
