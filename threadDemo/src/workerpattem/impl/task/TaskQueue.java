package workerpattem.impl.task;

import java.util.LinkedList;
import java.util.List;

import workerpattem.task.Task;

public class TaskQueue {
	private List<Task> taskQueue = new LinkedList<Task>();
	//ConcurrentLinkedQueue�̰߳�ȫ LinkedList �̲߳���ȫ
	
	public synchronized Task getTask(){
		while(0==taskQueue.size()){
			try {
				this.wait();
			} catch (InterruptedException e) {
				return null;
			}
		}
		return (Task)taskQueue.remove(0);
	}
	
	public synchronized void putTask(Task task){
		taskQueue.add(task);
		this.notifyAll();
	}
}
