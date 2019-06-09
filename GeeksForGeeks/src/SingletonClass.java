
public class SingletonClass {

	private static SingletonClass obj;
	private static boolean isExistObject = false;

	private SingletonClass() {
		System.out.println("Object created");
	}

	static SingletonClass createObject() {
		isExistObject = true;

		if (isExistObject == false) {
			obj = new SingletonClass();
			isExistObject = true;
		}

		System.out.println("object returned");

		return obj;
	}
}

class Semaphore {
	private int counter = 0;
	private final int resourceSize = 1;

	public void acquireLock() {
		if (counter < resourceSize) {
			counter++;
		}
		else 
		{
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
	}

	public synchronized boolean releaseLock() throws Exception {
		if (counter > 0) {
			counter--;
			this.notifyAll();
		}
		throw new Exception("Lock is not acquired");
	}
}