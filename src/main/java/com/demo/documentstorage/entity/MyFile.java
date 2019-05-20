package com.demo.documentstorage.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.apache.commons.lang3.RandomStringUtils;

@Entity
@Table(name = "files")
public class MyFile {
	
    @Id
    private String id;

    private String fileName;

    private String fileType;

    @Lob
    private byte[] data;

    public MyFile() {

    }

    public MyFile(String fileName, String fileType, byte[] data) {
    	id = RandomStringUtils.randomAlphanumeric(20);
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }
    
    public MyFile(String id, String fileName, String fileType, byte[] data) {
    	this.id = id;
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}
    
}
