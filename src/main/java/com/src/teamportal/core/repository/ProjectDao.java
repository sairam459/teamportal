package com.src.teamportal.core.repository;

import com.src.teamportal.core.entity.Project;
import org.springframework.stereotype.Repository;

@Repository("projectDao")
public interface ProjectDao {
    public Project getProject(String id);

    public void createProject(Project p);

}
