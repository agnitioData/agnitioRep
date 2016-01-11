package com.hrms.model;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Employee_Events")
public class EventsUploadModel {

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
    @Column(name="Event_Id")
	   private long eventId;
	 
	 /*@Lob
	 @Column(name="Image_Data", columnDefinition="mediumblob")
	 private Blob data;*/
	
	@Column(name = "Image_Data", length = 100000)
	private byte[] data;
	 
	@Column(name="Title")
	private String titleName;
	
	@Column(name="Description")
	private String description;
	
	@Column(name="future_use1")
	private int future_use1;
	
	@Column(name="future_use2")
	private String future_use2;

	
	public EventsUploadModel() {
	}

	public EventsUploadModel(byte[] data, String titleName) {
		this.data = data;
		this.titleName = titleName;
	}

	public long getEventId() {
		return eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
