package com.Project.Inventory.and.Sales.Management.System.Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.JoinPoint;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

@Aspect
@Component
public class LoggingAspect {

    private static final String LOG_FILE = "app.log";

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void controllerMethods() {}

    @Pointcut("within(@org.springframework.stereotype.Service *)")
    public void serviceMethods() {}

    @Pointcut("within(@org.springframework.stereotype.Repository *)")
    public void repositoryMethods() {}

    // Logs access before execution (optional with execution time)
    @Before("controllerMethods() || serviceMethods() || repositoryMethods()")
    public void logAccess(JoinPoint joinPoint) {
        String username = getCurrentUsername();
        String methodName = joinPoint.getSignature().toShortString();
        String timestamp = LocalDateTime.now().toString();

        String logEntry = String.format("User: %s | Method: %s | Accessed At: %s%n",
                username, methodName, timestamp);
        writeLog(logEntry);
    }

    // Logs execution time for methods
    @Around("controllerMethods() || serviceMethods() || repositoryMethods()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long duration = System.currentTimeMillis() - start;
        String username = getCurrentUsername();
        String methodName = joinPoint.getSignature().toShortString();
        String logEntry = String.format("User: %s | Method: %s | Execution Time: %d ms%n",
                username, methodName, duration);

        writeLog(logEntry);

        return result;
    }

    private String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return (auth != null && auth.isAuthenticated()) ? auth.getName() : "Anonymous";
    }

    private void writeLog(String logEntry) {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            writer.write(logEntry);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
