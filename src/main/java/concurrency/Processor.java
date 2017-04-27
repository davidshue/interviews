package concurrency;

import java.util.concurrent.CountDownLatch;

/**
 * Created by david on 2/14/17.
 */
public class Processor implements Runnable {
    private CountDownLatch latch;

    public Processor(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("Started.");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        latch.countDown();
        System.out.println("count " + latch.getCount());
    }
}
