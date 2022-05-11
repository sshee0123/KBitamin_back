package com.kb1.springbootback.repository.medicine;

import com.kb1.springbootback.model.medicine.Medicine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {

	// @Query(value="SELECT * FROM medicine a INNER JOIN kb_db.usage b ON a.name = b.name WHERE a.name=?1", nativeQuery=true)
	// public Medicine getOneByName(String name);

	public Medicine findOneByName(String name);

	public Boolean existsByName(String name);

	public List<Medicine> findAllByName(String name);

    public List<Medicine> findAll();
}