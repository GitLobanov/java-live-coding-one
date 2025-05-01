package by.lobanov.training.ru.review.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan()
public class CyclicDependency {

    @Component
    public class A {

        @Autowired
        public B b;
    }

    @Component
    public class B {

        @Autowired
        public A a;

        private void methodB () {
            System.out.println("B: I alive!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(CyclicDependency.class);

        A a = context.getBean(A.class);
        B b = context.getBean(B.class);
        b.methodB();
    }
}
