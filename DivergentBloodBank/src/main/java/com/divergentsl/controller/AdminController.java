package com.divergentsl.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.divergentsl.entity.Donor;
import com.divergentsl.services.AdminService;
import com.divergentsl.services.DonorService;

@Controller
@RequestMapping("/admin")
public class AdminController {
   
	@Autowired
	AdminService adminService;
	
	@Autowired
	DonorService donorService;
	
		@GetMapping("/adminlogin")
		public String adminLogin()
		{
			return "adminlogin";
		}
		
		@GetMapping("/admincontrol")
		public String adminControl(String name,String password,Model model)
		{
			String status=adminService.searchAdmin(name, password);
			if(status.equals("found"))
     			return "admincontrol";
			model.addAttribute("status","Opps! Admin Not Found");
			return "status";
		}
		
		@GetMapping("/alldonors")
		public String allUsers(Model model)
		{
			List<Donor> donorsRecord=donorService.showAllDonors();
			if(donorsRecord.isEmpty())
			{    
				model.addAttribute("status","Opps! No Donors Found");
				return "status";
			}
			model.addAttribute("donorsRecord",donorsRecord);
			return "donorrecordtableforadmin";
		}
		
		
		@GetMapping("/adminphoneform")
		public String adminPhoneForm()
		{
			return "adminphoneform";
		}
		
		@GetMapping("/donorsbyphone")
		public String usersByPhone(String phone,Model model)
		{
			Optional<Donor> donor = donorService.searchDonorByPhone(phone);
			if(donor.isEmpty())
			{    
				model.addAttribute("status","Opps! No Donors Found");
				return "status";
			}
			List<Donor> donorsRecord=new ArrayList<>();
			donorsRecord.add(donor.get());
			model.addAttribute("donorsRecord",donorsRecord);
			return "donorrecordtableforadmin";
		}
		
		@GetMapping("/adminbloodform")
		public String adminBloodForm()
		{
			return "adminbloodform";
		}
	    
		@GetMapping("/donorsbyblood")
		public String donorsByBlood(String bloodGroup,Model model)
		{
			List<Donor> donorsRecord = donorService.searchDonorByBloodgroup(bloodGroup);
			if(donorsRecord.isEmpty())
			{    
				model.addAttribute("status","Opps! No Donors Found");
				return "status";
			}
			model.addAttribute("donorsRecord",donorsRecord);
			return "donorrecordtableforadmin";
		}
		
		
		@GetMapping("/admineditdonorform")
		public String adminEditDonorForm(String phone,Model model)
		{
			Optional<Donor> donorData = donorService.searchDonorByPhone(phone);
			if(donorData.isEmpty())
			{   
				model.addAttribute("status","Opps! No Donors Found");
				return "status";
			}
			Donor donor=donorData.get();
			model.addAttribute("donor",donor);
			return "admineditdonorform";
		}
		
		@PostMapping("admineditdonor")
		public String adminEditDonor(Donor donor,String oldphone,Model model)
		{
			if(oldphone.equals(donor.getPhone())==false)
			{
				donorService.deleteDonor(oldphone);
			}
			String staus2=donorService.registerDonor(donor);	
			model.addAttribute("status","Updation Sucess");
			return "status";	
		}
		
		@GetMapping("/admindeleteconfirm")
		public String adminDeleteForm(String name,String phone,Model model)
		{
			model.addAttribute("name",name);
			model.addAttribute("phone",phone);
			return "admindeleteconfirm";
		}
		
		@GetMapping("/adminno")
		public String adminNo()
		{
			return "admincontrol";
		}
		
		@PostMapping("adminyes")
		public String adminYes(String phone,Model model)
		{
		   Integer check=donorService.deleteDonor(phone);
		   if(check==1)
			{
			   model.addAttribute("status","Donor Deleted Sucessfully<br>"
			   	  + "<a href='/admin/adminno'>Go Back</a>");
			   return "status";
			}
		   else
			  model.addAttribute("status","Something Went Wrong!<br>Deletion Failure");
		      return "status";
			
		}

}
