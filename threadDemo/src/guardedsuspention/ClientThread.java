package guardedsuspention;

public class ClientThread extends Thread {
    private Queue queue;
    private String clientName;

    public ClientThread(Queue queue, String clientName) {
        this.queue = queue;
        this.clientName = clientName;
    }

	@Override
	public void run() {
		for(int i=0;i<2;i++){
			Request res = new Request(""+(long)(Math.random()*10000));
			queue.putRequest(res);
			System.out.println("¡¾ClientThread_"+ clientName +"¡¿ send request  "+ res.toString());
		}
	}

}
