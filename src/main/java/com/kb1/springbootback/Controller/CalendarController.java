package com.kb1.springbootback.controller;

import com.kb1.springbootback.exception.ResourceNotFoundException;
import com.kb1.springbootback.model.calendar.Calendar;
import com.kb1.springbootback.model.user.User;
import com.kb1.springbootback.payload.request.CalendarRequest;
import com.kb1.springbootback.payload.response.MessageResponse;
import com.kb1.springbootback.repository.calendar.CalendarRepository;
import com.kb1.springbootback.service.CalendarService;
import com.kb1.springbootback.service.UserService;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class CalendarController{

    @Autowired
    private CalendarService calendarService;

    @Autowired
	CalendarRepository calendarRepository;
    
    @GetMapping("/calendar/calendarInfo")
    public ResponseEntity<List<Calendar>> getByUserid(@RequestParam(value="id") String userid){
        return ResponseEntity.ok(calendarService.getByUserid(userid));
    }

    
    @PostMapping("/calendar/calendarInsert")
	public ResponseEntity<?> registerCalendar(@RequestParam(value="id")  String userid, @Validated @RequestBody CalendarRequest calendarRequest) {

        System.out.println("\n\n\n "+"userid: "+ userid+" " +calendarRequest.getTitle()+" \n\n\n");

        Calendar calendar = new Calendar();
		calendar.setUserid(userid);
		calendar.setTitle(calendarRequest.getTitle());
		calendar.setStart(calendarRequest.getStart());
		calendar.setEnd(calendarRequest.getEnd());
		calendar.setColor(calendarRequest.getColor());
		calendar.setSideEffect_name("");
		calendar.setAllDay("");
        System.out.println("\n\n\n\n\n /calendar/calendarInsert \n\n\n\n\n");

		calendarRepository.save(calendar);

		return ResponseEntity.ok(new MessageResponse("Calender registered successfully!"));
	}

    // crud 
}
