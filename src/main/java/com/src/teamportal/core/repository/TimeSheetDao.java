package com.src.teamportal.core.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.src.teamportal.application.model.WeekRecordRequest;
import com.src.teamportal.core.entity.TimeSheet;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.List;
import java.util.Map;

@Repository
public interface TimeSheetDao {
    public void createRecord(TimeSheet t);

    public TimeSheet getRecord(String id);

    public void updateRecord(String id,Map t) throws JsonProcessingException;

    public void clearRecord(String id,TimeSheet t);

    //@Query("{$and:[ {'emp_id':?0},{'work_date':{$gte:?1,$lte:?2}} ] }")
    public List<TimeSheet> fetchWeekRecord(String eid, WeekRecordRequest interval);

    public List<TimeSheet> getAllRecords(String eid);



}
