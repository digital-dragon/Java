import java.util.concurrent.TimeUnit;

public class ThreadSleepDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Going to sleep for 2 secs!");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Out of slumber!");
    }
}
