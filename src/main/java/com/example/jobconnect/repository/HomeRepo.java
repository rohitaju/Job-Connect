package com.example.jobconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jobconnect.entity.Home;

public interface HomeRepo extends JpaRepository<Home, Long>{
	
	public Home findByEmail(String email);

}
