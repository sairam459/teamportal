package com.src.teamportal.core.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="projects")
public class Project {

    @Id
    private String id;

    public Project() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    private String project_name;


    public Project(String id, String project_name) {
        this.id = id;
        this.project_name = project_name;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id='" + id + '\'' +
                ", project_name='" + project_name + '\'' +
                '}';
    }
}
