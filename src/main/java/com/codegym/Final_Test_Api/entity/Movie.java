package com.codegym.Final_Test_Api.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String url;

    @Column(name = "is_active", columnDefinition = "boolean default true")
    private Boolean isActive;

    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinTable(
            name = "movies_playlists",
            joinColumns = @JoinColumn(
                    name = "movie_id", referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "playlist_id", referencedColumnName = "id"
            )
    )
    private Set<PlayList> playLists = new HashSet<>();


}
