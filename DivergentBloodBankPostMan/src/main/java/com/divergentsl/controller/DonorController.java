package com.divergentsl.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.divergentsl.entity.Donor;
import com.divergentsl.services.DonorService;


@Controller
@RequestMapping("/donor")
public class DonorController {

	@Autowired
	DonorService donorService;
	
//	request for showing views only
	@GetMapping("/")
	public String index()
	{
		return "index";
	}
	
	@GetMapping("/home")
	public String home()
	{
		return "home";
	}
	
	@GetMapping("/donate")
	public String donate()
	{
		return "donate";
	}
	
	@GetMapping("/search")
	public String search()
	{
		return "search";
	}
	
	@GetMapping("/login")
	public String login()
	{
		return "login";
	}
	
	@GetMapping("/unregister")
	public String unRegister()
	{
		return "unregister";
	}
	
	@GetMapping("/support")
	public String support()
	{
		return "support";
	}
	
	@GetMapping("/userlogin")
	public String userLogin()
	{
		return "userlogin";
	}
	

	
	@GetMapping("/forgetpassword")
	public String forgetPassword()
	{
		return "forgetpassword";
	}
	
	@GetMapping("/searchbyarea")
	public String searchByArea()
	{
		return "searchbyarea";
	}
	
	@GetMapping("/searchbynearestbloodbank")
	public String searchByHospital()
	{
		return "searchbynearestbloodbank";
	}
	
	@GetMapping("/confirm")
	public String confim()
	{
		return "confirm";
	}
	
	@GetMapping("/donorfound")
	public String donorFound()
	{
		return "donorfound";
	}
	
	
//	request for operations
	
	@PostMapping("/registerdonorrequest")
	public String registerDonor(Donor donor, Model model)
	{  
		String status=donorService.registerDonor(donor);
		model.addAttribute("status",status);
		return "status";
	}
	
	@GetMapping("/searchbloodbyarearequest/{currentPage}")  
	public String findBloodByArea(@PathVariable int currentPage,
			                      @RequestParam(required = false) String sortField ,
            					  @RequestParam(required = false) String sortDir,
			                      @RequestParam String bloodGroup, Model model)
	{  
		Sort sort=sortDir.equalsIgnoreCase("asc") ? Sort.by(sortField).ascending(): Sort.by(sortField).descending();
     	Pageable pageable=PageRequest.of(currentPage,3,sort);
        Page<Donor> page = donorService.searchDonorByBloodGroupWithPaginationAndSorting(bloodGroup,pageable);
		List<Donor> donorsRecord = page.getContent(); 
		  if(donorsRecord.isEmpty())
		  {
			  model.addAttribute("status","!Opps No Donors Are Available");
			  return "status";
		  }
		model.addAttribute("bloodFilter","All Available Donors Of <span style='color:red'>"+bloodGroup+"</span> In Indore");
		model.addAttribute("donorsRecord",donorsRecord);
        
		model.addAttribute("currentPage",currentPage);
		model.addAttribute("totalPages",page.getTotalPages());
		
		model.addAttribute("bloodGroup",bloodGroup);
		model.addAttribute("sortField",sortField);
		model.addAttribute("sortDir",sortDir);
		model.addAttribute("reverseDir",sortDir.equalsIgnoreCase("asc") ? "desc" : "asc");
		return "donorrecordtableforuserblood";
	}
	
	@GetMapping("/searchbynearestbloodbankrequest/{currentPage}")
	public String findBloodByNearestHospital(@PathVariable int currentPage,
								             @RequestParam(required = false) String sortField ,
											 @RequestParam(required = false) String sortDir,
								             @RequestParam String bloodGroup,
								             @RequestParam String nearestBloodBank,Model model)
	{  
		Sort sort=sortDir.equalsIgnoreCase("asc") ? Sort.by(sortField).ascending(): Sort.by(sortField).descending();
	 	Pageable pageable=PageRequest.of(currentPage,3,sort);
	    Page<Donor> page = donorService.searchDonorByNearestHospitalWithPaginationAndSorting(bloodGroup, nearestBloodBank, pageable);
		List<Donor> donorsRecord = page.getContent(); 
		  if(donorsRecord.isEmpty())
		  {
			  model.addAttribute("status","!Opps No Donors Are Available");
			  return "status";
		  }
		model.addAttribute("bloodFilter","All Available Donors Of <span style='color:red'>"+bloodGroup+"</span> In Indore");
		model.addAttribute("donorsRecord",donorsRecord);
	    
		model.addAttribute("currentPage",currentPage);
		model.addAttribute("totalPages",page.getTotalPages());
		
		model.addAttribute("bloodGroup",bloodGroup);
		model.addAttribute("nearestBloodBank",nearestBloodBank);
		model.addAttribute("sortField",sortField);
		model.addAttribute("sortDir",sortDir);
		model.addAttribute("reverseDir",sortDir.equalsIgnoreCase("asc") ? "desc" : "asc");
		return "donorrecordtableforusernearesthospital";
	}
	
	@GetMapping("/userloginrequest")
	public String userLoginRequest(@RequestParam String phone, @RequestParam String password, Model model)
	{   
		String result="";
		Optional<Donor> donor=donorService.userLogin(phone, password);
		if(donor.isEmpty())
		{
			model.addAttribute("status","OPPS! Record Not Found");
			return "status";
		}
		model.addAttribute(donor.get());
		return "userlogindata";
	}
	
	@GetMapping("/updateuser")
	public String updateUser(@RequestParam String phone, Model model)
	{  
		Optional<Donor> donorData= donorService.searchDonorByPhone(phone);
		Donor donor=donorData.get();
		model.addAttribute("donor",donor);
		return "updateuser";
	}
	
	@PostMapping("/updateuserdata")
	public String updateUserData(Donor donor, Model model)
	{  
		String status=donorService.updateDonor(donor);
		model.addAttribute("status",status);
		return "status";
	}
	
	@GetMapping("/forgetpassworddata")
	public String forgetPasswordData(@RequestParam String name, @RequestParam String phone, @RequestParam String bloodgroup, Model model)
	{
		Optional<Donor> donordata=donorService.forgetPassword(name, phone, bloodgroup);
		if(donordata.isEmpty())
		{
			model.addAttribute("status","<span style='font-size:30'>Opps! Record Not Found<span>");
			return "status";
		}
		Donor donor=donordata.get();
		model.addAttribute("donor",donor);
		return "showpassword";
	}
	
	@GetMapping("/finduserforunregister")
	public String findUserForUnregister(String phone,Model model)
	{
		Optional<Donor> donorData = donorService.searchDonorByPhone(phone);
		if(donorData.isEmpty())
		{
			model.addAttribute("status","Opps! Record Not Found");
			return "status";
		}
		Donor donor=donorData.get();
		model.addAttribute("donor",donor);
		return "donorfound";
	}
	
	@GetMapping("/confirmunregister")
	public String confirmUnRegisterDonor(String phone,String name, Model model)
	{
		model.addAttribute("phone",phone);
		model.addAttribute("name",name);
		return "confirmunregister";
	}
	 
	
	@PostMapping("/unregisterdata")
	public String unRegisterData(@RequestParam String phone,@RequestParam String password,Model model)
	{
		Optional<Donor> donorData = donorService.userLogin(phone, password);
		if(donorData.isEmpty())
		{
			model.addAttribute("status","Opps! Retry<br>Your Password Was Not Matched.");
			return "wrongpassword";
		}
		
		Integer status=donorService.deleteDonor(phone);
		if(status==1)
		{
			model.addAttribute("status","Your Profile Has Been Deleted!<br>Thank You For Your Contribution");
			return "status";
		}
		model.addAttribute("Something Went Wrong! Please Try Again");	
		return "status";
	}	
	
}
