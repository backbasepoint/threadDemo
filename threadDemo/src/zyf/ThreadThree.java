package zyf;
public class ThreadThree{
	public static void main(String[] args) {
		ThreadThreeSynchronized t1 =new ThreadThreeSynchronized("t1");  //��ʱֻ��������һ�����󣬲�û���¿��߳�
		ThreadThreeSynchronized t2 =new ThreadThreeSynchronized("t2");
		t1.start();  //1    ������¿��߳�
		t1.run();    //2
		//t2.start();//3
		//1+2 ˵�� run()����ʵ����ͬ��,ʵ����û���������õģ�
		//����ֻ��Ϊ��˵�����⣬main�߳� �� t1�߳� ���� run����,ͬһ������t1����run������
		//1+3 ��ͬ�߳� ˵�������߳̿���ͬʱ����run�������t1 �� t2 ��ͬ�����run ����
		//��������δ�����̶߳����start()����������������ô����̶߳���һֱ���ڡ��½���״̬
		//��1.�½� 2.���� 3.���� 4.���� 5.�����ܹ�5��״̬��������ԶҲ������Ϊ�̻߳��ִ�еĻ��ᣬ
		//��ֻ��һ����ͨ��Java���󡣵���������̶߳����run()����ʱ���������ͨJava�������ͨ���������κ�����
		//��˾��Բ�������һ�����̵߳�
	}
}

//�ü̳�ʵ���̵߳Ĳ��õĵط���1�����ܼ̳ж���ࣻ2��ÿһ��������һ���̣߳����������ݹ���
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

