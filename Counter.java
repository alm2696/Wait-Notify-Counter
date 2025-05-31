package mod08_02;

/**
 * A basic counter class that implements Runnable to increment a
 * counter in a multi-threaded environment without synchronization.
 * This may lead to race conditions when accessed by multiple threads.
 * 
 * @author angel
 */
public class Counter implements Runnable {

	// Shared counter variable that will be incremented by multiple threads.
	protected int counter = 0;

	/**
	 * The method that is executed when the thread starts. It
	 * increments the counter 1,000,000 times by calling updateCounter().
	 */
	@Override
	public void run() {
		// Increment counter 1,000,000 times
		for (int i = 0; i < 1000000; i++) {
			updateCounter();
		}
	}

	/**
	 * Increments the counter by 1. This method is not
	 * synchronized, which may lead to race conditions
	 * when accessed by multiple threads simultaneously.
	 */
	protected void updateCounter() {
		this.counter++;
	}

	/**
	 * Returns the current value of the counter.
	 * 
	 * @return The value of the counter.
	 */
	public int getCounter() {
		return this.counter;
	}
}
