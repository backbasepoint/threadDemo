package workerpattem.impl.task;

import workerpattem.task.Task;

public class CalculateTaskImpl implements Task {
	private static int count = 0;
	private int num = count;
	public CalculateTaskImpl() {
		count++;
	}

	@Override
    public void execute() {
        System.out.println("[CalculateTask " + num + "] start by  "+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        }
        catch(InterruptedException ie) {}
        System.out.println("[CalculateTask " + num + "] done by  "+Thread.currentThread().getName());
    }
}
