package workerpattem;

import workerpattem.impl.task.CalculateTaskImpl;
import workerpattem.impl.task.TaskQueue;
import workerpattem.impl.task.TimerTaskImpl;
import workerpattem.workerThread.ThreadPool;
/**
 * ��Ϣ����
 *�̳߳أ��̳߳����̴߳�����Ϣ�����е���Ϣ
 *�����̳߳أ�����Ϣ���У�
 *����ĵ���ȡ����TaskQueue��getTask���������������������������ȼ���
 *������������ڷ�æ״̬��TaskQueue�Ķ���Խ��Խ�������յ��·������ڴ�ľ���
 *��������TaskQueue�ĵȴ��������������;ܾ���
 */
public class Main {
	public static void main(String[] args) {
		TaskQueue taskQueue = new TaskQueue();
		ThreadPool tp = new ThreadPool(taskQueue);
		
		for(int i=0;i<=5;i++){
			taskQueue.putTask(new TimerTaskImpl());
			taskQueue.putTask(new CalculateTaskImpl());
		}
		tp.addWorker();
		tp.addWorker();
		doSleep(20000);
		tp.currentStatus();
	}
	
	private static void doSleep(long ms) {
		try {
			Thread.sleep(ms);
		}
		catch(InterruptedException ie) {}
	}
}