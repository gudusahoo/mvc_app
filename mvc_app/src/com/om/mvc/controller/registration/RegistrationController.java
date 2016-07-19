package com.om.mvc.controller.registration;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.om.mvc.dto.registration.RegistrationDTO;
import com.om.mvc.model.service.registration.RegistrationService;

@Controller
public class RegistrationController 
{
	@Autowired
	private RegistrationService registrationService;
	
	public RegistrationController() 
	{
		System.out.println("registration controller created");
	}
	@RequestMapping(value="register", method=RequestMethod.POST)
	public String register(@ModelAttribute RegistrationDTO registrationDTO , HttpServletRequest request)
	{
		System.out.println("inside register method in registration controller");
		System.out.println(registrationDTO);
		Serializable pk=registrationService.regist(registrationDTO);
		request.setAttribute("display",pk);
		if(pk!=null)
		{
			return "/sucess.jsp";
		}
		return "/registration.jsp";
	}
	

}
