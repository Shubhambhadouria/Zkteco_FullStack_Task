package com.zkteco.moviehub.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zkteco.moviehub.dto.MovieDTO;
import com.zkteco.moviehub.dto.Result;
import com.zkteco.moviehub.entity.Movie;
import com.zkteco.moviehub.repository.MovieRepository;
import com.zkteco.moviehub.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	private MovieRepository movieRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public Result addMovie(Movie movie) {
		Result result = validator(movie);
		if(result==null) {
			movieRepo.save(movie);
			MovieDTO mov = this.mapper.map(movie, MovieDTO.class);
			return new Result("OK","Movie data is Added successfully",mov);
		}else {
			return result;
		}
	}
	
	public Result validator(Movie movie) {
		
		if(movieRepo.findById(movie.getId()).isPresent()) {
			return new Result("Error","Movie is Already present with id : "+movie.getId(),movieRepo.findById(movie.getId())); 
		}
		
		return null;
	}
	

}
