package by.lobanov.training.ru.review.exception;

import org.springframework.transaction.annotation.Transactional;

public class NotificationLibraryException {

    public static class NotEnoughMoneyException extends RuntimeException {
    }

    @Transactional
    public void drawFromMainAccount(long amount) {
        try {
            long money = amount;
            long newMoney = -100;
            if (newMoney < 10) {
                try {
                    // NotificationService.send("Hello", "First");
                } catch (Throwable er) {
                    System.out.println("тра та та");
                }
            }
            if (newMoney < 0) {
                throw new NotEnoughMoneyException();
            }
            // MainAccount.saveCurrentMoney(newMoney);
        } catch (RuntimeException e) {
            System.out.println("Мы здесь");
            System.out.println(e.getMessage());
        }
    }

}
