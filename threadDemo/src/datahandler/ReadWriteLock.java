package datahandler;

public class ReadWriteLock {
	private int readingThread=0;
	private int writeThread=0;
	private boolean isWrite = true;
	private int waitingThread=0;
	
	public synchronized void readLock() throws InterruptedException{
		//while(isWrite&&writeThread>0){  //1
		while(writeThread>0||(isWrite&&waitingThread>0)){
			this.wait();
		}
		readingThread++;
	}
	
	public synchronized void writeLock() throws InterruptedException{
		waitingThread++;
		try{
			while(readingThread>0||writeThread>0){
				this.wait();
			}
		}finally{
			waitingThread--;
		}
		//��writeThread =0 ���е�����ʱ��1����д�п��ܻ�ͨ����
		//�Ӷ���д_����ͻ�����Եü�waitingThread ���Կ���
		writeThread++; 
	}
	
	public synchronized void readReleaseLock(){
		readingThread--;
		isWrite=true;
		notifyAll();
	}
	
	public synchronized void writeReleaseLock(){
		writeThread--;
		isWrite = false;
		notifyAll();
	}
}
