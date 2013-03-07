package workerpattem;

import workerpattem.impl.task.CalculateTaskImpl;
import workerpattem.impl.task.TaskQueue;
import workerpattem.impl.task.TimerTaskImpl;
import workerpattem.workerThread.ThreadPool;
/**
 * 消息队列
 *线程池，线程池中线程处理消息队列中的消息
 *创建线程池（传消息队列）
 *任务的调度取决于TaskQueue的getTask方法，可以在这里设计任务的优先级。
 *如果服务器处于繁忙状态，TaskQueue的队列越来越长，最终导致服务器内存耗尽，
 *可以限制TaskQueue的等待任务数，超过就拒绝。
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