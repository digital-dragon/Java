public class ThreadClassMethods {
    public static void main (String[] args) throws InterruptedException {
        Thread loopyThreadOne = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " with priority " + Thread.currentThread().getPriority() + " Going to loop");
            for (int i = 0; i < 100000000; i++) {
                if (Thread.interrupted()) {
                    System.out.println(Thread.currentThread().getName() + " with priority " + Thread.currentThread().getPriority() + " Interrupted at i : " + i);
                }
            }
        });

        Thread sleepyThreadOne = new Thread(() -> {
            System.out.println("Thread with id " + Thread.currentThread().getId() + " and name " + Thread.currentThread().getName() + " going to sleep");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread sleepyThreadTwo = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " going to sleep");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        sleepyThreadOne.start();
        sleepyThreadTwo.start();

        sleepyThreadOne.join();
        sleepyThreadTwo.join();

        loopyThreadOne.start();

        Thread.sleep(1);
        loopyThreadOne.interrupt();
        System.out.println("Is " + loopyThreadOne.getName() + " interrupted " + loopyThreadOne.isInterrupted());
    }
}
