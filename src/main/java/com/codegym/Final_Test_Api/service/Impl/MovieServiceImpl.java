package com.codegym.Final_Test_Api.service.Impl;

import com.codegym.Final_Test_Api.entity.Movie;
import com.codegym.Final_Test_Api.repository.MovieRepository;
import com.codegym.Final_Test_Api.service.MovieService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {

        this.movieRepository = movieRepository;
    }

    @Override
    public Iterable<Movie> findAll() {

        return movieRepository.findByIsActiveTrue();
    }

    @Override
    public Optional<Movie> findById(Long id) throws Exception {
        Optional<Movie> movie = movieRepository.findByIdAndIsActiveTrue(id);
        if(movie.isEmpty()) {
            throw new Exception("Movie not found!");
        }
        return movie;
    }

    @Override
    public void save(Movie movie) {
        movie.setIsActive(true);
        movieRepository.save(movie);
    }

    @Override
    public void softDelete(Long id) {
        movieRepository.updateByIsActiveFalse(id);
    }


}
