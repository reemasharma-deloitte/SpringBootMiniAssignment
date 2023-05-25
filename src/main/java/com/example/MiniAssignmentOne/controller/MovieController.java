package com.example.MiniAssignmentOne.controller;


import com.example.MiniAssignmentOne.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final  MovieController csvDataReaderService;

    @Autowired
    public MovieController(MovieController csvDataReaderService) {
        this.csvDataReaderService = csvDataReaderService;
    }

    @PostMapping("/movie")
    public ResponseEntity<String> importMovies() throws IOException {
        csvDataReaderService.readAndStoreCsvData();
        return ResponseEntity.ok("Created Data");
    }
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable("id") Long id) {

        Movie movie = null;

        if (movie != null) {
            return ResponseEntity.ok(movie);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable("id") Long id) {


        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    private void readAndStoreCsvData() {
    }
}