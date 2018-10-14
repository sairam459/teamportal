package com.src.teamportal.validators;

import com.src.teamportal.core.entity.User;
import com.src.teamportal.core.repository.UserDao;
import com.src.teamportal.exception.model.TPValidationException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueNameValidator implements ConstraintValidator<UniqueName,Object> {

    @Autowired
    private UserDao userDao;

    @Override
    public void initialize(UniqueName constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        System.out.println("triggered");
        if(value!= null){
            boolean t=userDao.validate((String)value);

            if(t){
                return true;
            } else{
                throw new TPValidationException("Name already Exists");

            }

        }
        return true;
    }
}
