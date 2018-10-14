package com.src.teamportal.application.controller.timesheet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.src.teamportal.application.model.WeekRecordRequest;
import com.src.teamportal.core.entity.TimeSheet;
import com.src.teamportal.core.repository.TimeSheetDao;
import com.src.teamportal.domain.TimeSheetComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.io.Resource;

import java.io.*;
import java.util.List;
import java.util.Map;

@RestController
public class TimeSheetController {

    @Autowired
    private TimeSheetDao timeSheetDao;

    @Autowired
    private TimeSheetComponent timeSheetComponent;

    @PostMapping(value="createTimeSheet")
    public Boolean CreateRecord(@RequestBody TimeSheet t){
        timeSheetDao.createRecord(t);
        return true;
    }

    @GetMapping(value="getTimeSheetRecord/{id}")
    public TimeSheet getRecord(@PathVariable("id") String s){
        return timeSheetDao.getRecord(s);

    }

    @PutMapping(value="updateTimeSheetRecord/{id}")
    public Boolean updateRecord(@PathVariable("id") String id, @RequestBody Map t) throws JsonProcessingException {

            timeSheetDao.updateRecord(id,t);

        return true;
    }

    @DeleteMapping(value="clearRecord/{eid}")
    public Boolean clearRecord(@PathVariable("eid") String eid,@RequestBody TimeSheet rid){
            timeSheetDao.clearRecord(eid,rid);
            return true;
    }

    @PostMapping(value="getWeeklyRecord/{eid}")
    public List<TimeSheet> getWeeklyRecord(@PathVariable("eid") String eid, @RequestBody WeekRecordRequest interval){
        return timeSheetComponent.getWeeklyRecord(eid,interval);

    }

    @GetMapping(value="getTimeSheet/{eid}")
    public ResponseEntity<byte[]> getTimeSheet(@PathVariable("eid") String eid) throws JsonProcessingException {
        //return timeSheetComponent.getTimeSheet(eid);
        String contentType = "application/octet-stream";
        String str= null;
        Resource resource =null;
        byte[] b = null;
        try {
            str = timeSheetComponent.getTimeSheet(eid);
         // resource = new ByteArrayResource(str.getBytes());
            b = str.getBytes();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + "timesheet.json" + "\"")
                .body(b);

    }

    @GetMapping(value="timesheetdownload/{eid}")
    public ResponseEntity<OutputStream> Example(@PathVariable("eid") String eid) throws JsonProcessingException {

        String contentType = "application/octet-stream";
        String str= null;
        OutputStream out=null;
        Resource resource =null;
        byte[] b = null;

        try {
            str = timeSheetComponent.getTimeSheet(eid);
           out=new ByteArrayOutputStream();
            out.write(str.getBytes());

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + "timesheet.json" + "\"")
                .body(out);

    }


}
