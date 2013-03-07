package datahandler;

/**
 * �������� д��д д��д ����
 * ��������
 * ��װһ���࣬��ö� д�������ͷ�����
 */
public class DataHandler {
    private char[] buffer="AAAAAAAAAA".toCharArray();
    private  ReadWriteLock rwl = new ReadWriteLock();
    
    public char[] doRead() throws InterruptedException{
    	rwl.readLock();  //���ܷ���try�У���Ϊ������������׳��쳣���������try�У�
    	//����readingThread++ ֮ǰ�׳��쳣��finally�е�readingThread-- ʼ�ջ�ִ�С�
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
