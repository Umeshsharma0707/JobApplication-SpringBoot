package com.jobapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobapp.models.Company;

@Service
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	private CompanyRepository companyRepository;
	@Override
	public List<Company> getAllCompanies() {
		
		return companyRepository.findAll();
	}
	@Override
	public boolean updateCompany(int id, Company updateCompany) {
		Optional<Company> byId = companyRepository.findById(id);
		
		if(byId.isPresent()) {
			Company company = byId.get();
			company.setDescription(updateCompany.getDescription());
			company.setName(updateCompany.getName());
			company.setJobs(updateCompany.getJobs());
			companyRepository.save(company);
			return true;
		}
		return false;
	}
	@Override
	public void createCompany(Company company) {
		this.companyRepository.save(company);
	}
	@Override
	public Company getCompanyById(int id) {
		return this.companyRepository.findById(id).orElse(null);
	}
	@Override
	public boolean deleteCompany(int id) {
		Company company = this.companyRepository.findById(id).orElse(null);
		
		if(company != null) {
			this.companyRepository.delete(company);
			return true;
		}else {
			return false;
		}
	}

}
