package phase3.MultithreadExceptionHandlingAndOOPs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyThread extends Thread {

  private static final Logger LOG = LogManager.getLogger(MyThread.class);

  @Override
  public void run() {
    LOG.info("Concurrent thread started running...");
  }
}
