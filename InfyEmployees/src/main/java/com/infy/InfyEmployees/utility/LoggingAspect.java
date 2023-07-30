package com.infy.InfyEmployees.utility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
  public static final Log LOGGER =LogFactory.getLog(LoggingAspect.class);
  
  @AfterThrowing(pointcut="execution(* com.infy.InfyEmployees.service.EmployeeServiceImpl.*(..))",throwing="e")  	
    public void logServiceException(Exception e) {
	  LOGGER.error(e.getMessage(),e);
  }
}
