import java.util.concurrent.TimeUnit;

public class ThreadCreationDemo {

    public static class ThreadBySubclassing extends Thread {

        public ThreadBySubclassing(String name) {
            super(name); // Call the parent Thread class constructor with the name
        }

        @Override
        public void run() {
            var name = Thread.currentThread().getName();
            System.out.println(name + " starts");
            System.out.println(name + " ends");
        }
    }

    public static class ThreadByRunnableImplementation implements Runnable {
        @Override
        public void run() {
            var name = Thread.currentThread().getName();
            System.out.println(name + " starts");
            System.out.println(name + " ends");
        }
    }

    public static Runnable anonymousRunnable = new Runnable() {
        @Override
        public void run() {
            var name = Thread.currentThread().getName();
            System.out.println(name + " starts");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(name + " ends");
        }
    };


    public static void main(String[] args) {
        System.out.println("Main thread starts");
        ThreadBySubclassing threadBySubclassing = new ThreadBySubclassing("Subclass thread");
        threadBySubclassing.start();

        Thread threadByRunnableImplementation = new Thread(new ThreadByRunnableImplementation(), "Runnable thread");
        threadByRunnableImplementation.start();

        Thread anonymousThread = new Thread(anonymousRunnable, "Anonymous thread");
        anonymousThread.start();

        Thread lambdaThread = new Thread(() -> {
            var name = Thread.currentThread().getName();
            System.out.println(name + " starts");
            System.out.println(name + " ends");
        }, "Lambda Thread");

        lambdaThread.start();
        System.out.println("Main thread ends");
    }
}
