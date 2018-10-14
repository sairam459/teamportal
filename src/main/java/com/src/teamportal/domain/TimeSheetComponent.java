package com.src.teamportal.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.src.teamportal.application.model.WeekRecordRequest;
import com.src.teamportal.core.entity.TimeSheet;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

@Component
public interface TimeSheetComponent {
    List<TimeSheet> getWeeklyRecord(String eid, WeekRecordRequest interval);

    String getTimeSheet(String eid) throws JsonProcessingException;
}
