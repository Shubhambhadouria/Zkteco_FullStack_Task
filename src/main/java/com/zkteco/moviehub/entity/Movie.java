package com.zkteco.moviehub.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {

	@Id
	private String id;
	private String title;
	private String releaseDate;
	private String genre;
	private String runTime;
	private String rating;
	private String synopsis;
	private String director;
	private String movieCast;
	private String photo;
	private String createdAt;
	private String updatedAt;

}
