package zyf;
/**
 * @author zhuyufeng
 * ���̷߳��ʾ�̬����
 * 
 *
 */
public class ThreadFive extends Thread{
	public static void main(String[] args) {
//		ThreadFive t1 = new ThreadFive();
//		ThreadFive t2 = new ThreadFive();
//			t1.start();
//			t1.sta();
//			t2.sta();
		Tf tf= new Tf();
		for(int i=0;i<2;i++){
			new Thread(tf).start();  //run �����Σ�����run �ڶ���ı�������Ҫͬ����û���߳�ͬʱ���ʡ�
		}
		//while(true){
			//Thread.currentThread().notifyAll();
		//}
	}

	@Override
	public synchronized void run() {
		for(int i=0;i<10;i++){
			System.out.println(Thread.currentThread().getName() + " : " + i);
			try{
				Thread.sleep(100);
			}catch(InterruptedException e){
				System.out.println("Interrupted");
			}
		}
	}
	public synchronized static void sta(){
		for(int i=90;i<100;i++){
			System.out.println(Thread.currentThread().getName() + " : " + i);
			try{
				Thread.sleep(100);
			}catch(InterruptedException e){
				System.out.println("Interrupted");
			}
		}
	}
	static class Tf implements Runnable {
		int j=0;
		@Override
		public  void run() {
			for(int i=0;i<=10;i++){
				synchronized(this){
					System.out.println(Thread.currentThread().getName()+ " j  =   "+ j++);
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
		
	}
}