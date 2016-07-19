package com.om.mvc.model.service.registration;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.om.mvc.dto.registration.RegistrationDTO;
import com.om.mvc.model.dao.registration.RegistrationDAO;

@Service
public class RegistrationService
{
	@Autowired
	private RegistrationDAO registrationDAO;
	
	Serializable pk=null;
	public RegistrationService() 
	{
		System.out.println("registration service created");
	}
	
	public Serializable regist(RegistrationDTO dto)
	{
		System.out.println("inside regist method of service");
		pk=registrationDAO.save(dto);
	/*	if(pk!=null)
		{
			return pk;
		}
		return null;
		*/
		Optional<Serializable> primary=Optional.ofNullable(pk);
		if(primary.isPresent())
		{
			return pk;
		}
		return primary.orElse(new Integer(-1));
	}

}
