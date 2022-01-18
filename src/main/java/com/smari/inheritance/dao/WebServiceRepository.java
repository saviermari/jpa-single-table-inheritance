package com.smari.inheritance.dao;

import com.smari.inheritance.entity.WebService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebServiceRepository extends JpaRepository<WebService, Long> {
}