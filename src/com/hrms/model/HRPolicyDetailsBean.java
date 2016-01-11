package com.hrms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="HR_Policies")
	
public class HRPolicyDetailsBean {

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name="id")
	   private long id;
	
	@Column(name="Documents")
	   private String documents;

	public String getDocuments() {
		return documents;
	}

	public void setDocuments(String documents) {
		this.documents = documents;
	}
	public HRPolicyDetailsBean(String documents) {
		// TODO Auto-generated constructor stub
		this.documents = documents;
	}
}
