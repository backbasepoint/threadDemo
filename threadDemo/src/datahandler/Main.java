package datahandler;

public class Main  {
	

	/**
	 * @param args
	 * java��synchronized�ṩ����ײ����������Ҫ��synchronized�Ļ����ϣ�
	 * ʵ���Լ����߼������ͱ�����ϸ���ReadWriteLock
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
