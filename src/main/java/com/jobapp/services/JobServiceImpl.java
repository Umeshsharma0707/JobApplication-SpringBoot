package com.jobapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jobapp.models.Job;

@Service
public class JobServiceImpl implements JobService{

	private List<Job> jobs = new ArrayList<>();
	@Override
	public List<Job> findAll() {
		return jobs;
	}

	@Override
	public void createJob(Job job) {
		jobs.add(job);
	}

	@Override
	public Job getJobById(int id) {
		for(Job job : jobs) {
			if(job.getId() == id) {
				return job;
			}
		}
		return null;
	}

	@Override
	public void deleteJob(Job job) {
		jobs.remove(job);
	}

	@Override
	public boolean updateJob(int id, Job updatedJob) {
		for(Job job : jobs) {
			if(job.getId() == id) {
				job.setDesc(updatedJob.getDesc());
				job.setTitle(updatedJob.getTitle());
				job.setMinSalary(updatedJob.getMinSalary());
				job.setMaxSalary(updatedJob.getMaxSalary());
				job.setLocation(updatedJob.getLocation());
				
				return true;
			}
		}
		return false;
	}
	
	

}
