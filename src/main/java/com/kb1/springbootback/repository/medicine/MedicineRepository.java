package com.kb1.springbootback.repository.medicine;

import com.kb1.springbootback.model.medicine.Medicine;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {
	// Optional<Medicine> findByMedicinename(String username);

	public Boolean existsByName(String name);

	public Optional<Medicine> findByName(String name);

	public Medicine findAllByName(String name);

    public List<Medicine> findAll();
}