package com.zisheng.AOP;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 该类是一个切面类，且将该类交给ioc容器进行管理，成为ioc容器的bean对象
 */
@Component//把该切面类交给ioc容器进行管理，成为bean对象，确保SpringAop能够自动扫描和注册切面类
@Aspect// 表达式该类是一个切面类
public class TestAop {
    @Resource
    private HttpServletRequest httpServletRequest;
    @Resource
    private HttpServletResponse httpServletResponse;
    private static Long startTime;
    private static final Logger log = LoggerFactory.getLogger(TestAop.class);
    //设置切入点表达式
    @Pointcut("execution(public * com.zisheng.Controller..*Controller.*(..))")
    public void inteCon(){}
    //设置通知，引入切入点表达式
    @Before("inteCon()")
    public void interceptController()
    {
        String url = httpServletRequest.getRequestURL().toString();
        String uri = httpServletRequest.getRequestURI();
        String method = httpServletRequest.getMethod();
        log.info(method + ":" + url);
        log.info("URI为：{}",uri);
        startTime = System.currentTimeMillis();
    }
    @After("inteCon()")
    public void computeTime()
    {
        Long endTime = System.currentTimeMillis();
        log.info("方法执行了：{}秒",(endTime - startTime) / 1000.0);

    }
/*
    *//**
     * 通过Point注解提取切入点表达式，同时定义一个方法，以便于可以通过方法调用的方式引用该切入点表达式
     *//*
    //execution切入点表达式，根据方法签名进行匹配
    @Pointcut("execution(* com.zisheng.Controller.*.*(..))")
    public void exp(){}

    *//**
     * 环绕方法，刚方法的部分逻辑在目标方法执行之前执行，部分逻辑在目标方法执行后执行
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     *//*
//    @Around("exp()") // 通过方法调用的方式引入切入点表达式，实际上还是execution切入点表达式
    // Annotation切入点表达式，通过注解进行匹配
    @Around("@annotation(com.zisheng.Annotation.AOPAnnotation)")

    public Object recordTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("Around方法执行了！！！");
        //通过ProceedJoinPoint类型对象可以获取目标方法相关的信息
        String className = proceedingJoinPoint.getTarget().getClass().getName();
        String methodName = proceedingJoinPoint.getSignature().getName();
        Object[] args = proceedingJoinPoint.getArgs();
        log.info("目标类名：{}",className);
        log.info("目标方法名：{}",methodName);
        //Arrays的toString方法将数组转换成String字符串
        log.info("方法的参数为：{}", Arrays.toString(args));
        Signature signature = proceedingJoinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        var returnType = methodSignature.getReturnType();
        log.info("方法的返回值类型为：{}",returnType.toString());
        Long startTime = System.currentTimeMillis();
        //放行，去执行目标方法，获取返回结果，返回结果必须为Object类型
        Object result = proceedingJoinPoint.proceed();
        Long endTime = System.currentTimeMillis();
        *//**
         * 以下代码用于实现将java对象序列化JSON格式的字符串时，排除一些不需要的字段
         *//*
        PropertyPreFilters propertyPreFilters = new PropertyPreFilters();
        PropertyPreFilters.MySimplePropertyPreFilter mySimplePropertyPreFilter = propertyPreFilters.addFilter();
        String[] excludeProperties = {"id"};
        mySimplePropertyPreFilter.addExcludes(excludeProperties);
        // 将对象转换成JSON格式的字符串，同时过滤出不需要的属性
        String jsonString = JSONObject.toJSONString(result,mySimplePropertyPreFilter);
        log.info("返回的结果为：{}",jsonString);
        log.info(methodName + "方法执行了" + (endTime - startTime) / 1000.0 + "s");
        return result;
    }*/


}
