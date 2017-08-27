package by.vorokhobko.JMM;

/**
 * BankAccount.
 *
 * Class BankAccount show race condition in Multithreading for 007, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru.
 * @since 19.08.2017.
 * @version 1.
 */
public class BankAccount {
    /**
     * The method main.
     * @param args - args.
     */
    public static void main(String[] args) {
        Account account = new Account(10000);
        System.out.println("Balance your score: " + account.getBalance());
        Thread add = new Thread(new ScoreAdd(account));
        Thread take = new Thread(new ScoreTake(account));
        add.start();
        take.start();
        try {
            add.join();
            take.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Balance your score: " + account.getBalance());
    }

    /**
     * The class ScoreAdd.
     */
    private static class ScoreAdd implements Runnable {
        /**
         * The class field.
         */
        private Account account;
        /**
         * Add constructor.
         * @param account - account.
         */
        private ScoreAdd(Account account) {
            this.account = account;
        }
        /**
         * Override method run.
         */
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                account.depositAdd(i);
            }
        }
    }

    /**
     * The class ScoreTake.
     */
    private static class ScoreTake implements Runnable {
        /**
         * The class field.
         */
        private Account account;
        /**
         * Add constructor.
         * @param account - account.
         */
        private ScoreTake(Account account) {
            this.account = account;
        }
        /**
         * Override method run.
         */
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                account.depositTake(i);
            }
        }
    }

    /**
     * The class Account.
     */
    private static class Account {
        /**
         * The class field.
         */
        private int balance;
        /**
         * Add getter balance.
         * @return tag.
         */
        public int getBalance() {
            return balance;
        }
        /**
         * Add constructor.
         * @param balance - balance.
         */
        private Account(int balance) {
            this.balance = balance;
        }
        /**
         * The method add amount in deposit.
         * @param amount - amount.
         */
        private void depositAdd(int amount) {
            balance += amount;
        }
        /**
         * The method take amount in deposit.
         * @param amount - amount.
         */
        private void depositTake(int amount) {
            balance -= amount;
        }
    }
}