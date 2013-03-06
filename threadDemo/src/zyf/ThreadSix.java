package zyf;
/**
 * 
 * @author zhuyufeng
 * synchronized  ����
 * ��synchronized�ؼ������εķ�������Ϊ���������(static)��̬��������ʵ��������
 * (static)��̬�����ġ����������ӵ����������Ķ����Class����ʵ�������ġ�������this��
 * ӵ����������ĵ�ǰ����ʵ���� ��ô�����λ�����һ����������Ӿ������ˡ� 
 * �������δ����Ч����ȫ��ͬ������BumpThread ==����BumpTest��
 * synchronized(reference){ do this }
 * reference����ָ������ĳ�����������־���ԡ��������ڵĴ��롱ʵʩͬ������
 */
public class ThreadSix implements Runnable{
	static boolean flag = true;
	public static synchronized void test0(){//ͬ���������Ǹ��౾��
		for (int i = 0; i < 10; i++) { 
			System.out.println("test0: " + Thread.currentThread().getName()+ " " + i);
		} 
	} 
	public void test1() { 
	  synchronized (this) {//ͬ����������this�������ø÷�����Java����
	  for (int i = 0; i < 10; i++) { 
		  System.out.println("test1: " + Thread.currentThread().getName()+ " " + i);  
		  }  
	   }  
	}  
	public void test2() { 
		  synchronized (ThreadSix.class) {//ͬ����������ThreadSix�������ø÷�����Java����
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
			//test1();  //1   ��������һ����һ��Ϊclass����һ��Ϊ�鼶���������ܲ���ִ��
			test2();   //2 ͬ���Ҽ�����һ������Ϊclass�������Բ��ܲ���ִ�еõȴ�һ������ͷ������ٽ���ִ�еڶ���
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

