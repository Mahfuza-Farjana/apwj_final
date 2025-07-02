package com.Project.LibraryManagement.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

@Aspect
@Component
public class LoggingAspect {

    private static final String LOG_FILE = "library-management.log";


    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void controllerMethods() {}


    @Pointcut("within(@org.springframework.stereotype.Service *)")
    public void serviceMethods() {}


    @Pointcut("within(@org.springframework.stereotype.Repository *)")
    public void repositoryMethods() {}


    @Before("controllerMethods() || serviceMethods() || repositoryMethods()")
    public void logAccess(JoinPoint joinPoint) {
        String username = getCurrentUsername();
        String methodName = joinPoint.getSignature().toShortString();
        String timestamp = LocalDateTime.now().toString();

        String logEntry = String.format("User: %s | Method: %s | Time: %s%n", username, methodName, timestamp);
        writeLog(logEntry);
    }


    private String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated() && !"anonymousUser".equals(auth.getName())) {
            return auth.getName();
        }
        return "Anonymous";
    }


    private void writeLog(String logEntry) {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            writer.write(logEntry);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
