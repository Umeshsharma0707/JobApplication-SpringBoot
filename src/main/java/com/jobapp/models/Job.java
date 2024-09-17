package com.jobapp.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "jobs_table")
public class Job {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int id;
	private String title;
	private String desc;
	private String minSalary;
	private String maxSalary;
	private String location;
	@ManyToOne
	private Company company;
	
	public Job() {
		super();
	}
	public Job(int id, String title, String desc, String minSalary, String maxSalary, String location) {
		super();
		this.id = id;
		this.title = title;
		this.desc = desc;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.location = location;
	}
	public Job(int id, String title, String desc, String minSalary, String maxSalary, String location,
			Company company) {
		super();
		this.id = id;
		this.title = title;
		this.desc = desc;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.location = location;
		this.company = company;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getMinSalary() {
		return minSalary;
	}
	public void setMinSalary(String minSalary) {
		this.minSalary = minSalary;
	}
	public String getMaxSalary() {
		return maxSalary;
	}
	public void setMaxSalary(String maxSalary) {
		this.maxSalary = maxSalary;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "Job [id=" + id + ", title=" + title + ", desc=" + desc + ", minSalary=" + minSalary + ", maxSalary="
				+ maxSalary + ", location=" + location + ", company=" + company + "]";
	}
	
	
	
	
	
}
