import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class Demo {
    ExecutorService executorService = Executors.newSingleThreadExecutor();

    public Future<Integer> doubleNumber(Integer input) {
        return executorService.submit(() -> {
            TimeUnit.SECONDS.sleep(2);
            return input * 2;
        });
    }
}

public class FutureDemo {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i < 11; i++) {
            callDemo(i);
        }
    }

    public static void callDemo(int input) throws InterruptedException {
        var demo = new Demo();
        var future = demo.doubleNumber(input);

        while (!future.isDone()) {
            if (!future.isDone()) {
                System.out.println("Future still working on " + input);
                Thread.sleep(50);
            }
        }

        try {
            var value = future.get();
            System.out.println(input + " * 2 = " + value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
