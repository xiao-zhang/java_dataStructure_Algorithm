package ���ݽṹ.����;

import java.util.Scanner;

class Data{
	String key;
	String name;
	int age;
}

class LinkedListType{
	Data data = new Data();
	LinkedListType nextNode;
	
	//β��׷�ӽڵ�
	LinkedListType addNodeInTail(LinkedListType head, Data nodeData){
		LinkedListType node,htemp;
		if ((node = new LinkedListType()) == null){
			System.out.println("�����ڴ�ʧ��!");
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
	
	//ͷ��׷�ӽڵ�
	LinkedListType addNodeInHead(LinkedListType head, Data nodeData){
		LinkedListType node,htemp;
		if ((node = new LinkedListType()) != null){
			System.out.println("�����ڴ�ʧ��!");
			return null;
		}else{
			node.data = nodeData;
			node.nextNode = head;
			head = node;
			return head;
		}
	}
	
	//���ҽڵ�
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
	
	//����ڵ�
	LinkedListType insertNode(LinkedListType head, String key, Data nodeData){
		LinkedListType node, nodehtemp;
		
		if ((node = new LinkedListType()) == null){
			System.out.println("�����ڴ�ʧ��!");
			return null;
		}else{
			node.data = nodeData;
			nodehtemp = findNodeByKey(head, key);
			if (nodehtemp != null){
				node.nextNode = nodehtemp.nextNode;
				nodehtemp.nextNode = node;
			}else{
				System.out.println("δ�ҵ���ȷ�Ĳ���λ��!");
				node = null;
			}
			return head;
		}
	}
	
	//ɾ��ָ���Ľڵ�
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
	
	//��������ĳ���
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
	
	//��������
	void traverse(LinkedListType head){
		LinkedListType htemp;
		Data nodeData;
		htemp = head;
		System.out.println("��ǰ������"+calLength(head)+"���ڵ㡣�ڵ���������£�");
		while (htemp != null){
			nodeData = htemp.data;
			System.out.printf("�ڵ�(%s, %s, %d)\n",nodeData.key, nodeData.name, nodeData.age);
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
		System.out.println("������ԡ������������е����ݣ���ʽΪ���ؼ��� ���� ����");
		
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
		
		//�鿴���нڵ�
		lt.traverse(head);
		
		System.out.printf("��ʾ����ڵ㣬�������λ�õĹؼ��֣�");
		findKey = input.next();
		System.out.println("�������ڵ������(�ؼ��� ���� ����)");
		Data nodeData = new Data();
		nodeData.key = input.next();
		nodeData.name = input.next();
		nodeData.age = input.nextInt();
		lt.insertNode(head, findKey, nodeData);
		lt.traverse(head);
		
		System.out.printf("��ʾɾ���ڵ㣬����Ҫɾ���Ĺؼ���:");
		key = input.next();
		if (lt.deleteNodeByKey(head, key) == 0){
			System.out.println("Ҫɾ���Ľڵ㲻����!");
		}
		lt.traverse(head);
		
		System.out.printf("��ʾ�������в��ң�������ҵĹؼ��֣�");
		key = input.next();
		node = lt.findNodeByKey(head, key);
		if (node != null){
			nodeData = node.data;
			System.out.printf("�ؼ���%s��Ӧ�Ľڵ�Ϊ(%s,%s,%d)\n",key, nodeData.key, nodeData.name, nodeData.age);
		}else{
			System.out.printf("δ�ҵ��ؼ���Ϊ%s�ĸýڵ�!\n", key);
		}
	}

}
