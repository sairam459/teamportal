package com.src.teamportal.application.controller.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.src.teamportal.core.entity.User;
import com.src.teamportal.core.repository.UserDao;
import com.src.teamportal.validators.UniqueName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping(value = "getEmployee/{user_id}")
    public ResponseEntity<User> getUser(@PathVariable("user_id") String user_id){
        User u= userDao.findOne(user_id);
        return ResponseEntity.ok().body(u);
       // return new ResponseEntity<User>(HttpStatus.OK);
    }

    @PostMapping(value="createEmployee")
    public Boolean createUser(@Valid @RequestBody User u){
        userDao.createUser(u);
        return true;
    }

    @PutMapping(value="updateEmployee/{id}")
    public Boolean updateRecord(@PathVariable("id") String id, @RequestBody Map t) throws JsonProcessingException {

        userDao.updateUser(id,t);

        return true;
    }

    @DeleteMapping(value = "{id}/deleteEmployee")
    public Boolean deleteEmployee(@PathVariable("id") String id){
        userDao.deleteUser(id);
        return true;
    }

}
