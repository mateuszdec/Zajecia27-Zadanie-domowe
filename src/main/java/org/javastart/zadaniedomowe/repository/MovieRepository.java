package org.javastart.zadaniedomowe.repository;

import org.javastart.zadaniedomowe.model.Category;
import org.javastart.zadaniedomowe.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {


//    @Query("SELECT m FROM Movie m " +
//            " WHERE 1=1 " +
//            " AND (:title IS NULL OR m.title LIKE CONCAT('%', :title, '%'))" +
//            " AND (:category IS NULL OR m.category = :category)"
//    )

        @Query("SELECT m FROM Movie m " +
            " WHERE (:category IS NULL OR m.category = :category)"
    )

    List<Movie> findUsingFilters(
                @Param("category") Category category);

}
