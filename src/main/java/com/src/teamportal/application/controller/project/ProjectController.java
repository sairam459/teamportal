package com.src.teamportal.application.controller.project;


import com.src.teamportal.core.entity.Project;
import com.src.teamportal.core.repository.ProjectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProjectController {

    @Autowired
    private ProjectDao projectDao;

    @GetMapping(value="getProject/{project_id}")
    public Project getOneProject(@PathVariable("project_id") String project_id){
        Project p=projectDao.getProject(project_id);
        System.out.println(p.toString());
        return p;
    }

    @PostMapping(value="createProject")
    public Boolean createProject(@RequestBody Project p){

        projectDao.createProject(p);
        return true;
    }
}
