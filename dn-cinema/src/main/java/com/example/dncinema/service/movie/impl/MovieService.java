
package com.example.dncinema.service.movie.impl;

import com.example.dncinema.model.Film;
import com.example.dncinema.repository.IMovieRepository;
import com.example.dncinema.service.movie.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMovieService {
    @Autowired
    private IMovieRepository movieRepository;


    @Override
    public Page<Film> findAllFilm(String search, Pageable pageable) {
        return movieRepository.findAllFilm(search,pageable);
    }

    /**
     * @Author QuynhHTN
     * Date create: 24/05/2023
     * @param id
     * @return findFilmById
     * @Usage_method findById to show detail film
     */
    @Override
    public Film findFilmById(Integer id) {
        return movieRepository.findFilmById(id);
    }

    @Override
    public List<Film> findAllListFilm() {
        return movieRepository.findAllListFilm();
    }

}

