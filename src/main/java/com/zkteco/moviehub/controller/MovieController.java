package com.zkteco.moviehub.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zkteco.moviehub.dto.MovieDTO;
import com.zkteco.moviehub.dto.Result;
import com.zkteco.moviehub.entity.Movie;
import com.zkteco.moviehub.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	MovieService movieService;
	
	@Autowired
	private ModelMapper mapper;

	@PostMapping("/add")
	public Result addMovieHandler(@RequestBody MovieDTO movie) {
		Movie mov = this.mapper.map(movie, Movie.class);
		return movieService.addMovie(mov);
	}

}
