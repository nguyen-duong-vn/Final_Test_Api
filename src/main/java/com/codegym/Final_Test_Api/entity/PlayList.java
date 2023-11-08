package com.codegym.Final_Test_Api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.HashSet;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "playlists")
public class PlayList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(name = "is_active", columnDefinition = "boolean default true")
    private Boolean isActive;


    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "playLists")
//    , cascade = {CascadeType.MERGE,CascadeType.PERSIST}
    private Set<Movie> movies = new HashSet<>();


}
