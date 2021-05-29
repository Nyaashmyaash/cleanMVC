package com.nyash.cleanmvc.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution(public String newEmployee(com.nyash.cleanmvc.models.Employee))")
    public void beforeNewEmployeeAdvice(){
        // логирование создания сотрудников
        System.out.println("New employee was added");
    }
}
