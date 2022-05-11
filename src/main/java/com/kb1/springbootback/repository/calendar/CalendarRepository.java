package com.kb1.springbootback.repository.calendar;

import com.kb1.springbootback.model.calendar.*;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Long> {
    
    public List<Calendar> getByUserid(String userid);
    // Optional<Calendar> findByUserid(String userid);

    @Query(value="select t.title, t.start, t.sideEffect_name from taking t left join side_effect s on (s.name=t.title) where t.user_id=?1", nativeQuery=true)
    public Object getTakingByUserid(final String userid);
}