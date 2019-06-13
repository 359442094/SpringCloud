package cn.springcloud.start.aop;

import cn.springcloud.model.anntation.ShowLogger;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.reflect.Method;

@Slf4j
@Component
@Aspect
public class AnntationAop {

    @Pointcut(value = "@annotation(cn.springcloud.model.anntation.ShowLogger)")
    public void pointcut(){}

    @Before(value = "pointcut()")
    public void before(JoinPoint joinPoint){
        log.info("------------------------ cn.springcloud.cn.springcloud.start ------------------------");
        showAnnotationInfo(joinPoint);
        showRequestURL();
        showRequestParams(joinPoint);
    }

    public void showAnnotationInfo(JoinPoint joinPoint){
        MethodSignature signature= (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        if (method.isAnnotationPresent(ShowLogger.class)) {
            ShowLogger annotation = method.getAnnotation(ShowLogger.class);
            log.info("info:"+annotation.info());
        }
    }

    public void showRequestURL(){
        ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        String url = attributes.getRequest().getRequestURI();
        log.info("url:"+url);
    }

    public void showRequestParams(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            log.info("request:"+arg.toString());
        }
        if(args.length==0){
            log.info("request:null");
        }
    }

    @AfterReturning(value = "pointcut()",returning = "result")
    public void afterReturn(Object result){
        log.info("response:"+result.toString());
        log.info("------------------------ end ------------------------");
    }

}
