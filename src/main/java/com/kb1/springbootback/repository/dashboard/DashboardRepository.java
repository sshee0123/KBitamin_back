package com.kb1.springbootback.repository.dashboard;

import com.kb1.springbootback.model.medicine.Medicine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface DashboardRepository extends JpaRepository<Medicine, Long> {

	@Query(value="select * from medicine", nativeQuery=true)
    public List<Medicine> getRecommendMedi();
}