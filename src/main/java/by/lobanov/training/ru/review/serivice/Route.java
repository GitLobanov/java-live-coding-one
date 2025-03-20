package by.lobanov.training.ru.review.serivice;

import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
//@Entity
@Table(name = "route", schema = "rm")
public class Route {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(schema = "rm", name = "route_x_kafka_address",
            joinColumns = @JoinColumn(name = "route_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "kafka_address_id", referencedColumnName = "id")
    )
    private Set<KafkaAddress> kafkaAddresses;

    public class KafkaAddress {
    }
}

/*

@Service

@RequiredArgsConstructor

public class RouteService {

    private final RouteRepository repository;


    public boolean isRouteHasEmptyKafkaAddress(int routeId) {

        Route route = repository.findById(routeId)
                .orElseThrow(() -> new NotFoundException("Route not found"));

        Set<Route.KafkaAddress> kafkaAddresses = route.getKafkaAddresses();

        return kafkaAddresses.isEmpty();

    }
}

*/
