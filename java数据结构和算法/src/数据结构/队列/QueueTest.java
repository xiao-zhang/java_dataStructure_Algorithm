package ���ݽṹ.����;

import java.util.Scanner;

class Data{
	String name;
	int age;
}
class QueueType{
	static final int QUEUELEN = 15;
	Data []data = new Data[QUEUELEN];
	int head,tail;
	
	//���еĳ�ʼ��
	QueueType init(){
		QueueType q;
		if ((q = new QueueType()) != null){
			q.head = 0;
			q.tail = 0;
			return q;
		}else{
			return null;
		}
	}
	
	//�жϿն���
	boolean isEmpty(QueueType q){
		if (q.head == q.tail){
			return true;
		}else{
			return false;
		}
	}
	
	//�ж�������
	boolean isFull(QueueType q){
		if (q.tail == QUEUELEN){
			return true;
		}else{
			return false;
		}
	}
	
	//��ն���
	void clear(QueueType q){
		q.head = 0;
		q.tail = 0;
	}
	
	//�ͷŶ���
	void free(QueueType q){
		if (q != null){
			q = null;
		}
	}
	
	//�����
	int enQueue(QueueType q, Data data){
		if(isFull(q)){
			System.out.println("�����������޷����!");
			return 0;
		}
		q.data[q.tail++] = data;
		return 1;
	}
	
	//������
	Data deQueue(QueueType q){
		if (isEmpty(q)){
			System.out.println("������Ϊ��!");
			return null;
		}
		return q.data[q.head++];
		
	}
	
	//���ڵ�����
	Data readData(QueueType q){
		if (isEmpty(q)){
			System.out.println("�ն���");
			return null;
		}else{
			return q.data[head];
		}
	}
	
	//������г���
	int calLength(QueueType q){
		return (q.tail - q.head);
	}
}


public class QueueTest {
	
	public static void main(String[] args) {
		QueueType qt = new QueueType();
		Data data;
		
		Scanner input = new Scanner(System.in);
		
		//��ʼ������
		QueueType q = qt.init();
		System.out.println("���г�ʼ�����.....");
		System.out.println("����в�����");
		System.out.println("�������� ���������Ӳ���");
		do{
			Data inputData = new Data();
			inputData.name = input.next();
			inputData.age = input.nextInt();
			if (inputData.name.equals("0")){
				break;
			}else{
				q.enQueue(q, inputData);
			}
			
		}while(true);
		
		String temp = "1";
		System.out.println("�����в������������0�����г����в���");
		while (!temp.equals("0")){
			data = qt.deQueue(q);
			if (data == null){
				break;
			}
			System.out.printf("�����е�������(%s,%d)\n",data.name, data.age);
			temp = input.next();
		}
		System.out.println("���Խ���!");
		qt.free(q);

	}

}
