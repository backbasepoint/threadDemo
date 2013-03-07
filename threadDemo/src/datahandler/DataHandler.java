package datahandler;

/**
 * 不容许：读 写，写 写，写 读；
 * 容许：读读
 * 封装一个类，获得读 写的锁，释放锁。
 */
public class DataHandler {
    private char[] buffer="AAAAAAAAAA".toCharArray();
    private  ReadWriteLock rwl = new ReadWriteLock();
    
    public char[] doRead() throws InterruptedException{
    	rwl.readLock();  //不能放在try中，因为这个方法可能抛出异常，如果放在try中，
    	//当在readingThread++ 之前抛出异常，finally中的readingThread-- 始终会执行。
    	try{
    		int len = buffer.length;
//    		char[] text = new char[len];
    		for(int i=0;i<len;i++){
//    		text[i]=buffer[i];
    			sleep(3);
    		}
    		System.out.println(Thread.currentThread().getName()+" [read] data "+ new String(buffer));
    	}finally{
    		rwl.readReleaseLock();
    	}
    	return buffer;
    }
    
    public void doWrite(char[] data) throws InterruptedException{
    	rwl.writeLock();
    	try{
    		if(null!=data){
    			int len = data.length;
    			for(int i=0;i<len;i++){
    				buffer[i] = data[i];
    				sleep(10);
    			}
    			System.out.println(Thread.currentThread().getName()+" write data "+ new String(data));
    		}
    	}finally{
    		rwl.writeReleaseLock();
    	}
    }
    
    private void sleep(int ms) {
        try {
            Thread.sleep(ms);
        }
        catch(InterruptedException ie) {}
    }
}
