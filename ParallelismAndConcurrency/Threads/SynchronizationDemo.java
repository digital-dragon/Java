public class SynchronizationDemo {
    private static int counter = 0;
    private static int counter1 = 0;
    private static int counter2 = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread one = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                synchronized (DaemonThreadDemo.class) {
                    counter++;
                }
            }
        });

        Thread two = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                synchronized (DaemonThreadDemo.class) {
                    counter++;
                }
            }
        });

        Thread three = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                increment();
            }

        });

        Thread four = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                increment();
            }
        });

        Thread five = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                synchronizedIncrement();
            }

        });

        Thread six = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                synchronizedIncrement();
            }
        });

        one.start();
        two.start();
        three.start();
        four.start();
        five.start();
        six.start();

        one.join();
        two.join();
        three.join();
        four.join();
        five.join();
        six.join();


        System.out.println(Thread.currentThread().getName() + " Counter = " + counter);
        System.out.println(Thread.currentThread().getName() + " Counter1 = " + counter1);
        System.out.println(Thread.currentThread().getName() + " Counter2 = " + counter2);
    }

    private static void increment() {
        counter1++;
    }

    private synchronized static void synchronizedIncrement() {
        counter2++;
    }
}
