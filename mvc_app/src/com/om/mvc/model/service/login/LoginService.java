package com.om.mvc.model.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.om.mvc.dto.login.LoginDTO;
import com.om.mvc.model.dao.login.LoginnDAO;

@Service
public class LoginService
{
	@Autowired
	private LoginnDAO loginnDAO;
	public LoginService() 
	{
		System.out.println("services created");
	}
	public LoginDTO auth(LoginDTO dto)
	{
		System.out.println("inside login service auth method");
		LoginDTO fromDAO=loginnDAO.authAndfetch(dto);
		if (fromDAO!=null) {
			return fromDAO;
		}
		return null;
	}

}
