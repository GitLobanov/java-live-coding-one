package by.lobanov.training.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TimeMeasurementProxy implements InvocationHandler {
    private final Object target;

    private TimeMeasurementProxy(Object target) {
        this.target = target;
    }

    public static <T> T createProxy(T target, Class<T> interfaceClass) {
        return (T) Proxy.newProxyInstance(
                interfaceClass.getClassLoader(),
                new Class<?>[]{interfaceClass},
                new TimeMeasurementProxy(target));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Method targetMethod = target.getClass().getMethod(method.getName(), method.getParameterTypes());

        if (targetMethod.isAnnotationPresent(MeasureTime.class)) {
            long startTime = System.nanoTime();
            try {
                return method.invoke(target, args);
            } finally {
                long endTime = System.nanoTime();
                double durationMs = (endTime - startTime) / 1_000_000.0;
                System.out.printf("Method %s executed in %.3f ms%n",
                        method.getName(), durationMs);
            }
        } else {
            return method.invoke(target, args);
        }
    }
}
