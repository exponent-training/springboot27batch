package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.SubCategory;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer>{

}
