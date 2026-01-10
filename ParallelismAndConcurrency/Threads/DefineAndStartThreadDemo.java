class HelloRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello Runnable");
    }

}

class HelloThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello Thread");
    }
}

public class DefineAndStartThreadDemo {
    public static void main(String[] args) {
        Thread thread1 = new HelloThread();
        Thread thread2 = new Thread(new HelloRunnable());

        thread1.start();
        thread2.start();
    }

}
