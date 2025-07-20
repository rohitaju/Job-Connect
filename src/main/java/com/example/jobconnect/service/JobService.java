package com.example.jobconnect.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jobconnect.entity.Job;
import com.example.jobconnect.repository.JobRepo;

@Service
public class JobService {

	@Autowired
	private JobRepo jobRepo;

	public List<Job> getAllJob() {
		return jobRepo.findAll();
	}

	public Job getJobById(Long id) {
		return jobRepo.findById(id).orElseThrow(() -> new RuntimeException("Job with id " + id + " not found"));
	}

	public void createJob(Job Job) {
		jobRepo.save(Job);
	}

	public void updateJob(Job Job) {
		jobRepo.findById(Job.getId()).orElseThrow(() -> new RuntimeException("Job with id " + Job.getId() + " not found"));
		jobRepo.save(Job);
	}

	public void deleteJob(Long id) {
		jobRepo.findById(id).orElseThrow(() -> new RuntimeException("Job with id " + id + " not found"));
		jobRepo.deleteById(id);
	}



}