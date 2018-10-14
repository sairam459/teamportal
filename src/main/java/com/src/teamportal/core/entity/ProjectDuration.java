package com.src.teamportal.core.entity;

public class ProjectDuration {
    private String project_id;


    public ProjectDuration() {
    }

    public ProjectDuration(String project_id, int hours_worked) {
        this.project_id = project_id;
        this.hours_worked = hours_worked;

    }

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public int getHours_worked() {
        return hours_worked;
    }

    public void setHours_worked(int hours_worked) {
        this.hours_worked = hours_worked;
    }

    private int hours_worked;


}
