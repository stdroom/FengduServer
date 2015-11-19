package com.demo.model.models;

import java.util.Calendar;
import com.infrastructure.project.base.model.interfaces.ICUDEable;
import com.infrastructure.project.base.model.models.EnableEntity;

public class Account extends EnableEntity<Integer> implements ICUDEable {

	private String email;
	private String username;
	private String password;
	private Calendar registerTime;
	private Role role;
	private Organization organization;
	
	public void setEmail(String email){
		this.email=email;
	}
	public void setUsername(String username){
		this.username=username;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public void setRegisterTime(Calendar registerTime){
		this.registerTime=registerTime;
	}
	public void setRole(Role role){
		this.role=role;
	}
	public void setOrganization(Organization organization){
		this.organization=organization;
	}

	public String getEmail(){
		return this.email;
	}
	public String getUsername(){
		return this.username;
	}
	public String getPassword(){
		return this.password;
	}
	public Calendar getRegisterTime(){
		return this.registerTime;
	}
	public Role getRole(){
		return this.role;
	}	
	public Organization getOrganization(){
		return this.organization;
	}
	
}
