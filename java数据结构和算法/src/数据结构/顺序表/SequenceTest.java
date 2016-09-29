package ���ݽṹ.˳���;

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
	
	//��ʼ��˳���
	void SLInit(SLType SL){
		SL.length = 0;
	}
	
	//����˳����е�Ԫ������
	int SLLength(SLType SL){
		return SL.length;
	}
	
	//˳���Ĳ�ֵ
	int SLInsert(SLType SL, int n, Data nodeValue){
		int i;
		if (SL.length >= MAXLEN){
			System.out.println("˳������������ܲ���ڵ�!");
			return 0;
		}
		if (n < 0 || n > SL.length -1){
			System.out.println("����λ�ô��󣬲��ܲ���Ԫ��!");
			return 0;
		}
		for (i = SL.length - 1; i >= n; i--){
			SL.node[i+1] = SL.node[i];
		}
		SL.node[n] = nodeValue;
		SL.length ++;
		return 1;
	}
	
	//��β������Ԫ��
	int SLAdd(SLType SL, Data nodeValue){
		if (SL.length >= MAXLEN){
			System.out.println("˳����������������ӽڵ�!");
			return 0;
		}
		SL.node[SL.length] = nodeValue;
		SL.length ++;
		return 1;
	}
	
	//ɾ������Ԫ��
	int SLDelete(SLType SL, int n){
		int i;
		if (n < 0 || n > SL.length -1){
			System.out.println("ɾ��λ�ô��󣬲���ɾ��Ԫ��!");
			return 0;
		}
		for (i = n; i < SL.length; i ++){
			SL.node[i] = SL.node[i+1];
		}
		SL.length --;
		return 1;
	}
	
	//������ŷ�������Ԫ��
	Data SLFindByNum(SLType SL, int n){
		if (n < 0 || n > SL.length -1){
			System.out.println("�ڵ���Ŵ��󣬲��ܷ��ؽڵ�!");
			return null;
		}
		return SL.node[n];
	}
	
	//���ؼ��ֲ�ѯ�ڵ�
	int SLFindByKey(SLType SL, String key){
		int i;
		for (i = 0; i < SL.length; i ++){
			if (SL.node[i].key.compareTo(key) == 0){
				return i;
			}
		}
		return -1;
	}
	
	//��ʾ˳����е����нڵ�
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
		
		System.out.println("˳��������ʾ!");
		SL.SLInit(SL);
		System.out.println("��ʼ��˳������!");
		
		Scanner input = new Scanner(System.in);
		
		do{
			System.out.print("������ӵĽڵ㣨ѧ�� ���� ���䣩");
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
		System.out.println("˳����еĽڵ�����Ϊ��");
		SL.SLAll(SL);
		
		System.out.print("Ҫȡ���Ľڵ����:");
		i = input.nextInt();
		pnode = SL.SLFindByNum(SL,i);
		if (pnode != null){
			System.out.println("("+SL.node[i].key + ","+SL.node[i].name+","+SL.node[i].age+")");
		}
		
		System.out.print("���Ҫ���ҵĹؼ��ֽڵ�:");
		key = input.next();
		i = SL.SLFindByKey(SL, key);
		pnode = SL.SLFindByNum(SL, i);
		if (pnode != null){
			System.out.printf("��%d���ڵ�Ϊ��(%s,%s,%d)\n",i,pnode.name,pnode.key,pnode.age);
		}else{
			System.out.println("�ýڵ㲻����!");
		}
			
	}
}
