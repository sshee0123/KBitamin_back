package com.kb1.springbootback.repository.medicine;

import java.util.List;

import com.kb1.springbootback.model.medicine.Usage;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsageRepository extends JpaRepository<Usage, Long>{
	public List<Usage> findAllByName(String name);
    
}
