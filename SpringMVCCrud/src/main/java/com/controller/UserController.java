package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.entity.User;
import com.service.UserService;

@Controller
public class UserController {
	
	@Autowired 
	private UserService userservice ;

	 @Autowired
	    private MailSender mailSender;
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public boolean homepage(){
		return true;
	}
	@RequestMapping(value={ "/SpringMVCCrud/register" }, method=RequestMethod.GET)
	public ModelAndView RegisterUser(){
		ModelAndView model;
		model = new ModelAndView("register");
		return model;
	}
	/*@RequestMapping(value={"/SpringMVCCrud/registerprocess"}, method=RequestMethod.POST)
	public   ModelAndView Registerprocess( User users){
		userservice.RegisterUser(users);
		userservice.sendMail("ramanpopli19@gmail.com", users, "User Registered", "Hello, User You! are now registered with MedCare , enjoy our services ");
		System.out.println("mail sent");
		
		ModelAndView mv;
		mv =  new ModelAndView("login");
		return mv ;	
	}*/
	@RequestMapping(value={"/SpringMVCCrud/registerprocess"}, method=RequestMethod.POST )
	public @ResponseBody  boolean Registerprocess (@RequestBody User users){
		boolean user=userservice.RegisterUser(users);
		
		
		  if(users.getAddress() != null&&users.getEmail() != null&&users.getMobile() != null&&users.getPassword() != null&&users.getUsername() != null&&users.getAddress().length() != 0 && users.getEmail().length() != 0 && users.getMobile().length() != 0 && users.getPassword().length() != 0 && users.getUsername().length() != 0  )
		  {
			  userservice.sendMail("ramanpopli19@gmail.com", users, "User Registered", "Hello, User You! are now registered with MedCare , enjoy our services ");
			  System.out.println("mail sent");
              return true;
		  } 
        else{
              return false;
        }



		
	}
	/*@RequestMapping(value={ "/SpringMVCCrud/login" }, method=RequestMethod.GET)
	public ModelAndView LoginUser(){
		ModelAndView model;
		model = new ModelAndView("login");
		return model;
	}*/
	/*@RequestMapping(value="/SpringMVCCrud/loginprocess", method=RequestMethod.POST)
	public @ResponseBody ModelAndView loginprocess(User users){
		ModelAndView model=null;
		List<User> listOfUser= new ArrayList();
		listOfUser = userservice.LoginUser(users);
		
		if(!listOfUser.isEmpty()){
			for (User user2 : listOfUser) {
				if (users.getUsername().equalsIgnoreCase(user2.getUsername())&& users.getPassword().equalsIgnoreCase(user2.getPassword())) 
				{
				    model = new ModelAndView("welcome");
				    model.addObject("Username", user2.getUsername());
				    break;
				} 
			}
		}
		
		else{
			model = new ModelAndView("login");
		    model.addObject("message", "No User Found with these Credentials");
		}
		return model;		
	}*/
	@RequestMapping(value={"/SpringMVCCrud/loginprocess"}, method=RequestMethod.POST )
	public @ResponseBody  boolean loginprocess (@RequestBody User users){
		List<User> user=userservice.LoginUser(users);
	
		if(users.getPassword() != null&&users.getUsername() != null&&users.getUsername().length() != 0 && users.getPassword().length() != 0 )
		return true;	
		
		else
			return false;
		
	}
		
	
	@RequestMapping(value={ "/SpringMVCCrud/welcome" }, method=RequestMethod.GET)
	public ModelAndView Welcome(){
		ModelAndView model;
		model = new ModelAndView("welcome");
		return model;
	}
	
	
	
	
	
	/*@RequestMapping(value="/getResult",method = RequestMethod.GET)

    public @ResponseBody User testGet() {

                    User res = new User() ;

                    res.setUsername("raftaar");

                    

         // model.addAttribute("message", "Hello Spring MVC Framework!");

         return res;

    }*/
}
