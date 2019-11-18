package com.gr21.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="employees")
public class Employees {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int employee_id;
	String fullname;
	String address;
	int sex;
	String idcard;
	@OneToOne
	@JoinColumn(name="role_id",referencedColumnName = "role_id")

	Roles roles;
	String email;
	String username;
	String password;
	public int getEmployee_id() {
		return employee_id;
	}
	public String getFullname() {
		return fullname;
	}
	public String getAddress() {
		return address;
	}

	public String getIdcard() {
		return idcard;
	}
	public Roles getRoles() {
		return roles;
	}
	public String getEmail() {
		return email;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public void setRoles(Roles roles) {
		this.roles = roles;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	} 
	
	
}
