package mod08_02;

/**
 * A counter class extends the Counter class, using the
 * synchronized keyword on methods for thread safety when
 * incrementing the counter. This prevents race conditions
 * by one thread executing the synchronized methods at a time.
 * 
 * @author angel
 */
public class CounterSyncMethod extends Counter {

	/**
	 * Synchronized method to increment the counter. The
	 * synchronized keyword ensures that only one thread can
	 * execute this method at a time, preventing race conditions.
	 */
	@Override
	public synchronized void updateCounter() {
		this.counter++;
	}

	/**
	 * A secondary synchronized method that also increments
	 * the counter. It ensures that no other thread can modify
	 * the counter while this method is being executed.
	 */
	private synchronized void secondMethod() {
		this.counter++;
	}
}
