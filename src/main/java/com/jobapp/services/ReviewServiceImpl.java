package com.jobapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobapp.models.Company;
import com.jobapp.models.Review;

@Service
public class ReviewServiceImpl implements ReviewService {
	@Autowired
	private ReviewRepository reviewRepository;
	@Autowired
	private CompanyService companyService;
	
	@Override
	public List<Review> getAllReviews(int companyId) {
		List<Review> reviews = this.reviewRepository.findByCompanyId(companyId);
		
		return reviews;
	}

	@Override
	public boolean addReview(int companyId, Review review) {
		Company company = this.companyService.getCompanyById(companyId);
		if(company != null) {
			review.setCompany(company);
			this.reviewRepository.save(review);
			this.companyService.updateCompany(companyId, company);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Review getReview(int companyId, int reviewId) {
		Optional<Review> review = this.reviewRepository.findByCompanyIdAndId(companyId,reviewId);
		
		return review.orElse(null);
	}

	@Override
	public boolean updateReview(int companyId, int reviewId, Review updatedReview) {
		Company company = this.companyService.getCompanyById(companyId);
		Review review = this.reviewRepository.findById(reviewId).orElse(null);
		if(company != null) {
			if(review != null) {
				review.setId(reviewId);
				review.setCompany(company);
				review.setDescription(updatedReview.getDescription());
				review.setTitle(updatedReview.getTitle());
				review.setRating(updatedReview.getRating());
				
				this.reviewRepository.save(review);
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}

	@Override
	public boolean deleteReview(int companyId, int reviewId) {
		Company company = this.companyService.getCompanyById(companyId);
		Review review = this.reviewRepository.findById(reviewId).orElse(null);
		if(company != null) {
			if(review != null) {
				company.getReviews().remove(review);
				this.companyService.updateCompany(companyId, company);
				this.reviewRepository.delete(review);
				
				return true;
			}
		}
		return false;
	}

}

