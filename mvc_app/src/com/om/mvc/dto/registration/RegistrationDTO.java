package com.om.mvc.dto.registration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "registeration_tb")
public class RegistrationDTO {
	@Id
	@GenericGenerator(name="myId" , strategy="increment")
	@GeneratedValue(generator="myId")
	@Column(name="id")
	private int id;
	@Column
	private String fn;
	@Column
	private String ln;
	@Column
	private String age;
	@Column
	private String mob;
	@Column
	private String email;
	@Override
	public String toString() {
		return "RegistrationDTO [id=" + id + ", fn=" + fn + ", ln=" + ln + ", age=" + age + ", mob=" + mob + ", email="
				+ email + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFn() {
		return fn;
	}
	public void setFn(String fn) {
		this.fn = fn;
	}
	public String getLn() {
		return ln;
	}
	public void setLn(String ln) {
		this.ln = ln;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
