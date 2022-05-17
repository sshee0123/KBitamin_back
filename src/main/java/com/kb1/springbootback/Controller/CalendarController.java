package com.kb1.springbootback.controller;

import com.kb1.springbootback.model.calendar.Calendar;
import com.kb1.springbootback.payload.request.CalendarRequest;
import com.kb1.springbootback.payload.response.MessageResponse;
import com.kb1.springbootback.repository.calendar.CalendarRepository;
import com.kb1.springbootback.service.CalendarService;

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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
        System.out.println("\n\n\ncalendarInfo\n\n\n");
        return ResponseEntity.ok(calendarService.getByUserid(userid));
    }
    
    @PostMapping("/calendar/calendarInsert")
	public ResponseEntity<?> registerCalendar(@RequestParam(value="id")  String userid, @Validated @RequestBody CalendarRequest calendarRequest) {

        System.out.println("\n\n\n "+"userid: "+ userid+" " +calendarRequest.getTitle()+" \n\n\n");

        Calendar calendar = new Calendar();
		calendar.setUserid(userid);
		calendar.setTitle(calendarRequest.getTitle());
        Date date = calendarRequest.getStart();
        date.setDate(date.getDate()+1);
		calendar.setStart(date);
        Date endDate = calendarRequest.getEnd();
        endDate.setDate(endDate.getDate()+1);
		calendar.setEnd(endDate);
		calendar.setColor(calendarRequest.getColor());
		// calendar.setSideEffect_name("");
        System.out.println("\n\n\n\n\n /calendar/calendarInsert \n\n\n\n\n");

		calendarRepository.save(calendar);

		return ResponseEntity.ok(new MessageResponse("Calender registered successfully!"));
	}

    @GetMapping("/taking/takingUser")
    public ResponseEntity<Object> getTakingPerUser(@RequestParam(value="id") String userid){
        System.out.println("\n\ntakingUser\n\n\n");
        return ResponseEntity.ok(calendarService.getTakingPerUser(userid));
    }

    // crud 
    // 복용 약 수정
    @PostMapping("/taking/updateTaking")
	public ResponseEntity<?> updateTaking(@RequestParam(value="id")  String userid, @Validated @RequestBody CalendarRequest calendarRequest) {

        System.out.println(calendarRequest.toString());
        System.out.println("\n\n\n "+"userid: "+ userid+" " +calendarRequest.getTitle()+" " +calendarRequest.getStart()+" " +calendarRequest.getSideEffectName()+" \n\n\n");
        calendarService.updateTaking(userid, calendarRequest.getTitle(), calendarRequest.getStart(), calendarRequest.getSideEffectName());

		return ResponseEntity.ok(new MessageResponse("taking updated successfully!"));
	}

    // 복용 약 삭제
    @PostMapping("/taking/deleteTaking")
	public ResponseEntity<?> deleteTaking(@RequestParam(value="id")  String userid, @Validated @RequestBody CalendarRequest calendarRequest) {

        System.out.println("\n\n\n "+"userid: "+ userid+" " +calendarRequest.getTitle()+" " +calendarRequest.getStart()+" \n\n\n");
        calendarService.deleteTaking(userid, calendarRequest.getTitle(), calendarRequest.getStart());

		return ResponseEntity.ok(new MessageResponse("taking deleted successfully!"));
	}
}
