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
    
    // userid로 복용 약 캘린더 정보 가져오기
    @GetMapping("/calendar/calendarInfo")
    public ResponseEntity<List<Calendar>> getByUserid(
        @RequestParam(value="id") String userid){
        return ResponseEntity.ok(calendarService.getByUserid(userid));
    }
    
    // 사용자 캘린더에 약 정보 추가
    @PostMapping("/calendar/calendarInsert")
	public ResponseEntity<?> registerCalendar(
        @RequestParam(value="id")  String userid, @Validated @RequestBody CalendarRequest calendarRequest) {

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
		calendarRepository.save(calendar);

		return ResponseEntity.ok(new MessageResponse("Calender registered successfully!"));
	}

    // 사용자 복용 약 가져오기
    @GetMapping("/taking/takingUser")
    public ResponseEntity<Object> getTakingPerUser(@RequestParam(value="id") String userid){
        
        return ResponseEntity.ok(calendarService.getTakingPerUser(userid));
    }

    // 복용 약 update
    @PostMapping("/taking/updateTaking")
	public ResponseEntity<?> updateTaking(@RequestParam(value="id")  String userid, @Validated @RequestBody CalendarRequest calendarRequest) {

        calendarService.updateTaking(userid, calendarRequest.getTitle(), calendarRequest.getStart(), calendarRequest.getSideEffectName());

		return ResponseEntity.ok(new MessageResponse("taking updated successfully!"));
	}

    // 복용 약 삭제
    @PostMapping("/taking/deleteTaking")
	public ResponseEntity<?> deleteTaking(@RequestParam(value="id")  String userid, @Validated @RequestBody CalendarRequest calendarRequest) {

        calendarService.deleteTaking(userid, calendarRequest.getTitle(), calendarRequest.getStart());

		return ResponseEntity.ok(new MessageResponse("taking deleted successfully!"));
	}
}
