package com.github.vendigo.learntest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class SwitchAspect {

    @Value("${switcher.enabled}")
    private boolean enabled;

    @Around("execution(public * (@Switchable *).*(..) )")
    public Object switchAllMethodsInClass(ProceedingJoinPoint joinPoint) throws Throwable {
        if (enabled) {
            return joinPoint.proceed();
        } else {
            log.info("All public methods in class are disabled");
            return null;
        }
    }

    @Around("@annotation(Switchable)")
    public Object switchMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        if (enabled) {
            return joinPoint.proceed();
        } else {
            log.info("Method is disabled");
            return null;
        }
    }
}
