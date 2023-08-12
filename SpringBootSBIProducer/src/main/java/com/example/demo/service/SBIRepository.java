package com.example.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.SBIDetails;

@Repository
public interface SBIRepository extends JpaRepository<SBIDetails, Integer>{

	SBIDetails findByAtmCardNumber(String atmCardNumber);
}
