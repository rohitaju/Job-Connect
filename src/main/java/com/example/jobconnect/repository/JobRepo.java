package com.example.jobconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.jobconnect.entity.Job;

public interface JobRepo extends JpaRepository<Job, Long> {
}
