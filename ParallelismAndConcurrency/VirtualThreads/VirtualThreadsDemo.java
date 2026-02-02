public class VirtualThreadsDemo {
    public static class ThreadOne extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " started ....");
            System.out.println(Thread.currentThread().getName() + " ended....");
        }
    }

    public static class ThreadTwo implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " started ....");
            System.out.println(Thread.currentThread().getName() + " ended....");
        }
    }
    public static void main(String[] args) throws InterruptedException {

        Thread one= Thread.ofVirtual().start(new ThreadOne());
        Thread two = Thread.ofVirtual().unstarted(new ThreadTwo());
        two.start();
        two.join();

        one.join();

    }
}
