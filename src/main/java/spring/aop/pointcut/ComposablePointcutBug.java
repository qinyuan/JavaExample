package spring.aop.pointcut;

import org.springframework.aop.Pointcut;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.AopUtils;
import org.springframework.aop.support.ComposablePointcut;

import java.lang.reflect.Method;

import static common.PrintUtils.print;

public class ComposablePointcutBug {
    public void test() {
    }

    public static void main(String[] args) throws Exception {
        AspectJExpressionPointcut p = new AspectJExpressionPointcut();
        p.setExpression("execution(* java.lang.Integer.*(..))");
        ComposablePointcut pointcut = new ComposablePointcut((Pointcut) p);
        ComposablePointcut pointcut2 = new ComposablePointcut(pointcut);

        p = new AspectJExpressionPointcut();
        p.setExpression("execution(* java.lang.String.*(..))");
        pointcut.union((Pointcut) p);

        Method method = String.class.getMethod("toString");
        print(pointcut.getMethodMatcher().matches(method, String.class));
        print(AopUtils.canApply(pointcut, String.class));
        print(pointcut2.getMethodMatcher().matches(method, String.class));
        print(AopUtils.canApply(pointcut2, String.class));
    }
}
