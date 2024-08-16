package com.jobapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobapp.models.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer>{
	List<Review> findByCompanyId(int id);

	 Optional<Review> findByCompanyIdAndId(int companyId, int reviewId);
}
