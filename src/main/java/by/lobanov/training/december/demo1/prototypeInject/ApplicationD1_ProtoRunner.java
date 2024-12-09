package by.lobanov.training.december.demo1.prototypeInject;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/**
 *<a href="https://www.baeldung.com/spring-inject-prototype-bean-into-singleton">Injecting Prototype Beans into a Singleton Instance in Spring</a>
 *<br>
 * <a href="https://habr.com/ru/articles/761330/">Как внедрить Prototype в Singleton в Spring с помощью параметра ProxyMode</a>
 */
@Configuration
@ComponentScan()
@Slf4j
class ApplicationD1_ProtoRunner {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(ApplicationD1_ProtoRunner.class);

        SingletonBean firstSingleton = context.getBean(SingletonBean.class);
        firstSingleton.usePrototype();
        SingletonBean secondSingleton = context.getBean(SingletonBean.class);
        secondSingleton.usePrototype();
    }
}

