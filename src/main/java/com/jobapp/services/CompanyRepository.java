package com.jobapp.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobapp.models.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer>{

}
