package by.lobanov.training.demos.demo1;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
/**
 * <a href="https://www.baeldung.com/spring-transactional-propagation-isolation">Transaction Propagation and Isolation in Spring @Transactional</a>
 * <a href="Управление транзакциями в Spring: @Transactional в деталях">https://habr.com/ru/articles/682362/</a>
 */
@Transactional
public class D1_SpringTransaction {

    /**
     * Spring creates a proxy, or manipulates the class byte-code, to manage the creation, commit,
     * and rollback of the transaction. In the case of a proxy, Spring ignores @Transactional in internal method calls.
     *
     * Simply put, if we have a method like callMethod and we mark it as @Transactional,
     * Spring will wrap some transaction management code around the invocation@Transactional method called:
     *
     * createTransactionIfNecessary();
     * try {
     *     callMethod();
     *     commitTransactionAfterReturning();
     * } catch (exception) {
     *     completeTransactionAfterThrowing();
     *     throw exception;
     * }
     */

    /**
     * Required (по умолчанию): Моему методу нужна транзакция, либо откройте ее для меня, либо используйте существующую → getConnection().setAutocommit(false).commit()
     * Supports: Мне не важно, открыта транзакция или нет, я могу работать в любом случае → не имеет отношения к JDBC
     * Mandatory: Я не собираюсь открывать транзакцию сам, но я буду плакать, если никто другой не откроет её → не имеет отношения к JDBC
     * Require_new: Я хочу полностью собственную транзакцию → getConnection().setAutocommit(false).commit()
     * Not_Supported: Мне очень не нравятся транзакции, я даже попытаюсь приостановить текущую, запущенную транзакцию → ничего общего с JDBC
     * Never: Я буду плакать, если кто-то другой запустит транзакцию → не имеет отношения к JDBC
     * Nested: Это звучит так сложно, но мы просто говорим о точках сохранения! → connection.setSavepoint()
     */


    /**
     * REQUIRED is the default propagation. Spring checks if there is an active transaction,
     * and if nothing exists, it creates a new one.
     * Otherwise, the business logic appends to the currently active transaction:
     */
    @Transactional()
    // Propagation propagation() default Propagation.REQUIRED;
    public void requiredExample(String user) {
        /**
         * --
         * if (isExistingTransaction()) {
         *     if (isValidateExistingTransaction()) {
         *         validateExisitingAndThrowExceptionIfNotValid();
         *     }
         *     return existing;
         * }
         * --
         * return createNewTransaction();
         */
    }

    /**
     * For SUPPORTS, Spring first checks if an active transaction exists.
     * If a transaction exists, then the existing transaction will be used.
     * If there isn’t a transaction, it is executed non-transactional:
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public void supportsExample(String user) {
        /**
         * if (isExistingTransaction()) {
         *     if (isValidateExistingTransaction()) {
         *         validateExisitingAndThrowExceptionIfNotValid();
         *     }
         *     return existing;
         * }
         * return emptyTransaction;
         */
    }

    /**
     * When the propagation is MANDATORY, if there is an active transaction, then it will be used.
     * If there isn’t an active transaction, then Spring throws an exception:
     */
    @Transactional(propagation = Propagation.MANDATORY)
    public void mandatoryExample(String user) {
        /**
         * if (isExistingTransaction()) {
         *     if (isValidateExistingTransaction()) {
         *         validateExisitingAndThrowExceptionIfNotValid();
         *     }
         *     return existing;
         * }
         * throw IllegalTransactionStateException;
         */
    }

    /**
     * For transactional logic with NEVER propagation, Spring throws an exception if there’s an active transaction:
     */
    @Transactional(propagation = Propagation.NEVER)
    public void neverExample(String user) {
        /**
         * if (isExistingTransaction()) {
         *     throw IllegalTransactionStateException;En
         * }
         * return emptyTransaction;
         */
    }

    /**
     * If a current transaction exists, first Spring suspends/stopped it,
     * and then the business logic is executed without a transaction
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void notSupportedExample(String user) {
        /**
         * if (isExistingTransaction()) {
         *     suspend(existing);
         * }
         * return emptyTransaction;
         */
    }
    // ...
    // The JTATransactionManager supports real transaction suspension out-of-the-box.
    // Others simulate the suspension by holding a reference to the existing one and then clearing it from the thread context

    /**
     * When the propagation is REQUIRES_NEW, Spring suspends/stop the current transaction if it exists,
     * and then creates a new one:
     */
    // Similar to NOT_SUPPORTED, we need the JTATransactionManager for actual transaction suspension.
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void requiresNewExample(String user) {
        /**
         * if (isExistingTransaction()) {
         *     suspend(existing);
         *     try {
         *         return createNewTransaction();
         *     } catch (exception) {
         *         resumeAfterBeginException();
         *         throw exception;
         *     }
         * }
         * return createNewTransaction();
         */
    }


    /**
     * For NESTED propagation, Spring checks if a transaction exists, and if so, it marks a save point.
     * This means that if our business logic execution throws an exception, then the transaction rollbacks to this save point.
     * If there’s no active transaction, it works like REQUIRED.
     * <p>
     * DataSourceTransactionManager supports this propagation out-of-the-box.
     * Some implementations of JTATransactionManager may also support this.
     * <p>
     * JpaTransactionManager supports NESTED only for JDBC connections.
     * However, if we set the nestedTransactionAllowed flag to true,
     * it also works for JDBC access code in JPA transactions if our JDBC driver supports save points.
     */
    @Transactional
    public void outerTransaction() {
        try {
            nestedExample("User1");
        } catch (Exception e) {
            System.out.println("Ошибка во вложенной транзакции: " + e.getMessage());
        }
//        isolation= TransactionDefinition.ISOLATION_READ_UNCOMMITTED
//        connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
//        propagation=TransactionDefinition.NESTED
//        Savepoint savePoint = connection.setSavepoint();
//        ...
//        connection.rollback(savePoint);
    }

    @Transactional(propagation = Propagation.NESTED)
    public void nestedExample(String user) {
        // Логика, зависящая от вложенной транзакции
        // Например, добавление данных
        System.out.println("Добавляем пользователя: " + user);

        // Пример вызова исключения для тестирования
        if ("User1".equals(user)) {
            throw new RuntimeException("Исключение внутри вложенной транзакции");
        }
    }


}
