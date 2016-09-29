package 数据结构.链表;

import java.util.Scanner;

class Data{
	String key;
	String name;
	int age;
}

class LinkedListType{
	Data data = new Data();
	LinkedListType nextNode;
	
	//尾部追加节点
	LinkedListType addNodeInTail(LinkedListType head, Data nodeData){
		LinkedListType node,htemp;
		if ((node = new LinkedListType()) == null){
			System.out.println("申请内存失败!");
			return null;
		}else{
			node.data = nodeData;
			node.nextNode = null;
			if (head == null){
				head = node;
				return head;
			}
			htemp = head;
			while (htemp.nextNode != null){
				htemp = htemp.nextNode;
			}
			htemp.nextNode = node;
			return head;
		}
		
	}
	
	//头部追加节点
	LinkedListType addNodeInHead(LinkedListType head, Data nodeData){
		LinkedListType node,htemp;
		if ((node = new LinkedListType()) != null){
			System.out.println("申请内存失败!");
			return null;
		}else{
			node.data = nodeData;
			node.nextNode = head;
			head = node;
			return head;
		}
	}
	
	//查找节点
	LinkedListType findNodeByKey(LinkedListType head, String key){
		LinkedListType htemp;
		htemp = head;
		while (htemp != null){
			if (htemp.data.key.compareTo(key) == 0){
				return htemp;
			}else{
				htemp = htemp.nextNode;
			}
		}
		return null;
	}
	
	//插入节点
	LinkedListType insertNode(LinkedListType head, String key, Data nodeData){
		LinkedListType node, nodehtemp;
		
		if ((node = new LinkedListType()) == null){
			System.out.println("分配内存失败!");
			return null;
		}else{
			node.data = nodeData;
			nodehtemp = findNodeByKey(head, key);
			if (nodehtemp != null){
				node.nextNode = nodehtemp.nextNode;
				nodehtemp.nextNode = node;
			}else{
				System.out.println("未找到正确的插入位置!");
				node = null;
			}
			return head;
		}
	}
	
	//删除指定的节点
	int deleteNodeByKey(LinkedListType head, String key){
		LinkedListType node, htemp;
		node = head;
		htemp = head;
		while (htemp != null){
			if (htemp.data.key.compareTo(key) == 0){
				node.nextNode = htemp.nextNode;
				htemp = null;
				return 1;
			}else{
				node = htemp;
				htemp = htemp.nextNode;
			}
		}
		return 0;
	}
	
	//计算链表的长度
	int calLength(LinkedListType head){
		LinkedListType htemp;
		htemp = head;
		int len = 0;
		while (htemp != null){
			len ++;
			htemp = htemp.nextNode;
		}
		return len;
	}
	
	//遍历链表
	void traverse(LinkedListType head){
		LinkedListType htemp;
		Data nodeData;
		htemp = head;
		System.out.println("当前链表共有"+calLength(head)+"个节点。节点的数据如下：");
		while (htemp != null){
			nodeData = htemp.data;
			System.out.printf("节点(%s, %s, %d)\n",nodeData.key, nodeData.name, nodeData.age);
			htemp = htemp.nextNode;
		}
	}
}

public class LinkedListTest {

	public static void main(String[] args) {
		LinkedListType node, head = null;
		LinkedListType lt = new LinkedListType();
		String key, findKey;
		Scanner input = new Scanner(System.in);
		System.out.println("链表测试。请输入链表中的数据，格式为：关键字 姓名 年龄");
		
		do{
			Data nodeData = new Data();
			nodeData.key = input.next();
			if (nodeData.key.equals("0")){
				break;
			}else{
				nodeData.name = input.next();
				nodeData.age = input.nextInt();
				head = lt.addNodeInTail(head, nodeData);
			}
		}while(true);
		
		//查看所有节点
		lt.traverse(head);
		
		System.out.printf("演示插入节点，输入插入位置的关键字：");
		findKey = input.next();
		System.out.println("输入插入节点的数据(关键字 姓名 年龄)");
		Data nodeData = new Data();
		nodeData.key = input.next();
		nodeData.name = input.next();
		nodeData.age = input.nextInt();
		lt.insertNode(head, findKey, nodeData);
		lt.traverse(head);
		
		System.out.printf("演示删除节点，输入要删除的关键字:");
		key = input.next();
		if (lt.deleteNodeByKey(head, key) == 0){
			System.out.println("要删除的节点不存在!");
		}
		lt.traverse(head);
		
		System.out.printf("演示在链表中查找，输入查找的关键字：");
		key = input.next();
		node = lt.findNodeByKey(head, key);
		if (node != null){
			nodeData = node.data;
			System.out.printf("关键字%s对应的节点为(%s,%s,%d)\n",key, nodeData.key, nodeData.name, nodeData.age);
		}else{
			System.out.printf("未找到关键字为%s的该节点!\n", key);
		}
	}

}
