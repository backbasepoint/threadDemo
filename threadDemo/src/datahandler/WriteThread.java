package datahandler;

public class WriteThread extends Thread {
	private DataHandler dataHandler;
	public WriteThread(DataHandler dataHandler){
		this.dataHandler = dataHandler;
	}
	@Override
	public void run() {
		char[] data = new char[10];
		while(true){
			try {
				fill(data);
				dataHandler.doWrite(data);
				Thread.sleep((long)(Math.random()*1000+100)); 
			} catch (InterruptedException e) {
				break;
			}
		}
	}
	
	private void fill(char[] data){
		char c =(char)(Math.random()*26+'A');
		for(int i=0;i<data.length;i++){
			data[i] = c;
		}
	}
}
