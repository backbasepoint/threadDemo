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
	 * wait()和sleep()都可以通过interrupt()方法打断线程的暂停状态，
	 * 从而使线程立刻抛出InterruptedException。
	 * 如果线程A希望立即结束线程B，则可以对线程B对应的Thread实例调用interrupt方法。
	 * 如果此刻线程B正在 wait/sleep/join，则线程B会立刻抛出InterruptedException，
	 * 在catch() {} 中直接return即可安全地结束线程。
	 */

	public void shutdown(){
		stop = true;
		this.interrupt();    //结束ServerThead 线程
		try{
			this.join();
		}catch (InterruptedException  e) {
			System.out.println("interrupted error in class ServerThead……");
		}
	}
}
