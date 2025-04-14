package by.lobanov.training.demos.demo20;

public class UserServiceFacade {

    private UserServiceImpl userServiceImpl;
    private UserServiceMetrics userServiceMetrics;
    // notify
    // call
    // pizza

    public UserServiceFacade(UserServiceImpl userServiceImpl, UserServiceMetrics userServiceMetrics) {
        this.userServiceImpl = userServiceImpl;
        this.userServiceMetrics = userServiceMetrics;
    }

    public void updateProfile () {
        // userServiceImpl
        // userServiceMetrics
        // notify
        // CALL
        // pizza
    }
}
