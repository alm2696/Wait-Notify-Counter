package mod08_02;

/**
 * A class demonstrating the use of wait() and notifyAll()
 * methods. It allows threads to wait until notified to 
 * continue execution. The methods are synchronized for 
 * coordination between waiting and notifying threads.
 * 
 * @author angel
 */
public class WaitAndNotify {

	/**
	 * Causes the current thread to wait until it is notified. The
	 * method uses synchronized to ensure that the thread holds the
	 * lock while waiting. Once notified, the thread resumes execution.
	 */
	public synchronized void runWait() {

		// Get the current thread and set its name for better logging
		Thread currThread = Thread.currentThread();
		currThread.setName("Wait Thread");
		System.out.println(currThread + ": waiting");

		try {
			// Thread waits until it is notified
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// After being notified, the thread continues execution
		System.out.println(currThread + ": executing again");

		// Simulate some work after resuming execution
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(currThread + ": finished");
	}

	/**
	 * Notifies all waiting threads to resume execution. The method uses
	 * notifyAll() to ensure all threads waiting on this object are notified,
	 * and it is synchronized to prevent issues with thread coordination.
	 */
	public synchronized void runNotify() {
		// Notify all threads waiting on this object
		notifyAll();
	}
}
