package com.kb1.springbootback.service;

import java.util.Date;
import java.util.List;

import com.kb1.springbootback.model.calendar.*;
import com.kb1.springbootback.repository.calendar.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalendarService{

    @Autowired
    private CalendarRepository calendarRepository;

    // userid로 calendar LIST 가져오기
    public List<Calendar> getByUserid(String userid){
        List<Calendar> list = calendarRepository.getByUserid(userid);
        return list;
    }
    // userid로 복용 calendar LIST 가져오기
    public Object getTakingPerUser(String userid){
        List<Object> list = calendarRepository.getTakingByUserid(userid);
        return list;
    }

    // 사용자 복용 정보 update
    public void updateTaking(String id, String title, Date start, String sideEffectName) {
        calendarRepository.updateTakingByUserid(id, title, start,sideEffectName);
    }

    // 사용자 복용 정보 delete
    public void deleteTaking(String id, String title, Date start) {
        Calendar delTaking = calendarRepository.getOneTakingByUserid(id, title, start);
        calendarRepository.delete(delTaking);
    }
}