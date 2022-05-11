package com.kb1.springbootback.repository.medicine;

import java.util.List;

import com.kb1.springbootback.model.medicine.Caution;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CautionRepository extends JpaRepository<Caution, Long>  {
	public List<Caution> findAllByName(String name);
    
}
