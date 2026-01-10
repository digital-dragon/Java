import java.util.concurrent.TimeUnit;

class ThreadOne extends Thread {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                System.out.println("Running...");
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                System.out.println("Interrupted!, exiting....");
                return;
            }
        }
    }
}

public class InterruptDemo {
    public static void main(String[] args) {

        ThreadOne threadOne = new ThreadOne();
        threadOne.start();
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        threadOne.interrupt();
    }
}
