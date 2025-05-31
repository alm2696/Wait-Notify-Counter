package mod08_02;

/**
 * A counter class that extends the basic Counter class, using a synchronized
 * block to ensure thread safety when incrementing the counter. This avoids
 * race conditions by synchronizing access to the critical section.
 * 
 * @author angel
 */
public class CounterSyncBlock extends Counter {

	// Lock object used to synchronize access to the counter
	private final String lockCounter = "counter lock";

	/**
	 * Increments the counter inside a synchronized block
	 * to ensure that only one thread can modify the
	 * counter at a time. This prevents race conditions.
	 */
	@Override
	public void updateCounter() {
		// Synchronized block to ensure thread-safe access to the counter
		synchronized (lockCounter) {
			this.counter++;
		}
	}

	/**
	 * A secondary method that also increments the counter inside a synchronized block.
	 * It uses the same lock object to ensure consistency across multiple methods.
	 */
	private void secondMethod() {
		// Synchronized block to increment the counter safely
		synchronized (lockCounter) {
			this.counter++;
		}
	}
}
