package com.kb1.springbootback.payload.request;

import lombok.*;
import java.util.Date;

@Getter
@Setter
public class CalendarRequest {

    // Calendar 등록 할 때 필요한 정보들
    private String userid;

    private String title;

    private String SideEffectName;

    private Date start;

    private Date end;

    private String color;

    private String allDay;
}