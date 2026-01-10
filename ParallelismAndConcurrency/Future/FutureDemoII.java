import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FutureDemoII {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<Integer> task1 = () -> {
            TimeUnit.SECONDS.sleep(5);
            return 10;
        };
        Callable<Integer> task2 = () -> {
            TimeUnit.SECONDS.sleep(10);
            return 20;
        };

        long startTime = System.nanoTime();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        var future1 = executorService.submit(task1);
        var future2 = executorService.submit(task2);
        var total = future1.get() + future2.get();
        System.out.println("Total is " + total);
        long endTime = System.nanoTime();

        double seconds = (double) (endTime - startTime) / 1_000_000_000.0;

        System.out.println("Total time take " + seconds + " seconds");
        executorService.shutdown();
    }

}
