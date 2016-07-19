package com.om.mvc.model.dao.login;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.om.mvc.dto.login.LoginDTO;

@Repository
public class LoginnDAO 
{
	public LoginnDAO() 
	{
		System.out.println("dao created");
	}
	
	@Autowired
	private SessionFactory sessionFactory;

	public LoginDTO authAndfetch(LoginDTO loginDTO)
	{
		//connect to data base
		System.out.println("session factory \t"+sessionFactory);
		System.out.println("inside auth And fetch");
		Session session=sessionFactory.openSession();
		String hql="from LoginDTO where userid=:user and password=:pass";
		try 
		{
			Query query=session.createQuery(hql);
			query.setParameter("user", loginDTO.getUserid());
			query.setParameter("pass", loginDTO.getPassword());
			LoginDTO fromDB=(LoginDTO) query.uniqueResult();
			System.out.println("from db inside dao \t"+fromDB);
			return fromDB;
		} catch (Exception e) 
		{
			e.printStackTrace();
			
		}
		finally
		{
			session.close();
		}
		
		return null;
	}
	
}
