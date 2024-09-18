package com.jobapp.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jobapp.models.Company;
import com.jobapp.models.Job;
import com.jobapp.services.CompanyRepository;
import com.jobapp.services.JobService;

@RestController
public class JobController {

	private List<Job> jobs = new ArrayList<>();
	
	
	
	@Autowired
	private JobService jobService;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@GetMapping("/jobs")
	public ResponseEntity<List<Job>> findAll(){
		return ResponseEntity.ok(jobService.findAll());
	}
	
	@PostMapping("/jobs")
	public ResponseEntity<String> createJob(@RequestBody Job job) { 
		
		
		 Company company = companyRepository.findById(job.getCompany().getId()).orElse(null);
		 
		  if(company != null) { job.setCompany(company); }else { return new
		 ResponseEntity<String>("company not found",HttpStatus.NOT_FOUND); }
		 
		
		jobService.createJob(job);
		return new ResponseEntity<String>("job added successfully",HttpStatus.CREATED);
	}
	
	@GetMapping("/jobs/{id}")
	public ResponseEntity<?> getJobById(@PathVariable int id){
		Job job = jobService.getJobById(id);
		
		if(job !=null) {
			return new ResponseEntity<Job>(job,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("job not found",HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/jobs/{id}")
	public ResponseEntity<String> deleteJobById(@PathVariable int id){
		Job job = jobService.getJobById(id);
		if(job != null) {
			jobService.deleteJob(job);
			return new ResponseEntity<String>("job deleted successfully",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("job not found",HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("/jobs/{id}")
	public ResponseEntity<String> updateJob(@PathVariable int id, @RequestBody Job updatedJob){
		
		boolean flag = jobService.updateJob(id, updatedJob);
		
		if(flag == true) {
			return new ResponseEntity<String>("job updated successfully",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("job not found",HttpStatus.NOT_FOUND);
		}
	}
}
