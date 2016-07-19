package com.om.mvc.dto.login;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="login_table")
public class LoginDTO 
{
	@Id
	@GenericGenerator(name="myId",strategy="increment")
	@GeneratedValue(generator="myId")
	@Column(name="id")
	private int id;
	@Column(name="userid")
	private String userid;
	@Column(name="password")
	private String password;
	@Override
	public String toString() {
		return "LoginDTO [id=" + id + ", userid=" + userid + ", password=" + password + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
