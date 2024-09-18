package com.jobapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobapp.models.Job;

@Service
public class JobServiceImpl implements JobService{

 //	private List<Job> jobs = new ArrayList<>();
	@Autowired
	private JobRepository jobRepository;
	
	
	
	public JobServiceImpl(JobRepository jobRepository) {
	super();
	this.jobRepository = jobRepository;
}

	@Override
	public List<Job> findAll() {
		return jobRepository.findAll();
	}

	@Override
	public void createJob(Job job) {
		jobRepository.save(job);
	}

	@Override
	public Job getJobById(int id) {
		return jobRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteJob(Job job) {
		jobRepository.delete(job);
	}

	@Override
	public boolean updateJob(int id, Job updatedJob) {
		
		Optional<Job> byId = jobRepository.findById(id);
		
		if(byId.isPresent()) {
			Job job = byId.get();
			job.setDescription(updatedJob.getDescription());
			job.setTitle(updatedJob.getTitle());
			job.setMinSalary(updatedJob.getMinSalary());
			job.setMaxSalary(updatedJob.getMaxSalary());
			job.setLocation(updatedJob.getLocation());
			
			jobRepository.save(job);
			return true;
		}
		
		return false;
	}
	
	

}
