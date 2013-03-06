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
 * 1 ��
 * while(queue.size()==0)���ܻ���if(queue.size()==0)
 * ����������߳��ж��������WebӦ�ó����ж���̴߳�����������ǳ��ձ飩���ͻ������������
 * �������̶߳���������״̬������ʱֻ��һ��request ��add ��queue��
 *ͬʱ�� notifyAll  ��һ�� ��������Thread �� queue�и���ӵ�ɾ���ˣ�
 *��ʱqueueΪ�գ� �ͷ������ڶ��� ���������� ����wait��Ĵ���ִ�У���ʱ��
 *����Խ���쳣java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
 */
