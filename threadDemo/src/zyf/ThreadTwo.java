package zyf;
/**
 * @author zhuyufeng
 * ʵ�ֶ��̲߳��д���
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
	    	System.out.println("Interrupted�����쳣����");
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
 * ����ֻ��new����Thread���󣬲�û����reference����¼��������Thread����
 * �����������ջ��ƣ���һ������û�б�reference����ʱ�����������ա�
 * �����������ջ��ƶ�Thread���󡰲�����������Ϊÿһ��Thread�������ע�ᶯ����
 * ���Լ�ʹ�����ڲ���Thread����ʱû��ָ��һ��referenceָ���������
 * ʵ����Ҳ����ĳ���ط��и�ָ��ö����reference�����������������޷��������ǡ�
 */
	}

}
