package zyf;
/**
 * @author zhuyufeng
 * 实现多线程并行处理
 *
 */
public class ThreadTwo extends Thread {
	private static int threadCount = 0;
    private int threadNum = ++threadCount;
    private int i = 5;
    public void run(){
    while(true){
	    try{
	    	Thread.sleep(100);
	    }catch(InterruptedException e){
	    	System.out.println("Interrupted……异常……");
	    }
	    System.out.println("Thread " + threadNum + " = " + i);
	    if(--i==0) 
	    	return;
	    }
    }

	public static void main(String[] args) {
		for(int i=0;i<5;i++){
			new ThreadTwo().start();
		}
/**
 * 我们只用new产生Thread对象，并没有用reference来记录所产生的Thread对象。
 * 根据垃圾回收机制，当一个对象没有被reference引用时，它将被回收。
 * 但是垃圾回收机制对Thread对象“不成立”。因为每一个Thread都会进行注册动作，
 * 所以即使我们在产生Thread对象时没有指定一个reference指向这个对象，
 * 实际上也会在某个地方有个指向该对象的reference，所以垃圾回收器无法回收它们。
 */
	}

}
