package guardedsuspention;

public class ServerThead extends Thread {
	private Queue queue=null;
	private boolean stop = false;
	public ServerThead(Queue queue){
		this.queue = queue;
	}
	@Override
	public void run(){
		while(!stop){
			System.out.println("\t\t\t\t[ServerThead]  handle request "+queue.getRequest());
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/**
	 * wait()��sleep()������ͨ��interrupt()��������̵߳���ͣ״̬��
	 * �Ӷ�ʹ�߳������׳�InterruptedException��
	 * ����߳�Aϣ�����������߳�B������Զ��߳�B��Ӧ��Threadʵ������interrupt������
	 * ����˿��߳�B���� wait/sleep/join�����߳�B�������׳�InterruptedException��
	 * ��catch() {} ��ֱ��return���ɰ�ȫ�ؽ����̡߳�
	 */

	public void shutdown(){
		stop = true;
		this.interrupt();    //����ServerThead �߳�
		try{
			this.join();
		}catch (InterruptedException  e) {
			System.out.println("interrupted error in class ServerThead����");
		}
	}
}
