import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableDemo {
    public static void main(String[] args) {
        CompletableFuture<Integer> completableFutureI = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("Ignoring...");
            }
            return 10;
        });

        try {
            var returnValue = completableFutureI.thenApply(a -> a * 10).get();
            System.out.println("Result is " + returnValue);
        } catch (InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        CompletableFuture<Integer> completableFutureII = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("Ignoring...");
            }
            return 10;
        });

        var future = completableFutureII.thenCompose(a -> CompletableFuture.supplyAsync(
                () -> a * 20
        ));
        try {
            System.out.println("Result is " + future.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
