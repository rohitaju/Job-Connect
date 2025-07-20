package com.example.jobconnect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jobconnect.entity.Home;
import com.example.jobconnect.repository.HomeRepo;

@Service
public class HomeService {
	
	@Autowired
	private HomeRepo homeRepo;

	public List<Home> getAllHome() {
		return homeRepo.findAll();
	}
	
	public Home getHomeById(Long id) {
		return homeRepo.findById(id).orElseThrow(() -> new RuntimeException("Home with id " + id + " not found"));
	}
	
	public void createHome(Home user) {
		homeRepo.save(user);
	}
	
	public void updateHome(Home Home) {
		homeRepo.findById(Home.getId()).orElseThrow(() -> new RuntimeException("Home with id " + Home.getId() + " not found"));
		homeRepo.save(Home);
	}
	
	public void deleteHome(Long id) {
		homeRepo.findById(id).orElseThrow(() -> new RuntimeException("Home with id " + id + " not found"));
		homeRepo.deleteById(id);
	}
	
	public Home findHomeByEmail(String email) {
		return homeRepo.findByEmail(email);
	}
	
	public boolean verifyCredentials(String email, String password) {
		Home Home = homeRepo.findByEmail(email);
		if (Home.getPassword().equals(password)) {
			return true;
		}
		
		return false;
	}

}
