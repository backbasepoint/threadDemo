package guardedsuspention;

public class Main {

	/**
	 * GuardedSuspentionģʽ��Ҫ˼��
	 * ������������ʱ���̵߳ȴ���ֱ����������ʱ���ȴ����������̱߳����ѡ�
     * �������һ���ͻ����̺߳�һ���������̣߳��ͻ����̲߳��Ϸ���������������̣߳�
     * �������̲߳��ϴ������󡣵��������Ϊ��ʱ���������߳̾ͱ���ȴ���ֱ���ͻ��˷���������
	 */
	public static void main(String[] args) {
		Queue queue = new Queue();
		ServerThead[] server = new ServerThead[2];
		for(int i=0; i<server.length; i++) {
			server[i]=new  ServerThead(queue);
			server[i].start();
		}
//		ServerThead server=new  ServerThead(queue);
//		server.start();
        ClientThread[] clients = new ClientThread[5];
        for(int i=0; i<clients.length; i++) {
            clients[i] = new ClientThread(queue, ""+i);
            clients[i].start();
        }
        try {
            Thread.sleep(10000);
        }catch(InterruptedException ie) {
        	System.out.println("interrupted error in class Main����");
        }
        for(int i=0; i<server.length; i++) {
        	server[i].shutdown();
        }
//        server.shutdown();
    }


}
