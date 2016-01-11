package com.hrms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Employee_Events_Details")
public class EmpEventsUploadModel {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
    @Column(name="Event_id")
	   private long eventId;
	
	/*@Lob
	@Column(name="DATA", columnDefinition="mediumblob")
	private Blob image;*/
	
	@Column(name = "Image_Data", length = 100000)
	private byte[] data;
	
	@Column(name="Title_name")
	   private String titleName;
	   
	@Column(name="Description", nullable = false)
	   private String description;
	
	@Column(name="File_Path")
	private String filePath;
	
	@Column(name="future_use1")
	private int future_use1;
	
	@Column(name="future_use2")
	private String future_use2;
	
	public EmpEventsUploadModel(){
		
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
	/*public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}*/

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

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	

}
