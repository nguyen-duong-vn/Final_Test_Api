package com.codegym.Final_Test_Api.controller;

import com.codegym.Final_Test_Api.entity.Movie;
import com.codegym.Final_Test_Api.service.MovieService;
import com.codegym.Final_Test_Api.service.PlayListService;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
public class MovieController {
    private MovieService movieService;
    private PlayListService playListService;

    public MovieController(MovieService movieService, PlayListService playListService) {
        this.movieService = movieService;
        this.playListService = playListService;

    }

    @GetMapping("/list")
    public String showListMovie(Model model) {

        Iterable<Movie> movies = movieService.findAll();
        model.addAttribute("movies",movies);
        return "/movie/list";
    }


    @GetMapping("/movie/create")
    public String createMoviePage (Model model) {

        model.addAttribute("movie", new Movie());
        model.addAttribute("playlists",playListService.findAll());
        return "/movie/create";
    }

    @PostMapping("/movie/create")
    public String createMovie(@ModelAttribute("movie") Movie movie) {
        movieService.save(movie);
        return "redirect:/list";
    }

    @GetMapping("/movie/edit/{id}")
    public String editMoviePage(Model model, @PathVariable("id") Long id) throws Exception {
        Movie movie = movieService.findById(id).get();
        model.addAttribute(movie);
        model.addAttribute("playlists",playListService.findAll());
        return "/movie/create";
    }


    @GetMapping("/movie/delete/{id}")
    public String getStudentDelete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        movieService.softDelete(id);
        redirectAttributes.addFlashAttribute("message", "Student deleted successfully");
        return "redirect:/list";
    }





}
