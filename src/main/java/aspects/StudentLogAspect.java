package aspects;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class StudentLogAspect {
    @Pointcut("execution(* rest.StudentController.*(..))")
    private void studentController(){}

    @Around("studentController()")
    public Object logStudentServiceTime(ProceedingJoinPoint pjp) throws Throwable {
        long startingTime = System.currentTimeMillis();
        Object result = pjp.proceed();
        System.out.println("Method: " + pjp.getSignature() + " With args: "
                + Arrays.toString(pjp.getArgs()) +
                " Took -> Time: " + (System.currentTimeMillis() - startingTime) + " ms");
        return result;
    }
}
