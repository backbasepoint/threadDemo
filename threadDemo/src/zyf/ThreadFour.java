package zyf;
/**
 * 
 * @author zhuyufeng
 * ͨ���ӿڵķ���ʵ���߳�,
 * �ӿڵķ���һ������ ����start ��Σ�Ҳ������ν���̳߳�
 *
 */
public class ThreadFour implements Runnable{
	private int i=3;
	public static void main(String[] args) {
		ThreadFour thr = new ThreadFour();
		for(int j=0;j<5;j++){
			//new Thread(thr).start();          //ÿ�ζ�����ͬ�Ķ�����ͬ������߳�run()��ͬ���ˡ�
			new Thread(new ThreadFour()).start(); //ÿ�β�����ͬ�Ķ��󣬲�ͬ������߳̿�ͬʱ����run()
		}
	}

	@Override
	public synchronized void run() {
		sta();
	}
	public void sta(){
		while(true){
			System.out.println(Thread.currentThread().getName() + " : " + i);
			try{
				Thread.sleep(100);
				if(--i<=0)return;
			}catch(InterruptedException e){
				System.out.println("Interrupted");
			}
		}
	}
}

