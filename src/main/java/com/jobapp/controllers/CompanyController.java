package com.jobapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobapp.models.Company;
import com.jobapp.services.CompanyService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/companies")
public class CompanyController {
	@Autowired
	private CompanyService companyService;

	@GetMapping
	public ResponseEntity<List<Company>> getAllCompanies() {
		return ResponseEntity.ok(companyService.getAllCompanies());
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateCompany(@PathVariable int id, @RequestBody Company company) {
		boolean updateCompany = companyService.updateCompany(id, company);

		if (updateCompany == true) {
			return new ResponseEntity<String>("company updated successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("company not found", HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/")
	public ResponseEntity<String> addCompany(@RequestBody Company company) {
		this.companyService.createCompany(company);

		return new ResponseEntity<String>("company added successfully", HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getCompanyById(@PathVariable int id) {
		Company company = this.companyService.getCompanyById(id);

		if (company != null) {
			return new ResponseEntity<Company>(company, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("company not found", HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCompany(@PathVariable int id){
			boolean deleteCompany = this.companyService.deleteCompany(id);
			
			if(deleteCompany == true) {
				return new ResponseEntity<String>("company deleted successfully",HttpStatus.OK);
			}else {
				return new ResponseEntity<String>("company not found",HttpStatus.NOT_FOUND);
			}
	}
}


