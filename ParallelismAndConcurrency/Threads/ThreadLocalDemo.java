import java.util.concurrent.TimeUnit;


class ThreadLocalDemoWrapper {
    static ThreadLocal<Integer> threadLocal;

    static {
        threadLocal = getThreadLocal();
    }

    public static ThreadLocal<Integer> getThreadLocal() {
        return new ThreadLocal<>();
    }

    public static Thread getThread(Integer i) {
        return new Thread(getRunnable(i));
    }

    public static Runnable getRunnable(Integer i) {
        return () -> {
            threadLocal.set(i);
            try {
                TimeUnit.SECONDS.sleep(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Thread local value " + threadLocal.get());
        };
    }

    public void runThreads() {
        var one = getThread(5);
        var two = getThread(10);

        one.start();
        two.start();
    }

}
public class ThreadLocalDemo {
    public static void main(String[] args) {
        var threadLocalDemoWrapper = new ThreadLocalDemoWrapper();
        threadLocalDemoWrapper.runThreads();

    }
}
