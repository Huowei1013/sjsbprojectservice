package com.bysj.event.znz.utils;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Hv
 * @E-MAIL: huowei@yuntongxun.com
 * @CreateDate: 2021/03/21 13:46
 * @Description:
 * @Version: 1.0
 */
@Slf4j
@Aspect
@Component
public class AccessLogAspect {

    @Pointcut("execution(public * com.hw.study.spingmybatisdemo.service..*.*(..))")
    public void accessLog() {
    }

    @Before("accessLog()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes == null) {
            return;
        }
        HttpServletRequest request = attributes.getRequest();
        log.info("【Start】【请求路径：{}】【请求参数：{}】",  request.getRequestURI(), joinPoint.getArgs());
    }

    @AfterReturning(returning = "result", pointcut = "accessLog()")
    public void doAfter(JoinPoint joinPoint,Object result)  {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes == null) {
            return;
        }
        HttpServletRequest request = attributes.getRequest();

            log.info("【End】【请求路径：{}】【响应结果：{}】",  request.getRequestURI(), BeanOrStrUtil.toJSon(result));
    }
}

