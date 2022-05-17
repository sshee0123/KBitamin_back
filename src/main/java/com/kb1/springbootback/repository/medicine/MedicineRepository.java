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

	// @Query(value = "select * from kb_db.medicine where shape like '%?1%' and color like '%?2%' and formulation like '%?3%' and divide_line like '%?4%'", nativeQuery=true)
	@Query(value = "select * from kb_db.medicine where shape =?1 and color=?2 and formulation = ?3 and divide_line = ?4", nativeQuery=true)
	public List<Medicine> findFromTo(String shapeId, String colorId, String formulationId, String dividelineId);

	public Medicine findOneByName(String name);

	public Boolean existsByName(String name);

	public List<Medicine> findAllByName(String name);

    public List<Medicine> findAll();

	
}