package org.javastart.zadaniedomowe.controller;

import org.javastart.zadaniedomowe.model.Movie;
import org.javastart.zadaniedomowe.model.MovieFilters;
import org.javastart.zadaniedomowe.repository.MovieRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MovieController {

    private MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/")
    public String allMovies(Model model, MovieFilters movieFilters) {

        if(movieFilters == null) {
            movieFilters = new MovieFilters();
        }

        List<Movie> movies = movieRepository.findUsingFilters(movieFilters.getCategory());

        model.addAttribute("movies", movies);
        model.addAttribute("filters", movieFilters);

        return "movies"; // ->> resources/templates/movies.html
    }

//    @GetMapping("/film")
//    public String movieDetails(@PathVariable Long id, Model model) {
//        Optional<Movie> optional = movieRepository.findById(id);
//        if (optional.isPresent()) {
//            Movie movie = optional.get();
//            model.addAttribute("movie", movie);
//            return "movie"; // ->> resources/templates/movie.html
//        } else {
//            return "redirect:/";
//        }
//    }

    @GetMapping("/add")
    public String addMovieForm(Model model) {
        model.addAttribute("movie", new Movie());
        model.addAttribute("mode", "add");
        return "addMovies";
    }

    @PostMapping("/add")
    public String addMovie(Movie movie) {
        movieRepository.save(movie);
        return "redirect:/film/";
    }
}
