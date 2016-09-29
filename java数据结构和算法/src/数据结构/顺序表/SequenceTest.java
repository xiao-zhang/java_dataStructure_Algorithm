package 数据结构.顺序表;

import java.util.Scanner;

class Data{
	String name;
	String key;
	int age;
}

class SLType{
	static final int MAXLEN = 100;
	Data[] node = new Data[MAXLEN];
	int length;
	
	//初始化顺序表
	void SLInit(SLType SL){
		SL.length = 0;
	}
	
	//返回顺序表中的元素数量
	int SLLength(SLType SL){
		return SL.length;
	}
	
	//顺序表的插值
	int SLInsert(SLType SL, int n, Data nodeValue){
		int i;
		if (SL.length >= MAXLEN){
			System.out.println("顺序表已满，不能插入节点!");
			return 0;
		}
		if (n < 0 || n > SL.length -1){
			System.out.println("插入位置错误，不能插入元素!");
			return 0;
		}
		for (i = SL.length - 1; i >= n; i--){
			SL.node[i+1] = SL.node[i];
		}
		SL.node[n] = nodeValue;
		SL.length ++;
		return 1;
	}
	
	//在尾部增加元素
	int SLAdd(SLType SL, Data nodeValue){
		if (SL.length >= MAXLEN){
			System.out.println("顺序表已满，不能增加节点!");
			return 0;
		}
		SL.node[SL.length] = nodeValue;
		SL.length ++;
		return 1;
	}
	
	//删除数据元素
	int SLDelete(SLType SL, int n){
		int i;
		if (n < 0 || n > SL.length -1){
			System.out.println("删除位置错误，不能删除元素!");
			return 0;
		}
		for (i = n; i < SL.length; i ++){
			SL.node[i] = SL.node[i+1];
		}
		SL.length --;
		return 1;
	}
	
	//根据序号返回数据元素
	Data SLFindByNum(SLType SL, int n){
		if (n < 0 || n > SL.length -1){
			System.out.println("节点序号错误，不能返回节点!");
			return null;
		}
		return SL.node[n];
	}
	
	//按关键字查询节点
	int SLFindByKey(SLType SL, String key){
		int i;
		for (i = 0; i < SL.length; i ++){
			if (SL.node[i].key.compareTo(key) == 0){
				return i;
			}
		}
		return -1;
	}
	
	//显示顺序表中的所有节点
	int SLAll(SLType SL){
		int i;
		for (i = 0; i < SL.length; i ++){
			System.out.println("("+SL.node[i].key + ","+SL.node[i].name+","+SL.node[i].age+")");
		}
		return 0;
	}
	
}

public class SequenceTest {

	public static void main(String[] args) {
		int i;
		SLType SL = new SLType();
		Data pnode;
		String key;
		
		System.out.println("顺序表操作演示!");
		SL.SLInit(SL);
		System.out.println("初始化顺序表完成!");
		
		Scanner input = new Scanner(System.in);
		
		do{
			System.out.print("输入添加的节点（学号 姓名 年龄）");
			Data node = new Data();
			node.key = input.next();
			node.name = input.next();
			node.age = input.nextInt();
			
			if (node.age != 0){
				if (SL.SLAdd(SL, node) == 0){
					break;
				}
			}else{
				break;
			}
			
		}while(true);
		System.out.println("顺序表中的节点数据为：");
		SL.SLAll(SL);
		
		System.out.print("要取出的节点序号:");
		i = input.nextInt();
		pnode = SL.SLFindByNum(SL,i);
		if (pnode != null){
			System.out.println("("+SL.node[i].key + ","+SL.node[i].name+","+SL.node[i].age+")");
		}
		
		System.out.print("输出要查找的关键字节点:");
		key = input.next();
		i = SL.SLFindByKey(SL, key);
		pnode = SL.SLFindByNum(SL, i);
		if (pnode != null){
			System.out.printf("第%d个节点为：(%s,%s,%d)\n",i,pnode.name,pnode.key,pnode.age);
		}else{
			System.out.println("该节点不存在!");
		}
			
	}
}
