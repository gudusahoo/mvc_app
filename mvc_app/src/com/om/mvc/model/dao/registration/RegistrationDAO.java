package com.om.mvc.model.dao.registration;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.om.mvc.dto.registration.RegistrationDTO;

@Repository
public class RegistrationDAO
{
	@Autowired
	private SessionFactory factory;
	
	public RegistrationDAO() 
	{
		System.out.println("registration dao created");
	}
	
	public Serializable save(RegistrationDTO dto)
	{
		System.out.println("inside save method of registrationDAO");
		System.out.println("session factory created");
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Serializable pk=null;
		try 
		{
			pk=session.save(dto);
			tx.commit();
			System.out.println(pk);
			return pk;
		
		} catch (HibernateException he) 
		{
			he.printStackTrace();
			tx.rollback();
		}
		finally 
		{
			session.close();
			
		}
		
		return null;
	}
	
	

}
