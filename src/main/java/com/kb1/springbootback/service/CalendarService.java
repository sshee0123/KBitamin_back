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

    // calendar LIST 다 가져오기
    public List<Calendar> getByUserid(String userid){
        System.out.println("Calendar LIST 다 가져오기");
        List<Calendar> list = calendarRepository.getByUserid(userid);
        
        return list;
    }

    public Object getTakingPerUser(String userid){
        List<Object> list = calendarRepository.getTakingByUserid(userid);
        return list;
    }

    public void deleteTaking(String id, String title, Date start) {

        System.out.println("\n\n\n\n\n"+id+title+start);
        Calendar delTaking = calendarRepository.getOneTakingByUserid(id, title, start);
        System.out.println("Service : deleteTaking  "+delTaking);
        calendarRepository.delete(delTaking);
    }
}