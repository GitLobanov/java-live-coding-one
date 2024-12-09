package by.lobanov.training.december.demo1.prototypeInject;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import jakarta.inject.Provider;


@Slf4j
@Component
@RequiredArgsConstructor
public class SingletonBean {

    @Autowired
    private ObjectFactory<PrototypeBean> prototypeBeanObjectFactory;
    @Autowired
    private final ApplicationContext applicationContext;
    @Autowired
    private final Provider<PrototypeBean> prototypeProvider;
    private final PrototypeBean prototypeBean;

    @Lookup
    public PrototypeBean getPrototypeBean() {
        return null; // Spring overrides this
    }

    public void usePrototype() {
        // prototype is singleton
        prototypeBean.doSomething();

        // USING ObjectFactory
//        prototypeBeanObjectFactory.getObject().doSomething();

        // WARSE EXAMPLE WITH APP CONTEXT
//        applicationContext.getBean(PrototypeBean.class).doSomething();

        // USING provider
//        prototypeProvider.get().doSomething();

        // @Lookup
//        getPrototypeBean().doSomething();

        // proxyMode look in Singletone class
    }
}
