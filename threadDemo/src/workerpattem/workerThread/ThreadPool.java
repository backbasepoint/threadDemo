package workerpattem.workerThread;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import workerpattem.impl.task.TaskQueue;

public class ThreadPool {
	private List<WorkerThread> threadList = new LinkedList<WorkerThread>();
	private TaskQueue taskQueue = null;
	private static int i=0;
	
	public ThreadPool(TaskQueue taskQueue) {
		this.taskQueue = taskQueue;
	}
	
	public synchronized void addWorker(){
		WorkerThread t = new WorkerThread(i++,taskQueue);
		threadList.add(t);
		t.start();
	}
	
	public synchronized void removeWorker(){
		WorkerThread t = threadList.remove(0);
		t.shutDown();
	}
	
	public synchronized void currentStatus() {
        System.out.println("-----------------------------------------------");
        System.out.println("Thread count = " + threadList.size());
        Iterator it = threadList.iterator();
        while(it.hasNext()) {
            WorkerThread t = (WorkerThread)it.next();
            System.out.println(t.getName() + ": " + (t.isIdle() ? "idle" : "busy"));
        }
        System.out.println("-----------------------------------------------");
    }


}
