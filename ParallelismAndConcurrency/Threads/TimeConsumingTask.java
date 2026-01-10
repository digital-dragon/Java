import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

class TimeConsumingTask implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("Time consuming task starts");
        TimeUnit.SECONDS.sleep(2);
        return "Data";
    }

}
