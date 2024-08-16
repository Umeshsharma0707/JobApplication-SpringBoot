package com.jobapp.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobapp.models.Job;

public interface JobRepository extends JpaRepository<Job, Integer>{

}
