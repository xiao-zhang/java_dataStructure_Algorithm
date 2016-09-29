package 数据结构.队列;

import java.util.Scanner;

class Data{
	String name;
	int age;
}
class QueueType{
	static final int QUEUELEN = 15;
	Data []data = new Data[QUEUELEN];
	int head,tail;
	
	//队列的初始化
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
	
	//判断空队列
	boolean isEmpty(QueueType q){
		if (q.head == q.tail){
			return true;
		}else{
			return false;
		}
	}
	
	//判断满队列
	boolean isFull(QueueType q){
		if (q.tail == QUEUELEN){
			return true;
		}else{
			return false;
		}
	}
	
	//清空队列
	void clear(QueueType q){
		q.head = 0;
		q.tail = 0;
	}
	
	//释放队列
	void free(QueueType q){
		if (q != null){
			q = null;
		}
	}
	
	//入队列
	int enQueue(QueueType q, Data data){
		if(isFull(q)){
			System.out.println("队列已满，无法入队!");
			return 0;
		}
		q.data[q.tail++] = data;
		return 1;
	}
	
	//出队列
	Data deQueue(QueueType q){
		if (isEmpty(q)){
			System.out.println("队列已为空!");
			return null;
		}
		return q.data[q.head++];
		
	}
	
	//读节点数据
	Data readData(QueueType q){
		if (isEmpty(q)){
			System.out.println("空队列");
			return null;
		}else{
			return q.data[head];
		}
	}
	
	//计算队列长度
	int calLength(QueueType q){
		return (q.tail - q.head);
	}
}


public class QueueTest {
	
	public static void main(String[] args) {
		QueueType qt = new QueueType();
		Data data;
		
		Scanner input = new Scanner(System.in);
		
		//初始化队列
		QueueType q = qt.init();
		System.out.println("队列初始化完成.....");
		System.out.println("入队列操作：");
		System.out.println("输入姓名 年龄进行入队操作");
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
		System.out.println("出队列操作，按任意非0键进行出队列操作");
		while (!temp.equals("0")){
			data = qt.deQueue(q);
			if (data == null){
				break;
			}
			System.out.printf("出队列的数据是(%s,%d)\n",data.name, data.age);
			temp = input.next();
		}
		System.out.println("测试结束!");
		qt.free(q);

	}

}
