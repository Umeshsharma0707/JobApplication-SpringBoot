package com.jobapp.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity

public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	
	@JsonIgnore
	@OneToMany(mappedBy = "company",cascade = CascadeType.ALL)
	private List<Job> jobs;
	
	@JsonIgnore
	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
	private List<Review> reviews;
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Job> getJobs() {
		return jobs;
	}
	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}
	
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", description=" + description + ", jobs=" + jobs + ", reviews="
				+ reviews + "]";
	}
	
	
}
