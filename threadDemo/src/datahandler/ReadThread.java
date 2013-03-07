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
				Thread.sleep((long)(Math.random()*1000+100)); // 休眠随机数效果比固定的数好
			} catch (InterruptedException e) {
				break;
			}
		}
	}
}
