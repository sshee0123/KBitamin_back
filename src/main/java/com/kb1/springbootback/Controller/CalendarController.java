package com.kb1.springbootback.controller;

import com.kb1.springbootback.model.calendar.Calendar;
import com.kb1.springbootback.service.CalendarService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class CalendarController{

    @Autowired
    private CalendarService calendarService;
    
    @GetMapping("/calendar/calendarInfo")
    public ResponseEntity<List<Calendar>> getAllCalendars(){
        System.out.println("\n\n\n\n\n\n\n mapping calendarInfo?????? ");
        return ResponseEntity.ok(calendarService.findAll());
    }

    // crud 
}
