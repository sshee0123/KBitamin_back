package com.kb1.springbootback.repository.calendar;

import com.kb1.springbootback.model.calendar.*;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

import com.kb1.springbootback.model.calendar.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Long> {

    public List<Calendar> findAll();
}