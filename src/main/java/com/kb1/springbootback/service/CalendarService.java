package com.kb1.springbootback.service;

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
    public List<Calendar> findAll(){
        List<Calendar> list = calendarRepository.findAll();
        System.out.println("Calendar LIST 다 가져오기");
        
        return list;
    }

}
