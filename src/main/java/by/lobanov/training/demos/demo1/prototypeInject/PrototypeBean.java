package by.lobanov.training.demos.demo1.prototypeInject;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PrototypeBean {

    LocalDateTime dateTime;

    public PrototypeBean() {
        this.dateTime = LocalDateTime.now();
    }

    public void doSomething() {
        log.info("Prototype instance created " + dateTime);
    }
}
