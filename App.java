package mod08_02;

import java.util.Scanner;

/**
 * This class contains the main method to demonstrate different multi-
 * threading techniques, including unsynchronized counter, synchronized 
 * method, synchronized block, and using wait() and notify() with threads.
 * 
 * @author angel
 */
public class App {

	/**
	 * The main entry point of the application.
	 * 
	 * @param args Command-line arguments.
	 */
	public static void main(String[] args) {

		// Scanner for user input to select which example to run.
		Scanner kbdIn = new Scanner(System.in);

		// Loop to continuously prompt for a choice of threading example.
		while (true) {
			System.out.println();
			System.out.print("Example to run: ");
			int choice = kbdIn.nextInt();

			// Handle user's choice by running the corresponding example.
			switch (choice) {

			// Case 1: No synchronization, which may lead to race conditions.
			case 1:
				Counter counter = new Counter();
				runThreads(counter);
				System.out.println("No Sync: counter: " + counter.getCounter());
				break;

				// Case 2: Synchronization using synchronized method.
			case 2:
				Counter counter2 = new CounterSyncMethod();
				runThreads(counter2);
				System.out.println("SyncMethod: counter: " + counter2.getCounter());
				break;

				// Case 3: Synchronization using synchronized block.
			case 3:
				Counter counter3 = new CounterSyncBlock();
				runThreads(counter3);
				System.out.println("SyncBlock: counter: " + counter3.getCounter());
				break;

				// Case 4: Demonstrates the use of wait() and notify() between threads.
			case 4:
				int waitCount = 2; // Number of threads to wait

				Thread[] threads = new Thread[waitCount];

				WaitAndNotify example = new WaitAndNotify();

				// Create and start multiple threads that will call runWait()
				for (int i = 0; i < waitCount; i++) {
					threads[i] = new Thread(() -> {
						example.runWait();
					});
					threads[i].start();
				}

				// Simulate some delay before notifying waiting threads
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				// Notify the waiting threads
				example.runNotify();

				// Wait for all threads to complete execution
				System.out.println("Joining threads");
				for (int i = 0; i < waitCount; i++) {
					try {
						threads[i].join();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	/**
	 * Runs two threads that execute the given Runnable task.
	 * 
	 * @param counter The Runnable instance to run in threads.
	 */
	private static void runThreads(Runnable counter) {
		Thread t1 = new Thread(counter);
		Thread t2 = new Thread(counter);
		t1.start();
		t2.start();

		// Wait for both threads to finish
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
