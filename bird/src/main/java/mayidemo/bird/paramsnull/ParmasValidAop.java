package mayidemo.bird.paramsnull;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.lang.annotation.Annotation;

@Component
@Aspect
public class ParmasValidAop {

    @Around("execution(* mayidemo.bird.paramsnull.service.*.*(..))")
    public void a1(ProceedingJoinPoint pjp){
        MethodSignature signature= (MethodSignature) pjp.getSignature();
        Annotation[][] parameterAnnotations = signature.getMethod().getParameterAnnotations();
        Object[] args= pjp.getArgs();
        for(int i =0 ;i < parameterAnnotations.length ; i++){
            Annotation[] params = parameterAnnotations[i];
            for(Annotation p : params){
                if(p instanceof NotNull){
                    if(args[i] == null){
                        NotNull notNull = (NotNull) p;
                        System.out.println(String.format(" not null  data = %d , msg = %s",args[i],notNull.message()));
                    }
                }
                System.out.println(p.annotationType());
            }
        }

    }

}
