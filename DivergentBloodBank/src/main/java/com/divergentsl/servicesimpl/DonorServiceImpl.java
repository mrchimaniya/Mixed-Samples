package com.divergentsl.servicesimpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.divergentsl.entity.Donor;
import com.divergentsl.repo.DonorRepository;
import com.divergentsl.services.DonorService;

@Service
public class DonorServiceImpl implements DonorService{
	
    @Autowired
    DonorRepository donorRepository;
	
    @Override
	public String registerDonor(Donor donor)
	 {
		Optional<Donor> donorRetrieve= donorRepository.findByPhone(donor.getPhone());
		if(donorRetrieve.isEmpty())
		{    
			 donorRepository.save(donor);
			 return "Congratulation! Thanks For Your Contributon <br> You Have Sucessfully Registered.";
		}
    	return "Opps! Your Phone Number Is Already Registered.";
     }

	@Override
	public List<Donor> searchBloodByArea(String bloodGroup) {
		return donorRepository.findByBloodgroup(bloodGroup);
	}

	@Override
	public List<Donor> searchBloodByNearestHospital(String bloodGroup, String nearestBloodBank) {
		return donorRepository.findByBloodgroupAndNearestbloodbank(bloodGroup,nearestBloodBank);
	}

	@Override
	public Optional<Donor> userLogin(String phone,String password) {
		return donorRepository.findByPhoneAndPassword(phone, password);
	}

	@Override
	public Optional<Donor> searchDonorByPhone(String Phone) {
	    return donorRepository.findByPhone(Phone);
	}

	@Override
	public String updateDonor(Donor donor) {
		     donorRepository.save(donor);
			 return "Congratulation! Your Profile Has Been Updated Sucessfully<br>Thanks For Your Contributon";
	}

	@Override
	public Optional<Donor> forgetPassword(String name, String phone, String bloodgroup) {
		return donorRepository.findByNameAndPhoneAndBloodgroup(name, phone, bloodgroup);
	}
	
	@Override
	@Transactional
	public Integer deleteDonor(String phone)
	{   
	    return donorRepository.deleteByPhone(phone);
		
	}

	@Override
	public List<Donor> showAllDonors() {
		return donorRepository.findAll();
	}

	@Override
	public List<Donor> searchDonorByBloodgroup(String bloodgroup) {
		return donorRepository.findByBloodgroup(bloodgroup);
	}
}
