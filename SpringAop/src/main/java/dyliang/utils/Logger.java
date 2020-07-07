package dyliang.utils;

import org.aspectj.lang.ProceedingJoinPoint;

public class Logger {
//    public void logging(){
//        System.out.println("logging...");
//    }

    public  void beforePrintLog(){
        System.out.println("beforePrintLog...");
    }

    public  void afterReturningPrintLog(){
        System.out.println("afterReturningPrintLog...");
    }

    public  void afterThrowingPrintLog(){
        System.out.println("afterReturningPrintLog...");
    }

    public  void afterPrintLog(){
        System.out.println("afterPrintLog...");
    }

    public Object aroundPringLog(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try{
            Object[] args = pjp.getArgs();//得到方法执行所需的参数
            System.out.println("before...");
            rtValue = pjp.proceed(args);  //明确调用业务层方法（切入点方法）
            System.out.println("after return...");
            return rtValue;
        }catch (Throwable t){
            System.out.println("after throwing...");
            throw new RuntimeException(t);
        }finally {
            System.out.println("after...");
        }
    }
}
