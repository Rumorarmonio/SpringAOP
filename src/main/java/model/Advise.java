package model;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

@Component
@Aspect
@EnableAspectJAutoProxy
public class Advise {

    @Before("execution(* *(..))")/*("execution(* model.*.*(..))")*/
    public void beforeMethodInvocation(JoinPoint joinPoint) {
        System.out.println("Invocation of method " + joinPoint.getSignature()/*.getName()*/);
    }

    @Around("execution(* fillTheTable(..))")
    public Object aroundMethodExecution(ProceedingJoinPoint joinPoint) {
        StopWatch watch = new StopWatch();
        watch.start();
        Object[] arr = joinPoint.getArgs();
        String pathname = arr[0].toString();
        System.out.println("pathname: " + pathname);
        File f = new File(pathname);
        if (f.exists()) {
            Object buses = null;
            try {
                buses = joinPoint.proceed();
                System.out.println("Method completed without errors.");
            } /*catch (FileNotFoundException e) {
                System.out.println("The file named " + pathname + " does not exist!");
                e.printStackTrace();
                System.exit(0);
            }*/ finally {
                watch.stop();
                System.out.println("Execution of method " + joinPoint.getSignature() + " took " + watch.getTotalTimeMillis() + " milliseconds.");
                return buses;
            }
        } else {
            System.out.println("The file named " + pathname + " does not exist!");
            System.exit(0);
        }
        watch.stop();
        System.out.println("Compilation took " + watch.getTotalTimeMillis() + "milliseconds.");
        return new ArrayList<Bus>();
    }

    @AfterReturning(pointcut = "execution(* sort*(..))", returning = "returnValue")
    public void afterReturning(Object returnValue) {
        System.out.println("The number of buses is " + returnValue);
    }
}