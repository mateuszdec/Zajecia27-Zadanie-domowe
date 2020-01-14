package org.javastart.zadaniedomowe.movies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepositoryMovies extends JpaRepository<Movies, Long>{

    List<Movies> findMovies(@Param("Category") Category category);

}
