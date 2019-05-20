package com.demo.documentstorage.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.demo.documentstorage.dao.MyFileRepository;
import com.demo.documentstorage.entity.MyFile;
import com.demo.documentstorage.exception.FileAccessException;
import com.demo.documentstorage.exception.MyFileNotFoundException;

@Service
public class MyFileServiceImpl implements MyFileService{

    @Autowired
    private MyFileRepository myFileRepository;
    
    // Store file
    public MyFile uploadFile(MultipartFile file){
    	try {
    		MyFile theFile = new MyFile(file.getOriginalFilename(), file.getContentType(), file.getBytes());
    		return myFileRepository.save(theFile);
    	}catch(IOException e) {
    		throw new FileAccessException("File access error");
    	}
    }
    
    // Get file by id, throw MyFileNotFoundException if the id does not exist
    public MyFile downloadFile(String fileId){
        return myFileRepository.findById(fileId)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id - " + fileId));     
    }
    
    public List<String> findAll(){
    	List<MyFile> files = myFileRepository.findAll();
    	List<String> ids = new ArrayList<>();
    	for(MyFile file : files) {
    		ids.add(file.getId());
    	}
    	return ids;
    }
    
    // Update file by id
    public void updateFile(String fileId, MultipartFile file){
    	MyFile prevDbfile = downloadFile(fileId);
    	try {
	        MyFile theFile = new MyFile(prevDbfile.getId(), file.getOriginalFilename(), file.getContentType(), file.getBytes());
	        myFileRepository.save(theFile);
    	}catch(IOException e) {
    		throw new FileAccessException("File access error");
    	}
    }
    
    // Delete file by id
    public void deleteFile(String fileId) {
    	MyFile prevFile = downloadFile(fileId);
    	myFileRepository.deleteById(prevFile.getId());
    }
}
