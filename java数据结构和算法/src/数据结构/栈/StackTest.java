package ���ݽṹ.ջ;

import java.util.Scanner;

class Data{
	String name;
	int age;
}

class StackType{
	static final int MAXLEN = 50;
	Data []data = new Data[MAXLEN];
	int top;
	
	//ջ�ĳ�ʼ��
	StackType initStack(){
		StackType s;
		if ((s = new StackType()) != null){
			s.top = 0;
			return s;
		}else{
			return null;
		}
	}
	
	//�ж�ջ�Ƿ�Ϊ��
	boolean isEmpty(StackType s){
		if (s.top == 0){
			return true;
		}
		else{
			return false;
		}
	}
	
	//�ж�ջ�Ƿ�����
	boolean isFull(StackType s){
		if (s.top == MAXLEN){
			return true;
		}
		else{
			return false;
		}
	}
	
	//���ջ
	void clearStack(StackType s){
		s.top = 0;
	}
	
	//�ͷ�ջ��ռ�õĿռ�
	void free(StackType s){
		if (s != null){
			s = null;
		}
	}
	
	//��ջ����
	int push(StackType s, Data data){
		if (s.top > MAXLEN){
			System.out.println("ջ���");
			return 0;
		}
		s.top ++;
		s.data[s.top] = data;
		return 1;
	}
	
	//��ջ����
	Data pop(StackType s){
		if (s.top == 0){
			System.out.println("ջΪ��!");
			return null;
		}
		return s.data[s.top --];
	}
	
	//��ջ������
	Data read(StackType s){
		if (s.top == 0){
			System.out.println("ջΪ��!");
			return null;
		}
		return s.data[s.top --];
	}
	
}

public class StackTest {

	public static void main(String[] args) {
		StackType st = new StackType();
		Data data = new Data();
		
		StackType s = st.initStack();
		System.out.println("ջ�ĳ�ʼ�����....");
		
		Scanner input = new Scanner(System.in);
		System.out.println("��ջ������");
		System.out.println("�������� ���������ջ������");
		do{
			Data data1 = new Data();
			data1.name = input.next();
			if (data1.name.equals("0")){
				break;
			}else{
				data1.age = input.nextInt();
				st.push(s, data1);
			}
		}while(true);
		
		String temp = "1";
		System.out.println("��ջ�������������0�����г�ջ����");
		temp = input.next();
		while(!temp.equals("0")){
			data = st.pop(s);
			if (data == null){
				break;
			}
			System.out.printf("��ջ������ʱ(%s,%d)\n",data.name, data.age);
			temp = input.next();
		}
		System.out.println("���Խ���!");
		st.free(s);
	}

}
