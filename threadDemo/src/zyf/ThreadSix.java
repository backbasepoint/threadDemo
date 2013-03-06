package zyf;
/**
 * 
 * @author zhuyufeng
 * synchronized  介绍
 * 用synchronized关键字修饰的方法，分为两种情况：(static)静态方法，和实例方法。
 * (static)静态方法的“锁”是这个拥有这个方法的对象的Class对象；实例方法的“锁”是this，
 * 拥有这个方法的当前对象实例。 怎么理解这段话，看一看下面的例子就明白了。 
 * 下面两段代码的效果完全相同。代码BumpThread ==代码BumpTest。
 * synchronized(reference){ do this }
 * reference用来指定“以某个对象的锁标志”对“大括号内的代码”实施同步控制
 */
public class ThreadSix implements Runnable{
	static boolean flag = true;
	public static synchronized void test0(){//同步监视器是该类本身
		for (int i = 0; i < 10; i++) { 
			System.out.println("test0: " + Thread.currentThread().getName()+ " " + i);
		} 
	} 
	public void test1() { 
	  synchronized (this) {//同步监视器是this，即调用该方法的Java对象。
	  for (int i = 0; i < 10; i++) { 
		  System.out.println("test1: " + Thread.currentThread().getName()+ " " + i);  
		  }  
	   }  
	}  
	public void test2() { 
		  synchronized (ThreadSix.class) {//同步监视器是ThreadSix，即调用该方法的Java对象。
		  for (int i = 0; i < 10; i++) { 
			  System.out.println("test1: " + Thread.currentThread().getName()+ " " + i);  
			  }  
		   }  
		}  
	@Override
	public void run() {
		if(flag){
			flag = false;
			test0();
		}else{
			flag = true;
			//test1();  //1   监视锁不一样，一个为class锁，一个为块级锁，所以能并行执行
			test2();   //2 同步且监视锁一样，都为class锁，所以不能并行执行得等待一个完成释放锁，再接着执行第二个
		}
	}
	public static void main(String[] args) {
		ThreadSix ts = new ThreadSix();
		new Thread(ts).start();  
		new Thread(ts).start();
		
	}
	
}

 class BumpThread{
	int count; 
	synchronized void bump(){
		count++; 
	} 
	static int classCount; 
	static synchronized void classBump() { 
		classCount++; 
	}
}

class BumpTest{
	int count; 
	void bump(){
		synchronized(this){
			count++; 
			}
		} 
	static int classCount;
	static void classBump(){ 
		try { 
			synchronized (Class.forName("BumpTest")) { classCount++; } 
		}catch(ClassNotFoundException e) {} 
		} 
	}

