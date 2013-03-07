package workerpattem.workerThread;

import workerpattem.impl.task.TaskQueue;
import workerpattem.task.Task;

public class WorkerThread extends Thread {
	private TaskQueue tq =null;
	private boolean busy = false;
	private boolean stop = false;
	public WorkerThread(int i,TaskQueue taskQueue){
		super("[Thread_zhu_"+i);
		this.tq = taskQueue;
	}
	
	@Override
	public void run() {
		System.out.println(getName() + "  start**********");
		while(!stop){
			Task task = tq.getTask();
			if(null!=task){
				busy=true;
				task.execute();
				busy = false;
			}
		}
		System.out.println(getName() +"  end .***********");
	}
	
	public boolean isIdle(){
		return !busy;
	}
	
	public void shutDown(){
		stop = true;
		this.interrupt();
		try {
			this.join();
		} catch (InterruptedException e) {}
	}
}
/**
* ���� �������  ������У�������
* ����˴��������̳߳������̣߳�
* �̳߳ط��߳�
*
**/