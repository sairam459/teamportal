package com.src.teamportal.services.dao;

import com.src.teamportal.core.entity.Project;
import com.src.teamportal.core.repository.ProjectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Component
public class ProjectDaoImpl implements ProjectDao {

    @Autowired
    private MongoOperations mongoOperations;

    public Project getProject(String id){
        return mongoOperations.findOne(query(where("_id").is(id)),Project.class);
    }

    public void createProject(Project p){
        mongoOperations.save(p);
    }


}
