package datahandler;

public class Main  {
	

	/**
	 * @param args
	 * java的synchronized提供了最底层的物理锁，要在synchronized的基础上，
	 * 实现自己的逻辑锁，就必须仔细设计ReadWriteLock
	 */
	public static void main(String[] args) {
		DataHandler dataHandler =new DataHandler();
		new ReadThread(dataHandler).start();
		new ReadThread(dataHandler).start();
		new ReadThread(dataHandler).start();
		new ReadThread(dataHandler).start();
		new WriteThread(dataHandler).start();
		new WriteThread(dataHandler).start();
	}

}
