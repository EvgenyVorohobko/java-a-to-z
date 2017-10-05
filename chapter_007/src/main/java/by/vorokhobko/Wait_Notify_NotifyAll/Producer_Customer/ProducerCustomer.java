package by.vorokhobko.Wait_Notify_NotifyAll.Producer_Customer;

/**
 * Producer_Customer.
 *
 * Class Producer_Customer implemented template producer customer for 007, lesson 4.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 03.10.2017.
 * @version 1.
 */
public class ProducerCustomer {
    /**
     * The class field.
     */
    private static BlockingQueueRealization queue = new BlockingQueueRealization(10);
    /**
     * The main method.
     * @param args - args.
     */
    public static void main(String[] args) {
        Thread producer = new Thread(new Producer(queue));
        Thread customer = new Thread(new Customer(queue));

        producer.start();
        customer.start();
    }
}