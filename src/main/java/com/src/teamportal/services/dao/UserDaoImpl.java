package com.src.teamportal.services.dao;

import com.src.teamportal.core.entity.User;
import com.src.teamportal.core.repository.UserDao;
import com.src.teamportal.exception.model.DataNotFoundException;
import com.src.teamportal.utils.GeneralUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import com.src.teamportal.validators.UniqueName;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Component
public class UserDaoImpl implements UserDao{
    @Autowired
    private MongoOperations mongoOperations;

    @Autowired
    private GeneralUtils generalUtils;


    public User findOne(String id){
        User u= mongoOperations.findOne(query(where("_id").is(id)),User.class);
        if(u==null){
            throw new DataNotFoundException("no users with that id");
        }
        return mongoOperations.findOne(query(where("_id").is(id)),User.class);
    }

    public void createUser( User u){
        mongoOperations.save(u);
    }

    public void updateUser(String id, Map t){
        User h=mongoOperations.findById(id,User.class);

        try {
            User ti=(User) generalUtils.commonUpdate(t,h);

            mongoOperations.save(ti);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(String id){
        mongoOperations.remove(query(where("_id").is(id)));
    }

    public boolean validate(String str) {
        User u= mongoOperations.findOne(query(where("name").is(str)),User.class);
        if(u==null){
            return true;
        }
        return false;
    }
}
