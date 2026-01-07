public class DaemonThreadDemo {
    public static void main(String[] args) {

        Thread nonDaemonThread = new Thread(
                () -> {
                    int count = 0;
                    while (count < 11) {
                        try {
                            Thread.sleep(500);
                            System.out.println("Non Daemon thread running****************");
                            count++;
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    System.out.println("Non Daemon thread exiting");
                }
        );

        Thread daemonThread = new Thread( new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                        System.out.println("Daemon thread running");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

        });


        daemonThread.setDaemon(true);
        nonDaemonThread.start();
        daemonThread.start();

    }
}
