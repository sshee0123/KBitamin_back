package com.kb1.springbootback.repository.medicine;

import com.kb1.springbootback.model.medicine.Medicine;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {

	Medicine findOneByName(String name);

	Boolean existsByName(String name);

	Medicine findAllByName(String name);

    List<Medicine> findAll();
}