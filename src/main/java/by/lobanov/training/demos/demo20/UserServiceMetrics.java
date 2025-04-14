package by.lobanov.training.demos.demo20;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Service
public class UserServiceMetrics implements UserService {

    private UserServiceImpl userService;

    @PostConstruct
    public void postConstruct (UserServiceImpl userService){
        this.userService = userService;
    }

    // init method
    public boolean sayHello () {
        return false;
    }
}
