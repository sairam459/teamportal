package com.src.teamportal.services.component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.src.teamportal.application.model.WeekRecordRequest;
import com.src.teamportal.core.entity.TimeSheet;
import com.src.teamportal.core.repository.TimeSheetDao;
import com.src.teamportal.domain.TimeSheetComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class TimeSheetComponentImpl implements TimeSheetComponent {

    @Autowired
    private TimeSheetDao timeSheetDao;

    @Autowired
    private Example example;

    public List<TimeSheet> getWeeklyRecord(String eid, WeekRecordRequest interval){
       return  timeSheetDao.fetchWeekRecord(eid,interval);
    }

    @Override
    public String getTimeSheet(String eid) throws JsonProcessingException {
        List<TimeSheet> list =timeSheetDao.getAllRecords(eid);
        try {
            String json =new ObjectMapper().writeValueAsString(list);
            return json;

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
