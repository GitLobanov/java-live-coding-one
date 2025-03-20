package by.lobanov.training.ru.review.serivice;

public class EmployeeService {
}

/**
Провести ревью кода:

 // Задача - начислить всем работникам, которые провели за последний период больше 50-ти интервью бонус в 15% от ЗП,
 // а тем, кто провел больше 100 - 30%. И отправить каждому сообщение.

 @Component
public class EmployeeService {

    @Autowired
    private final EmployeeRepository repository;
    @Autowired
    private final PaymentService paymentService;
    private final NotificationClient client = new NotificationClient();

    @Transactional
    public void updateAll() throws NotificationClientIOException {
        try {
            repository.findAll().forEach(emp -> update(emp.getId()));
        } catch (Throwable t) {
            //do nothing
        }
    }

    @Transactional(isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRES_NEW)
    private void update(Long id) throws NotificationClientIOException {
        Employee employee = repository.findById(id).get();
        if (employee.interviewsLastPeriod > 50) {
            double bonus = 0.15 * employee.salary.getAmount();
            paymentService.processPayment(bonus, id);
            client.send(id)

            ;
        }
        if (employee.interviewsLastPeriod > 100) {
            double bonus = 0.3 * employee.salary.getAmount();
            paymentService.processPayment(bonus, id);
            client.send(id)

            ;
        }
        System.out.println("Finished transaction for employee");
    }

    @Data
    @Entity
    class Employee {

        private final int interviewsLastPeriod;
        @ManyToOne
        private final Salary salary;

        public Employee(int interviewsLastPeriod, Salary salary) {
            this.interviewsLastPeriod = interviewsLastPeriod;
            this.salary = salary;
        }
    }
}

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PaymentService {
    //...//
    public void processPayment(double amount, Long id) {
        //...//
    }
}

**/
