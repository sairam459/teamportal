package com.src.teamportal.application.model;

import java.util.Date;

public class WeekRecordRequest {

    private Date from_date;

    public WeekRecordRequest() {
    }

    public WeekRecordRequest(Date from_date, Date to_date) {
        this.from_date = from_date;
        this.to_date = to_date;
    }

    public Date getFrom_date() {
        return from_date;
    }

    public void setFrom_date(Date from_date) {
        this.from_date = from_date;
    }

    public Date getTo_date() {
        return to_date;
    }

    public void setTo_date(Date to_date) {
        this.to_date = to_date;
    }

    private Date to_date;
}
