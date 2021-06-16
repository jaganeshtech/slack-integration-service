/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eloqua.rs.eas.model;

import java.util.List;

/**
 *
 * @author ganeshraja
 */
public class Registrant {

    private String email;
    private String first_name;
    private String last_name;
//    private String address;
//    private String city;
//    private String country;
//    private String zip;
//    private String state;
//    private String phone;
//    private String industry;
    private String org;
    private String job_title;
//    private String purchasing_time_frame;
//    private String role_in_purchase_process;
//    private String no_of_employees;
//    private String comments;
//    private List<CustomQuestions> custom_questions;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

//    public String getIndustry() {
//        return industry;
//    }
//
//    public void setIndustry(String industry) {
//        this.industry = industry;
//    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

	public String getOrg() {
		return org;
	}

	public void setOrg(String org) {
		this.org = org;
	}

	@Override
	public String toString() {
		return "Registrant [email=" + email + ", first_name=" + first_name + ", last_name=" + last_name + ", org=" + org
				+ ", job_title=" + job_title + "]";
	}

    
    
    
   

      
    
    
    
    
    
}
