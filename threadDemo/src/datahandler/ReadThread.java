package datahandler;

public class ReadThread extends Thread {
	private DataHandler dataHandler;
	
	public ReadThread(DataHandler dataHandler){
		this.dataHandler = dataHandler;
	}
	
	@Override
	public void run() {
		while(true){
			try {
				dataHandler.doRead();
				Thread.sleep((long)(Math.random()*1000+100)); // ���������Ч���ȹ̶�������
			} catch (InterruptedException e) {
				break;
			}
		}
	}
}
