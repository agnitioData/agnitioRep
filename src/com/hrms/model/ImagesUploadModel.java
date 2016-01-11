package com.hrms.model;

import java.io.File;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Employee_Images")
public class ImagesUploadModel {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
    @Column(name="Image_id")
	   private long imageId;
	
	@Column(name="Name")
	   private String name;
	
	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	@Column(name="Image_File")
	private File image;
	
	@Column(name = "Image_Data", length = 100000)
	private byte[] data;
	
	@Column(name="future_use2")
	private String future_use2;

	public long getImageId() {
		return imageId;
	}

	public void setImageId(long imageId) {
		this.imageId = imageId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getFuture_use2() {
		return future_use2;
	}

	public void setFuture_use2(String future_use2) {
		this.future_use2 = future_use2;
	}
	
	

}
