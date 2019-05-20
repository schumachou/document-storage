package com.demo.documentstorage.rest;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.demo.documentstorage.entity.MyFile;
import com.demo.documentstorage.service.MyFileServiceImpl;

@RestController
@RequestMapping("/storage")
public class MyFileController {
	
    @Autowired
    private MyFileServiceImpl myFileService;
    
    // Store file 
    @PostMapping("/documents")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        MyFile theFile = myFileService.uploadFile(file);
        return new ResponseEntity<>(theFile.getId(), HttpStatus.CREATED);
    }
    
    // Get file by id
    @GetMapping("/documents/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) {
        MyFile theFile = myFileService.downloadFile(fileId);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(theFile.getFileType()))
                .body(new ByteArrayResource(theFile.getData()));
    }
    
    // Get all files ... for test purpose 
    @GetMapping("/documents")
    public List<String> findAll() {
        return myFileService.findAll();
    }
    
    // Update file by id
    @PutMapping("/documents/{fileId}") 
    public ResponseEntity<String> updateFile(@PathVariable String fileId, @RequestParam("file") MultipartFile file) throws IOException{
    	myFileService.updateFile(fileId, file);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    // Delete file by id
    @DeleteMapping("/documents/{fileId}")
    public ResponseEntity<String> updateFile(@PathVariable String fileId) {
    	myFileService.deleteFile(fileId);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
