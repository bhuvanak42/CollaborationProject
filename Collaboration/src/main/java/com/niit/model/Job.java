package com.niit.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Job {
	@Id@GeneratedValue
	private int jobId;
	
	private String company;
	private String aboutCompany;
	private String role;
	private String skillsRequired;
	private String eligibilityCriteria;
	private String ctc;
	private Date dateOfInterview;
	private String addressOfTheCompany;
	private String urlOfTheCompany;
	
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getAboutCompany() {
		return aboutCompany;
	}
	public void setAboutCompany(String aboutCompany) {
		this.aboutCompany = aboutCompany;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getSkillsRequired() {
		return skillsRequired;
	}
	public void setSkillsRequired(String skillsRequired) {
		this.skillsRequired = skillsRequired;
	}
	public String getEligibilityCriteria() {
		return eligibilityCriteria;
	}
	public void setEligibilityCriteria(String eligibilityCriteria) {
		this.eligibilityCriteria = eligibilityCriteria;
	}
	public String getCtc() {
		return ctc;
	}
	public void setCtc(String ctc) {
		this.ctc = ctc;
	}
	public Date getDateOfInterview() {
		return dateOfInterview;
	}
	public void setDateOfInterview(Date dateOfInterview) {
		this.dateOfInterview = dateOfInterview;
	}
	public String getAddressOfTheCompany() {
		return addressOfTheCompany;
	}
	public void setAddressOfTheCompany(String addressOfTheCompany) {
		this.addressOfTheCompany = addressOfTheCompany;
	}
	public String getUrlOfTheCompany() {
		return urlOfTheCompany;
	}
	public void setUrlOfTheCompany(String urlOfTheCompany) {
		this.urlOfTheCompany = urlOfTheCompany;
	}
	

}

