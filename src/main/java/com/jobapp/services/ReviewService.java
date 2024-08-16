package com.jobapp.services;

import java.util.List;

import com.jobapp.models.Review;

public interface ReviewService {
	List<Review> getAllReviews(int companyId);
	boolean addReview(int companyId,Review review);
	Review getReview(int companyId,int reviewId);
	boolean updateReview(int companyId,int reviewId,Review review);
	boolean deleteReview(int companyId,int reviewId);
}
