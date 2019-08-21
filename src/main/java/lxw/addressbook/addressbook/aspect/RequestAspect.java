package lxw.addressbook.addressbook.aspect;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class RequestAspect {

    @Pointcut("execution(public * lxw.addressbook.addressbook.controller.*.*(*))")
    public void request(){}

    @Before("request()")
    public void doBefore(JoinPoint joinPoint){
        log.info("接口地址："+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        log.info("入参："+JSONObject.toJSONString(joinPoint.getArgs()));
    }

    @AfterReturning(pointcut = "request()",returning = "response")
    public void afterReturn(Object response){
        log.info("返回参数："+JSONObject.toJSONString(response));
    }

    @After("request()")
    public void doAfter(){
        log.info("方法调用结束");
    }
}
