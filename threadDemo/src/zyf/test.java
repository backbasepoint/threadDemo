package zyf;

public class test {
	private boolean i=false;
	static sut st= new sut();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new get1Th(st).start(); 
		new get2Th(st).start(); 
		
	}
}

class get1Th extends Thread{
	private sut st;
	public get1Th(sut st){
		this.st = st;
	}
	@Override
	public void run() {
		for(int i=0;i<=5;i++){
			st.get1();
		}
	}
}

class get2Th extends Thread{
	private sut st;
	public get2Th(sut st){
		this.st = st;
	}
	@Override
	public void run() {
		for(int i=0;i<=5;i++){
			st.get2();
		}
	}
}

class sut{
	public synchronized void get1(){
		System.out.println(Thread.currentThread().getName()+ " get 111.....");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void get2(){
		System.out.println(Thread.currentThread().getName()+ " get 222 .....");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
