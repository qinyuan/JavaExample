package spring.aop.pointcut;

import org.springframework.aop.Pointcut;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.AopUtils;
import org.springframework.aop.support.ComposablePointcut;

import java.lang.reflect.Method;

import static common.PrintUtils.print;

public class ComposablePointcutExample {

    public void test() {
    }

    public static void main(String[] args) throws Exception {
        Class<?> clazz = ComposablePointcutExample.class;
        Method method = clazz.getMethod("test");

        AspectJExpressionPointcut p = new AspectJExpressionPointcut();
        p.setExpression("execution(* spring.aop.pointcut.*.hello(..))");
        ComposablePointcut pointcut = new ComposablePointcut((Pointcut) p);

        print(p.getMethodMatcher().matches(method, clazz));
        print(pointcut.getMethodMatcher().matches(method, clazz));
        print(AopUtils.canApply(pointcut, ComposablePointcutExample.class));
        print();

        p = new AspectJExpressionPointcut();
        p.setExpression("execution(* spring.aop.pointcut.*.test(..))");
        pointcut.union((Pointcut) p);

        print(p.getMethodMatcher().matches(method, clazz));
        print(pointcut.getMethodMatcher().matches(method, clazz));
        print(AopUtils.canApply(pointcut, ComposablePointcutExample.class));
    }
}
