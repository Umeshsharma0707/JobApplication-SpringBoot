package com.jobapp.services;

import java.util.List;

import com.jobapp.models.Job;

public interface JobService {
   List<Job> findAll();
   void createJob(Job job);
Job getJobById(int id);
}
