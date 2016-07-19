package com.om.mvc.controller.login;

//coomiting
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.om.mvc.dto.login.LoginDTO;
import com.om.mvc.model.service.login.LoginService;

@Controller
@RequestMapping("/")
public class LoginController 
{
	@Autowired
	private LoginService loginService;
	
	
	public LoginController() 
	{
		System.out.println("controller created");
	}
	@RequestMapping(value="/anything" , method=RequestMethod.POST)
	public String authenticate(@ModelAttribute LoginDTO loginDTO)
	{
		System.out.println("inside authenticate method");
		System.out.println(loginDTO);
		LoginDTO fromService=loginService.auth(loginDTO);
		if(fromService!=null)
		{
			return "/home.jsp";
		}
		return "/login.jsp";
	}

}
