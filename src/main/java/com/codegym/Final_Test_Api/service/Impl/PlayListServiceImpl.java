package com.codegym.Final_Test_Api.service.Impl;

import com.codegym.Final_Test_Api.entity.PlayList;
import com.codegym.Final_Test_Api.repository.PlayListRepository;
import com.codegym.Final_Test_Api.service.PlayListService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class PlayListServiceImpl implements PlayListService {

    private PlayListRepository playListRepository;

    public PlayListServiceImpl(PlayListRepository playListRepository) {
        this.playListRepository = playListRepository;
    }

    @Override
    public Iterable<PlayList> findAll() {
        return  playListRepository.findByIsActiveTrue();
    }

    @Override
    public Optional<PlayList> findById(Long id) throws Exception {
        return Optional.empty();
    }

    @Override
    public void save(PlayList playList) {

    }

    @Override
    public void softDelete(Long id) {

    }
}
