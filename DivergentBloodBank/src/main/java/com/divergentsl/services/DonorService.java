package com.divergentsl.services;

import java.util.List;
import java.util.Optional;

import com.divergentsl.entity.Donor;

public interface DonorService {

	 public String registerDonor(Donor donor);
	 public List<Donor> searchBloodByArea(String bloodGroup);
	 public List<Donor> searchBloodByNearestHospital(String bloodGroup, String nearestBloodBank);
	 public Optional<Donor> userLogin(String phone,String password);
	 public Optional<Donor> searchDonorByPhone(String Phone);
	 public String updateDonor(Donor donor);
	 public Optional<Donor> forgetPassword(String name,String phone,String bloodgroup);
	 public Integer deleteDonor(String phone); 
	 
	 public List<Donor> showAllDonors();
	public List<Donor> searchDonorByBloodgroup(String bloodgroup);
}
