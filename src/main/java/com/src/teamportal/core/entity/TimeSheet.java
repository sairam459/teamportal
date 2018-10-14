package com.src.teamportal.core.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;


@Document(collection = "timesheet")
public class TimeSheet {


    @Id
    private String id;
    private String emp_id;
    private List<ProjectDuration> project_hours;
    private String timestamp;

    private Date work_date=new Date();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public Date getWork_date() {
        return work_date;
    }

    public void setWork_date(Date work_date) {
        this.work_date = work_date;
    }

    public List<ProjectDuration> getProject_hours() {
        return project_hours;
    }

    public void setProject_hours(List<ProjectDuration> project_hours) {
        this.project_hours = project_hours;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public TimeSheet(String id, String emp_id, Date work_date, List<ProjectDuration> project_hours, String timestamp) {
        this.id = id;
        this.emp_id = emp_id;
        this.work_date = work_date;
        this.project_hours = project_hours;
        this.timestamp = timestamp;
    }

    public TimeSheet() {
    }





}
