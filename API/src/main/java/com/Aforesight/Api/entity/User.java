//Purpose;This class is used to create entity of the user table ,which stores details of the user.
//Developed by:Author Arthvedika dev team
//Date:26/01/2022
package com.Aforesight.Api.entity;

import lombok.Data;

import javax.persistence.*;

import org.springframework.context.annotation.Role;

import java.util.Set;

@Data
@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"Email_ID"}),
        
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	private String User_ID;
    private String username;
    private String password;
    private String Email_ID;
    private String First_Name;
    private String Last_Name;
    private String AD_User_login_ID;
    private String Password_enc;
    private String Mobile;
    private String Department;
    private String Location;
    private String Manager_Name;
    private String Manager_User_ID;
    private String Emp_Code;
    private String user_login;
    @Column(columnDefinition = "varchar(25) default ''")
    private String User_Type;
   // private String Admin_panel_enable;
    private String user_group_id;
    
    public String getUser_login() {
		return user_login;
	}

	public void setUser_login(String user_login) {
		this.user_login = user_login;
	}

	public String getUser_Type() {
		return User_Type;
	}

	public void setUser_Type(String user_Type) {
		User_Type = user_Type;
	}

	public String getUser_locked() {
		return user_locked;
	}

	public void setUser_locked(String user_locked) {
		this.user_locked = user_locked;
	}



	private String user_locked;
 


	@Column(columnDefinition = "varchar(255) default 'NO'")
   	private String Delete_status;
	

	public String getDelete_status() {
		return Delete_status;
	}

	public void setDelete_status(String delete_status) {
		Delete_status = delete_status;
	}

	public String getFirst_Name() {
		return First_Name;
	}

	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}

	public String getLast_Name() {
		return Last_Name;
	}

	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}

	public String getAD_User_login_ID() {
		return AD_User_login_ID;
	}

	public void setAD_User_login_ID(String aD_User_login_ID) {
		AD_User_login_ID = aD_User_login_ID;
	}

	public String getPassword_enc() {
		return Password_enc;
	}

	public void setPassword_enc(String password_enc) {
		Password_enc = password_enc;
	}

	public String getMobile() {
		return Mobile;
	}

	public void setMobile(String mobile) {
		Mobile = mobile;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getManager_Name() {
		return Manager_Name;
	}

	public void setManager_Name(String manager_Name) {
		Manager_Name = manager_Name;
	}

	public String getManager_User_ID() {
		return Manager_User_ID;
	}

	public void setManager_User_ID(String manager_User_ID) {
		Manager_User_ID = manager_User_ID;
	}

	public String getEmp_Code() {
		return Emp_Code;
	}

	public void setEmp_Code(String emp_Code) {
		Emp_Code = emp_Code;
	}

	

	public String getUser_ID() {
		return User_ID;
	}

	public void setUser_ID(String user_ID) {
		User_ID = user_ID;
	}



	public String getUser_group_id() {
		return user_group_id;
	}

	public void setUser_group_id(String user_group_id) {
		this.user_group_id = user_group_id;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail_ID() {
		return Email_ID;
	}

	public void setEmail_ID(String email_ID) {
		Email_ID = email_ID;
	}

	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public void setLoggedIn(boolean b) {
		// TODO Auto-generated method stub
		
	}

	
}