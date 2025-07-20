package com.example.jobconnect.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jobconnect.entity.Admin;


@Repository
public interface AdminRepo extends JpaRepository<Admin , Long> {
	
	public Admin findByEmail(String email);
	

}
