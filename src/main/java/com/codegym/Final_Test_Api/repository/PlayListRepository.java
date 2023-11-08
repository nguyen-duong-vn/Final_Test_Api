package com.codegym.Final_Test_Api.repository;

import com.codegym.Final_Test_Api.entity.Movie;
import com.codegym.Final_Test_Api.entity.PlayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayListRepository extends PagingAndSortingRepository<PlayList,Long>, CrudRepository<PlayList,Long>, JpaRepository<PlayList,Long> {
    Iterable<PlayList> findByIsActiveTrue();

}
