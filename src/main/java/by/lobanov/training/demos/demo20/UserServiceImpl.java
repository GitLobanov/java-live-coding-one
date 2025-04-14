package by.lobanov.training.demos.demo20;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service()
@Scope()
@Primary
public class UserServiceImpl implements UserService {

    private UserServiceMetrics userServiceMetrics;

    public UserServiceImpl(UserServiceMetrics userServiceMetrics) {
        this.userServiceMetrics = userServiceMetrics;
    }

    @Bean(initMethod = "sayHello")
    public UserServiceMetrics getMetrics() {
        return new UserServiceMetrics();
    }
}
