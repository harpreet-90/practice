

public class ThreadClass implements Runnable {
	static int count = 0;
	Semaphore sm = new Semaphore();

	public void run() {
		sm.acquireLock();
		SingletonClass.createObject();
		try {
			sm.releaseLock();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("thread is running...");

	}

}
