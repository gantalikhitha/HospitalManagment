package com.project.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.Entity.BillDetails;

@Repository
public interface BillDetailsRepository extends JpaRepository<BillDetails, Integer>{

}
