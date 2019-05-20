package com.demo.documentstorage.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.documentstorage.entity.MyFile;

public interface MyFileRepository extends JpaRepository<MyFile, String> {

}
