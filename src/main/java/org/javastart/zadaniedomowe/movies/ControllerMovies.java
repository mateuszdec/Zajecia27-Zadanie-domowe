package org.javastart.zadaniedomowe.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ControllerMovies {

    private RepositoryMovies repositoryMovies;

    @Autowired
    public ControllerMovies(RepositoryMovies repositoryMovies) {
        this.repositoryMovies = repositoryMovies;
    }

    @GetMapping("/")
    public String movies(Model model, MovieFilter movieFilter) {
        if (movieFilter == null) {
            movieFilter = new MovieFilter();
        }

        List<Movies> movies = repositoryMovies.findMovies(movieFilter.getCategory());
        model.addAttribute("movies", movies);
        model.addAttribute("filter", movieFilter);

        return "movies";
    }


}
