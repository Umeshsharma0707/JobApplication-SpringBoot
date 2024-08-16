package com.jobapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobapp.models.Review;
import com.jobapp.services.ReviewService;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	
	@GetMapping("/reviews")
	public ResponseEntity<?> getAllreviews(@PathVariable int companyId){
		List<Review> allReviews = this.reviewService.getAllReviews(companyId);
		
		if(!allReviews.isEmpty()) {
			return new ResponseEntity<List<Review>>(allReviews,HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("reviews not found",HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/reviews")
	public ResponseEntity<?> addReview(@PathVariable int companyId, @RequestBody Review review){
		boolean flag = this.reviewService.addReview(companyId, review);
		if(flag == true) {
			return new ResponseEntity<String>("review added successfully",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("customer id not found,review not saved",HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/reviews/{reviewId}")
	public ResponseEntity<?> getReview(@PathVariable int companyId, @PathVariable int reviewId){
		Review review = this.reviewService.getReview(companyId, reviewId);
		
		if(review != null) {
			return new ResponseEntity<Review>(review,HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("review not found",HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("/reviews/{reviewId}")
	public ResponseEntity<?> updateReview(@PathVariable int companyId, 
										  @PathVariable int reviewId,
										  @RequestBody Review review){
	
		boolean updateReview = this.reviewService.updateReview(companyId, reviewId, review);
		
		if(updateReview == true) {
			return new ResponseEntity<String>("review updated successfully",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("review not updated,check id's",HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/reviews/{reviewId}")
	public ResponseEntity<?> deleteReview(@PathVariable int companyId, 
			  							  @PathVariable int reviewId){
		boolean deleteReview = this.reviewService.deleteReview(companyId, reviewId);
		
		if(deleteReview == true) {
			return new ResponseEntity<String>("review deleted successfully",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("review not found",HttpStatus.NOT_FOUND);
		}
	}
}


