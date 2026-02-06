import static java.util.concurrent.Executors.newFixedThreadPool;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        var threadPool = newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            int taskNo = i;
            threadPool.execute(() -> System.out.println(Thread.currentThread().getName() + " Task " + taskNo));
        }

        threadPool.shutdown();
    }
}
