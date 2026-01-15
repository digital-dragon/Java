import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProducerConsumerDemo {

    public static boolean empty = true;


    static class Producer implements Runnable {
        Messages messages;
        int i = 0;

        public Producer(Messages messages) {
            this.messages = messages;
        }

        @Override
        public void run() {
            while(messages.empty) {
                System.out.println("Putting " + ++i);
                messages.put(i);
                if (messages.list.size() > 20) {
                    messages.empty = false;
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    static class Consumer implements Runnable {

        Messages messages;

        public Consumer(Messages messages) {
            this.messages = messages;
        }

        @Override
        public void run() {
            while (true) {
                System.out.println("Retrieved " + messages.get());
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }

    static class Messages {
        private List<Integer> list = new ArrayList<>();

        private boolean empty = true;

        public synchronized void put(Integer i) {
            if (list.size() >= 20) {
                empty = false;
                notifyAll();
            }
            list.add(i);
        }

        public synchronized int get() {
            while (empty) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            var retVal = list.removeLast();
            if (list.isEmpty()) {
                empty = true;
                notifyAll();
            }
            return retVal;
        }
    }

    public static void main(String[] args) {

        Messages messages = new Messages();
        (new Thread(new Producer(messages))).start();
        (new Thread(new Consumer(messages))).start();

    }
}
