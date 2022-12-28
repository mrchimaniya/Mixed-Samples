package com.divergentsl.servicesimpl;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divergentsl.entity.Admin;
import com.divergentsl.entity.Donor;
import com.divergentsl.repo.AdminRepository;
import com.divergentsl.repo.DonorRepository;
import com.divergentsl.services.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	DonorRepository donorRepository;
	
	@Override
	public String searchAdmin(String name, String password) {
		Optional<Admin> adminData=adminRepository.findByNameAndPassword(name, password);
		if(adminData.isEmpty())
			return "notfound";
		else
			return "found";
	}


}
