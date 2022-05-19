package com.kb1.springbootback.repository.calendar;

import com.kb1.springbootback.model.calendar.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Long> {
    
    public List<Calendar> getByUserid(String userid);

    @Query(value="SELECT t.title, t.start, t.end, t.sideEffect_name from taking t left join side_effect s on (s.name=t.title) where t.user_id=?1", nativeQuery=true)
    public List<Object> getTakingByUserid(final String userid);

    @Query(value="SELECT * FROM taking WHERE user_id =?1 and title =?2", nativeQuery=true)
    public Calendar getOneTakingByUserid(final String userid, final String title, final Date start);

    @Modifying
    @Transactional
    @Query(value="UPDATE taking SET sideEffect_name=?4 WHERE user_id =?1 and title =?2 and start=?3", nativeQuery=true)
    public void updateTakingByUserid(final String userid, final String title, final Date start, final String sideEffectName);
}