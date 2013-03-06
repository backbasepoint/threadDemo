package guardedsuspention;
import java.util.LinkedList;
import java.util.List;

public class Queue {
	   private List<Request> queue = new LinkedList<Request>();

	    public synchronized Request getRequest() {
	        while(queue.size()==0) {  //1
	            try {
	                this.wait();
	            }catch(InterruptedException ie) {
	                return null;
	            }
	        }
	        return (Request)queue.remove(0);
	    }

	    public synchronized void putRequest(Request request) {
	        queue.add(request);
	        this.notifyAll();
	    }
}
/**  
 * 1 处
 * while(queue.size()==0)不能换成if(queue.size()==0)
 * 如果服务器线程有多个（例如Web应用程序有多个线程处理并发请求，这非常普遍），就会造成严重问题
 * 如果多个线程都处于阻塞状态，而此时只有一个request 被add 到queue中
 *同时被 notifyAll  第一个 抢到锁的Thread 把 queue中刚添加的删除了，
 *此时queue为空， 释放锁，第二个 第三个…… 继续wait后的代码执行，此时报
 *数组越界异常java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
 */
