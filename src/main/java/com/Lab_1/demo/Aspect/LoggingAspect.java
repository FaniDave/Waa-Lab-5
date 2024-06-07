package com.Lab_1.demo.Aspect;

import com.Lab_1.demo.Entity.Logger;
import com.Lab_1.demo.Repo.LoggerRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
@AllArgsConstructor
@Slf4j
public class LoggingAspect {

    private final LoggerRepo loggerRepo;

    private static final String PRINCIPLE = "fakeUser";  // Fake user for now

    @Before("execution(* com.Lab_1.demo.Service.*.*(..))")
    public void logBefore(ProceedingJoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getMethod().getName();

        Logger logEntry = new Logger();
        logEntry.setTimestamp(LocalDateTime.now());
        logEntry.setPrinciple(PRINCIPLE);
        logEntry.setOperation("Executing method: " + methodName);

        loggerRepo.save(logEntry);
    }

    @Around("@annotation(com.Lab_1.demo.Aspect.ExecutionTime)")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;
        log.info(joinPoint.getSignature() + " executed in " + executionTime + "ms");

        Logger logEntry = new Logger();
        logEntry.setTimestamp(LocalDateTime.now());
        logEntry.setPrinciple(PRINCIPLE);
        logEntry.setOperation(joinPoint.getSignature() + " executed in " + executionTime + "ms");

        loggerRepo.save(logEntry);

        return proceed;
    }
}
