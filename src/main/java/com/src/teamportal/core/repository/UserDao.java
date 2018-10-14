package com.src.teamportal.core.repository;

import org.springframework.stereotype.Repository;
import com.src.teamportal.core.entity.User;

import java.util.Map;

@Repository("userDao")
public interface UserDao {
    public User findOne(String id);
    public void createUser(User u);
    public void updateUser(String id,Map t);
    public void deleteUser(String id);
    public boolean validate(String name);
}
