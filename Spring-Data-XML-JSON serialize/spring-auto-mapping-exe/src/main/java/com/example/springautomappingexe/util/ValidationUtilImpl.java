package com.example.springautomappingexe.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

@Component
public class ValidationUtilImpl implements ValidationUtil{

      private final Validator validator;

    public ValidationUtilImpl() {
        this.validator = Validation
                .buildDefaultValidatorFactory()
                .getValidator();
    }




    @Override
    public <E> Set<ConstraintViolation<E>> violations(E entity) {
        return validator.validate(entity);
    }
}
