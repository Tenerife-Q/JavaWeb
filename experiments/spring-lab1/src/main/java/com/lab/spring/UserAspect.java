package com.lab.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component // 注册为 Bean，或者在 XML 中显式配置 bean
public class UserAspect {

    // 定义切入点：匹配 com.lab.spring 包下 User 接口的所有实现类的所有方法
    // 文档要求切入点为 maleuser 和 femaleuser 的所有方法
    @Pointcut("execution(* com.lab.spring.*User.*(..))")
    public void allMethods() {}

    // 前置通知
    @Before("allMethods()")
    public void beforeAdvice() {
        System.out.println("[Before] 准备执行方法...");
    }

    // 最终通知 (无论是否异常都执行)
    @After("allMethods()")
    public void afterAdvice() {
        System.out.println("[After] 方法执行结束...");
    }

    // 环绕通知
    @Around("allMethods()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("[Around] 环绕通知 - 开始");
        Object result = joinPoint.proceed(); // 执行目标方法
        System.out.println("[Around] 环绕通知 - 结束");
        return result;
    }

    // 异常通知 (为了测试这个，你可能需要手动在 User 实现类里抛个异常)
    @AfterThrowing(pointcut = "allMethods()", throwing = "ex")
    public void afterThrowingAdvice(Exception ex) {
        System.out.println("[Exception] 捕获到异常: " + ex.getMessage());
    }
}