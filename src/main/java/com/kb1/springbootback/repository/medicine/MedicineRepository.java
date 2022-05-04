package com.kb1.springbootback.repository.medicine;

import com.kb1.springbootback.model.medicine.Medicine;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

import com.kb1.springbootback.model.medicine.Medicine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {
	// Optional<Medicine> findByMedicinename(String username);

	Boolean existsByName(String name);

	Optional<Medicine> findByName(String name);

	Medicine findAllByName(String name);

    List<Medicine> findAll();
}