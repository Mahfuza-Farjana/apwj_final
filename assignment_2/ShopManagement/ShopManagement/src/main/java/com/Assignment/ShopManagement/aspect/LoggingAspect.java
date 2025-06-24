package com.Assignment.ShopManagement.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Aspect
@Component
public class LoggingAspect {

    private static final String LOG_FILE = "app.log";

    @Pointcut("execution(* com.Assignment.ShopManagement.api..*(..)) || " +
            "execution(* com.Assignment.ShopManagement.service..*(..)) || " +
            "execution(* com.Assignment.ShopManagement.repository..*(..))")
    public void applicationPackagePointcut() {}

    @After("applicationPackagePointcut()")
    public void logAfter(JoinPoint joinPoint) {
        String username = "Anonymous";
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated()) {
            username = auth.getName();
        }

        String methodName = joinPoint.getSignature().toShortString();
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        String logEntry = String.format("[%s] USER: %s - METHOD: %s%n", timestamp, username, methodName);

        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            writer.write(logEntry);
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }
}
