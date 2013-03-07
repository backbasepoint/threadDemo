package workerpattem.impl.task;

import workerpattem.task.Task;

public class TimerTaskImpl implements Task {
	private static int count = 0;
    private int num = count;
    public TimerTaskImpl() {
        count++;
    }
    @Override
    public void execute() {
        System.out.println("[TimerTask " + num + "] start "+Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        }
        catch(InterruptedException ie) {}
        System.out.println("[TimerTask " + num + "] done "+Thread.currentThread().getName());
    }
}
