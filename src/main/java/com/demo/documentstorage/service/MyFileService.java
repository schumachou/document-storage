package com.demo.documentstorage.service;


import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.demo.documentstorage.entity.MyFile;

public interface MyFileService {
	
	public MyFile uploadFile(MultipartFile file);
  
    public MyFile downloadFile(String fileId);
    
    public List<String> findAll();
    
    public void updateFile(String fileId, MultipartFile file);
    
    public void deleteFile(String fileId);
}
