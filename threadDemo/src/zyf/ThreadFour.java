package zyf;
/**
 * 
 * @author zhuyufeng
 * 通过接口的方法实现线程,
 * 接口的方法一个对象 可以start 多次，也就是所谓的线程池
 *
 */
public class ThreadFour implements Runnable{
	private int i=3;
	public static void main(String[] args) {
		ThreadFour thr = new ThreadFour();
		for(int j=0;j<5;j++){
			//new Thread(thr).start();          //每次都是相同的对象，相同对象的线程run()被同步了。
			new Thread(new ThreadFour()).start(); //每次产生不同的对象，不同对象的线程可同时访问run()
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

