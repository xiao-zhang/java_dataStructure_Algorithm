package 数据结构.栈;

import java.util.Scanner;

class Data{
	String name;
	int age;
}

class StackType{
	static final int MAXLEN = 50;
	Data []data = new Data[MAXLEN];
	int top;
	
	//栈的初始化
	StackType initStack(){
		StackType s;
		if ((s = new StackType()) != null){
			s.top = 0;
			return s;
		}else{
			return null;
		}
	}
	
	//判断栈是否为空
	boolean isEmpty(StackType s){
		if (s.top == 0){
			return true;
		}
		else{
			return false;
		}
	}
	
	//判断栈是否已满
	boolean isFull(StackType s){
		if (s.top == MAXLEN){
			return true;
		}
		else{
			return false;
		}
	}
	
	//清空栈
	void clearStack(StackType s){
		s.top = 0;
	}
	
	//释放栈所占用的空间
	void free(StackType s){
		if (s != null){
			s = null;
		}
	}
	
	//入栈操作
	int push(StackType s, Data data){
		if (s.top > MAXLEN){
			System.out.println("栈溢出");
			return 0;
		}
		s.top ++;
		s.data[s.top] = data;
		return 1;
	}
	
	//出栈操作
	Data pop(StackType s){
		if (s.top == 0){
			System.out.println("栈为空!");
			return null;
		}
		return s.data[s.top --];
	}
	
	//读栈顶数据
	Data read(StackType s){
		if (s.top == 0){
			System.out.println("栈为空!");
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
		System.out.println("栈的初始化完成....");
		
		Scanner input = new Scanner(System.in);
		System.out.println("入栈操作：");
		System.out.println("输入姓名 年龄进行入栈操作：");
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
		System.out.println("出栈操作：按任意非0键进行出栈操作");
		temp = input.next();
		while(!temp.equals("0")){
			data = st.pop(s);
			if (data == null){
				break;
			}
			System.out.printf("出栈的数据时(%s,%d)\n",data.name, data.age);
			temp = input.next();
		}
		System.out.println("测试结束!");
		st.free(s);
	}

}
