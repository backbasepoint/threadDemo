package zyf;
/**
 * α���߳�
 * @author zhuyufeng
 * ���ǵ���ͼ�ǵ���whileѭ���е���sleep()ʱ��
 * ��һ���߳̾ͽ��𶯣���ӡ��j��ֵ�������ȴ������������
 * result ��һֱ��ӡ��i��ֵ����ѭ����
 */
public class ThreadOne {
	int i=0,j=0;
	public void go(int flag){
		while(true){
			try{
				Thread.sleep(500);
			}catch (InterruptedException e) {
				System.out.println("Interrupted����Exception����");
			}
			if(flag == 0){
				i++;
				System.out.println("i =  "+i);
			}else{
				j++;
				System.out.println("j =  "+j);
			}
		}
	}
	public static void main(String[] args) {
		new ThreadOne().go(0);
		new ThreadOne().go(1);
	}
}
