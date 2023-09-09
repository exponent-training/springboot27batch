package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Incident;

@Repository
public interface IncidentRepository extends JpaRepository<Incident, Integer>{

	List<Incident> findByStatus(String status);
}
