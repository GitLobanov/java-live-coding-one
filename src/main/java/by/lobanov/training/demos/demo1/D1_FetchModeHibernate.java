package by.lobanov.training.demos.demo1;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class D1_FetchModeHibernate {

    /**
     * <a href="https://www.baeldung.com/hibernate-fetchmode">FetchMode in Hibernate</a>
     */

    @Entity
    @Data
    public class Client {
        @Id
        @GeneratedValue
        private Long id;

        /**
         * And that for the next line:
         * Set<Order> orders = customer.getOrders();
         * Copy
         * We’ll see subsequent queries for the related orders:
         * Hibernate:
         *     select ...from order
         *     where order0_.customer_id=?
         * The Hibernate FetchMode.SELECT generates a separate query for each Order that needs to be loaded.
         * In our example, that gives one query to load the Customers and five additional queries to load the orders collection.
         */
        @OneToMany(mappedBy = "customer")
        // WILL BE N+1 PROBLEM, WHEN WE WANT TO GET ORDERS, EVERY ONO is NEW QUERY
        @Fetch(value = FetchMode.SELECT)
        private Set<Orders> orders_SELECT = new HashSet<>();

        /**
         * Hibernate will try to load the orders collection in batches defined by the size parameter.
         * In our example, we have just five orders so one query is enough.
         * We’ll still use the same query:
         * Hibernate:
         *     select ...from order
         *     where order0_.customer_id=?
         * But it will only be run once. Now we have just two queries: One to load the Customer and one to load the orders collection.
         */
        @OneToMany
        @Fetch(FetchMode.SELECT)
        @BatchSize(size=10)
        private Set<Orders> orders_SELECT_BatchSize;

        /**
         * While FetchMode.SELECT loads relations lazily, FetchMode.JOIN loads them eagerly, say via a join.
         * This results in just one query for both the Customer and their Orders.
         * Hibernate:
         *     select ...
         *     from
         *         customer customer0_
         *     left outer join
         *         order order1
         *             on customer.id=order.customer_id
         *     where
         *         customer.id=?
         */
        @OneToMany
        @Fetch(FetchMode.JOIN)
        private Set<Orders> orderJOIN;

        /**
         * Because the orders property is a collection, we could also use FetchMode.SUBSELECT
         * We can only use SUBSELECT with collections.
         * Hibernate:
         *     select ...
         *     from
         *         order order0_
         *     where
         *         order0_.customer_id in (
         *             select
         *                 customer0_.id
         *             from
         *                 customer customer0_
         *         )
         */
        @OneToMany
        @Fetch(FetchMode.SUBSELECT)
        private Set<Orders> orders_SUBSELECT;


        /**
         * FetchMode vs FetchType
         * In general, FetchMode defines how Hibernate will fetch the data (by select, join or subselect).
         * FetchType, on the other hand, defines whether Hibernate will load data eagerly or lazily.
         * The exact rules between these two are as follows:
         * - if the code doesn’t set FetchMode, the default one is JOIN and FetchType works as defined
         * - with FetchMode.SELECT or FetchMode.SUBSELECT set, FetchType also works as defined
         * - with FetchMode.JOIN set, FetchType is ignored and a query is always eager
         */
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer") // LAZY WILL BE IGNORED
        @Fetch(FetchMode.SUBSELECT)
        private Set<Orders> ordersFetch;

    }

    @Entity
    @Data
    public class Orders {
        String name;
        BigDecimal price;

        @ManyToOne
        @JoinColumn(name = "customer_id")
        private Client customer;
    }

}
