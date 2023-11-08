package com.codegym.Final_Test_Api.repository;

import com.codegym.Final_Test_Api.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;



@Repository
    public interface MovieRepository extends PagingAndSortingRepository<Movie,Long>, CrudRepository<Movie,Long>, JpaRepository<Movie,Long> {

    Iterable<Movie> findByIsActiveTrue();
    @Query("from Movie m where m.id = :id AND m.isActive = true ")
    Optional<Movie> findByIdAndIsActiveTrue(@Param("id") Long id);


    @Modifying
    @Query("update Movie s set s.isActive=false where s.id = :id")
    void updateByIsActiveFalse(@Param("id") Long id);





}
