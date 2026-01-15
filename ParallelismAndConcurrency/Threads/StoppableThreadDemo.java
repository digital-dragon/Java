import java.util.concurrent.TimeUnit;

public class StoppableThreadDemo {
    public static class MyRunnable implements Runnable {
        private boolean isStopped = false;

        public synchronized boolean stopRequested() {
            return isStopped;
        }

        public synchronized void setStopped(boolean stopped) {
            isStopped = stopped;
        }

        @Override
        public void run() {
            while(!stopRequested()) {
                System.out.println("Thread running...");
                try {
                    TimeUnit.MILLISECONDS.sleep(300);
                } catch (InterruptedException e) {
                    System.out.println("Thread exiting...");
                }
            }
            System.out.println("Thread exiting...");
        }
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread myThread = new Thread(myRunnable);
        myThread.start();
        try {
            TimeUnit.SECONDS.sleep(5);
            myRunnable.setStopped(true);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
