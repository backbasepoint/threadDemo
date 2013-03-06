package zyf;
public class ThreadThree{
	public static void main(String[] args) {
		ThreadThreeSynchronized t1 =new ThreadThreeSynchronized("t1");  //此时只是生成了一个对象，并没有新开线程
		ThreadThreeSynchronized t2 =new ThreadThreeSynchronized("t2");
		t1.start();  //1    这里才新开线程
		t1.run();    //2
		//t2.start();//3
		//1+2 说明 run()方法实现了同步,实际上没有人这样用的，
		//这里只是为了说明问题，main线程 和 t1线程 竞争 run方法,同一个对象（t1）的run方法；
		//1+3 不同线程 说明两个线程可以同时访问run不会出错。t1 和 t2 不同对象的run 方法
		//如果程序从未调用线程对象的start()方法来启动它，那么这个线程对象将一直处于”新建”状态
		//（1.新建 2.就绪 3.运行 4.阻塞 5.死亡总共5个状态），它永远也不会作为线程获得执行的机会，
		//它只是一个普通的Java对象。当程序调用线程对象的run()方法时，与调用普通Java对象的普通方法并无任何区别，
		//因此绝对不会启动一条新线程的
	}
}

//用继承实现线程的不好的地方，1、不能继承多个类；2、每一个对象都是一个线程，不方便数据共享。
 class ThreadThreeSynchronized extends Thread {
	public ThreadThreeSynchronized(String name){
	    super(name);
    }

    public synchronized void run(){
	    for(int i=0; i<3; i++){
		    System.out.println(Thread.currentThread().getName() + " : " + i);
		    try{
		    Thread.sleep(100);
		    }catch(InterruptedException e){
		    	System.out.println("Interrupted");
		    }
		}
	}
}

