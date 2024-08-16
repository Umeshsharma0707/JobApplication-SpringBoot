package com.jobapp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jobapp.models.Company;

public interface CompanyService {
	List<Company> getAllCompanies();
	boolean updateCompany(int id, Company company);
	void createCompany(Company company);
	Company getCompanyById(int id);
	boolean deleteCompany(int id);
}
