package pl.misc.aspect.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {


    @Pointcut("execution(* get*())")
    public void allGettersPointCut() {
    }

    @Pointcut("within(pl.misc.aspect.model.Circle)")
    public void allCircleMethods() {
    }


    @Before("allGettersPointCut() && allCircleMethods()")
    public void loggingAdvice(JoinPoint joinPoint) {
        System.out.println("Advice run : Circle#Get method Called.");
        System.out.println("joinPoint#toString  : " + joinPoint.toString());
    }

    @Before("allGettersPointCut()")
    public void secondAdvice() {
        System.out.println("Advice run : All Getters Pointcut.");
    }

    @AfterReturning(pointcut = "args(name)", returning = "returnString")
    public void stringArgumentMethods(String name, String returnString) {
        System.out.println("A method that takes String arguments has been called. The value : " + name + ", The return value is : " + returnString);
        throw new NullPointerException();
    }

    @AfterThrowing("args(name)")
    public void stringArgumentMethodsAfterThrowing(String name) {
        System.out.println("Method has thrown. The value : " + name);
    }

    @Around("@annotation(pl.misc.aspect.aspects.annotations.Rollable)")
    public void recordARoll(JoinPoint joinPoint) {
        System.out.println("Rolling Recorded!!!!!!");
    }
}
