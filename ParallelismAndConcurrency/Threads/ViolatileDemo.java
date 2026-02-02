public class ViolatileDemo {

    static class CounterOne {
        public volatile int count = 0;
    }

    static class CounterTwo {
        public synchronized int getCount() {
            return count;
        }

        public synchronized void inc() {
            this.count++;
        }

        public volatile int count = 0;
    }
    public static void main(String[] args) {
        CounterOne counter = new CounterOne();
        CounterTwo counterTwo = new CounterTwo();
        Thread one = new Thread(() -> {
            for (int i = 0; i < 10000000; i++) {
                counter.count++;
                counterTwo.inc();
            }
            System.out.println("Counter " + counter.count);
            System.out.println("Counter two " + counterTwo.getCount());
        });

        Thread two = new Thread(() -> {
            for (int i = 0; i < 10000000; i++) {
                counter.count++;
                counterTwo.inc();
            }
            System.out.println("Counter " + counter.count);
            System.out.println("Counter two " + counterTwo.getCount());
        });

        one.start();
        two.start();

    }
}
