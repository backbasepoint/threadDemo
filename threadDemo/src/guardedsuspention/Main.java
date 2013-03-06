package guardedsuspention;

public class Main {

	/**
	 * GuardedSuspention模式主要思想
	 * 当条件不满足时，线程等待，直到条件满足时，等待该条件的线程被唤醒。
     * 我们设计一个客户端线程和一个服务器线程，客户端线程不断发送请求给服务器线程，
     * 服务器线程不断处理请求。当请求队列为空时，服务器线程就必须等待，直到客户端发送了请求
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
        	System.out.println("interrupted error in class Main……");
        }
        for(int i=0; i<server.length; i++) {
        	server[i].shutdown();
        }
//        server.shutdown();
    }


}
