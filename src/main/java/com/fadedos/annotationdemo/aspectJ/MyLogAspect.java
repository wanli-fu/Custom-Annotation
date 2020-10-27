package com.fadedos.annotationdemo.aspectJ;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author pengcheng
 * @Description: ${todo}
 * @date 2020/10/24   17:31
 */
@Component
@Aspect //1.表明是一个切面
public class MyLogAspect {
    /**
     * 2.@Pointcut 表示是一个切点,@annotation表示这个切点切到一个注解上,后面带该注解的全类名
     * <p>
     * 切面最主要的就是切点,所有的故事都围绕切点发生
     */
    @Pointcut("@annotation(com.fadedos.annotationdemo.annotation.MyLog)")
    public void logPoint() {
    }

    //3. 环绕通知
    @Around("logPoint()")
    private void logAround(ProceedingJoinPoint joinPoint) {
        //获取方法名字
        String methodName = joinPoint.getSignature().getName();

        //获取入参
        Object[] args = joinPoint.getArgs();

        StringBuilder stringBuilder = new StringBuilder();

        for (Object arg : args) {
            stringBuilder.append(arg).append(",");
        }
        System.out.println("进入[" + methodName + "]方法,参数为:" + stringBuilder.toString());

        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("方法执行完毕");
    }
}
