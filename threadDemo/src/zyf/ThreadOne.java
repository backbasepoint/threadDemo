package zyf;
/**
 * 伪多线程
 * @author zhuyufeng
 * 我们的意图是当在while循环中调用sleep()时，
 * 另一个线程就将起动，打印出j的值，但结果却并不是这样。
 * result 将一直打印出i的值。死循环了
 */
public class ThreadOne {
	int i=0,j=0;
	public void go(int flag){
		while(true){
			try{
				Thread.sleep(500);
			}catch (InterruptedException e) {
				System.out.println("Interrupted……Exception……");
			}
			if(flag == 0){
				i++;
				System.out.println("i =  "+i);
			}else{
				j++;
				System.out.println("j =  "+j);
			}
		}
	}
	public static void main(String[] args) {
		new ThreadOne().go(0);
		new ThreadOne().go(1);
	}
}
