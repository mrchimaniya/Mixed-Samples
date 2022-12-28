package com.divergentsl.servicesimpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
			 Donor savedDonor = donorRepository.save(donor);
			 if(savedDonor!=null)
			  return "Congratulation! Thanks For Your Contributon <br> You Have Sucessfully Registered.";
		}
    	return "Opps! Your Phone Number Is Already Registered.";
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


	//this service is for admin use only
	@Override
	public Page<Donor> showAllDonorsWithPaginationAndSorting(Pageable pageable) 
	{
		Page<Donor> page = donorRepository.findAll(pageable);	
		return page;
	}
	
	@Override
	public Page<Donor> searchDonorByBloodGroupWithPaginationAndSorting(String bloodGroup,Pageable pageable)
	{
		Page<Donor> page = donorRepository.findByBloodgroup(bloodGroup,pageable);
		return page;
	}

	@Override
	public Page<Donor> searchDonorByNearestHospitalWithPaginationAndSorting(String bloodGroup, String nearestBloodBank,Pageable pageable)
	{
		Page<Donor> page=donorRepository.findByBloodgroupAndNearestbloodbank(bloodGroup, nearestBloodBank, pageable);
		return page;
	}

}
