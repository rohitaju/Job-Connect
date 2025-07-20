package com.example.jobconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.jobconnect.entity.User;



public interface UserRepo extends JpaRepository<User, Long>{
	public User findByEmail(String email);
}
