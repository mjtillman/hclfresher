package phase3.MultithreadExceptionHandlingAndOOPs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RunnableThread implements Runnable {

  private static final Logger LOG = LogManager.getLogger(RunnableThread.class);

  public static int myCount = 0;

  public RunnableThread() {}

  public void run() {

    while (RunnableThread.myCount <= 10) {
      try {
        LOG.info("Expl Thread: {}", ++RunnableThread.myCount);
        Thread.sleep(100);

      } catch (InterruptedException iex) {
       LOG.info("Exception in thread: {}", iex.getMessage());
      }
    }
  }

  public static void main(String a[]) {

    LOG.info("Starting Main Thread...");

    RunnableThread mrt = new RunnableThread();
    Thread t = new Thread(mrt);
    t.start();

    while (RunnableThread.myCount <= 10) {
      try {
        LOG.info("Main Thread: {}", ++RunnableThread.myCount);
        Thread.sleep(100);
      } catch (InterruptedException iex){
        LOG.info("Exception in main thread: {}", iex.getMessage());
      }
    }
    LOG.info("End of Main Thread...");
  }
}
