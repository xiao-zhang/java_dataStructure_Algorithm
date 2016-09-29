package ���ݽṹ.ͼ;

import java.util.Scanner;

class Graph{
	static final int MAXNUM = 20;
	static final int MAXVALUE = Integer.MAX_VALUE;
	int Gtype;	//ͼ������  0������ͼ  1������ͼ
	int vertexNum;   //��������
	int edgeNum;	//�ߵ�����
	char []vertex = new char[MAXNUM];   //���㼯��
	int [][]edgeWeight = new int[MAXNUM][MAXNUM];	//�ߵļ���
	int []isTraverse = new int[MAXNUM];	//�Ƿ�����ı�־
}
public class GraphTest {
	static final Scanner input = new Scanner(System.in);
	
	//��������ʼ��ͼ
	static void createGraph(Graph G){
		int i,j,k;
		int weight;
		char EstartV,EendV;
		System.out.println("����ͼ�ĸ�������:");
		for (i = 0; i < G.vertexNum; i ++){
			System.out.printf("��%d������:"+(i+1));
			G.vertex[i] = (input.next().toCharArray())[0];
		}
		System.out.println("���빹�ɸ��ߵĶ����Ȩֵ��");
		for (k = 0; k < G.edgeNum; k ++){
			System.out.println("������  ��ʼ����  ��������  Ȩֵ");
			EstartV = (input.next().toCharArray())[0];
			EendV = (input.next().toCharArray())[0];
			weight = input.nextInt();
			for (i = 0; EstartV != G.vertex[i]; i++);
			for (j = 0; EendV != G.vertex[j]; j++);
			G.edgeWeight[i][j] = weight;
			if (G.Gtype == 0){
				G.edgeWeight[j][i] = weight;
			}
		}
	}
	
	//���ͼ
	static void clearGraph(Graph G){
		for (int i = 0; i < G.vertexNum; i++){
			for (int j = 0; j < G.vertexNum; j++){
				G.edgeWeight[i][j] = G.MAXVALUE;
			}
		}
	}
	
	//����ڽӾ���
	static void printGraph(Graph G){
		int i,j;
		for (i = 0; i < G.vertexNum; i++){
			System.out.printf("\t%c",G.vertex[i]);
		}
		System.out.println();
		for (i = 0; i < G.vertexNum; i++){
			System.out.printf("%c", G.vertex[i]);
			for (j = 0; j < G.vertexNum; j ++){
				if (G.edgeWeight[i][j] != G.MAXVALUE){
					System.out.printf("%d\t",G.edgeWeight[i][j]);
				}else{
					System.out.printf("Z\t");
				}
			}
			System.out.println();
		}
	}
	
	//��ȱ���ͼ,�ӵ�n���ڵ㿪ʼ
	static void deepTraOne(Graph G, int n){
		int i;
		G.isTraverse[n] = 1;
		System.out.printf("->%c",G.vertex[n]);
		for (i = 0; i < G.vertexNum; i++){
			if (G.edgeWeight[n][i] != G.MAXVALUE && G.isTraverse[i] == 0){
				deepTraOne(G,i);
			}
		}
	}
	
	//������ȱ���
	static void deepFirstTra(Graph G){
		int i;
		for (i = 0; i < G.vertexNum; i ++){
			G.isTraverse[i] = 0;
		}
		System.out.printf("���������ȱ����Ľڵ�:");
		for (i = 0; i < G.vertexNum; i++){
			if (G.isTraverse[i] == 0){
				deepTraOne(G, i);
			}
		}
		System.out.println();
	}
	
	//������ȱ���
	static void bFirstTra(Graph G, char c){
		int i,j,k;
		int t = -1;
		char []q = new char[G.vertexNum];
		int head = 0;
		int tail = 0;
		for (i = 0; i < G.vertexNum; i ++){
			G.isTraverse[i] = 0;
		}
		for (k = 0; k < G.vertexNum; k++){
			if (c == G.vertex[k]){
				t = k;
			}
		}
		if (t != -1){
			tail = (tail+1)%(G.MAXNUM);
			q[tail] = G.vertex[t];
		}
		while (head != tail){
			head = (head + 1)%(G.MAXNUM);
			G.isTraverse[t] = 1;
			System.out.printf("->%c",q[head]);
			for (j = 0; j < G.vertexNum; j++){
				if (G.edgeWeight[t][j] != G.MAXVALUE && G.isTraverse[j] == 0){
					tail = (tail + 1)%(G.MAXNUM);
					q[tail] = G.vertex[j];
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Graph G = new Graph();
		
		System.out.printf("��������ͼ��ģ�ͣ�");
		G.Gtype = input.nextInt();	//ͼ�����ͣ�0����ͼ��1 ����ͼ
		System.out.println();
		System.out.printf("����ͼ�Ķ����������");
		G.vertexNum = input.nextInt();
		System.out.println();
		System.out.println("����ͼ�ıߵ�������");
		G.edgeNum = input.nextInt();
		
		clearGraph(G);
		createGraph(G);
		System.out.println("ͼ���ڽӾ������£�");
		printGraph(G);
		System.out.println("������ȱ�����");
		deepFirstTra(G);
		System.out.println("������ȱ���:");
		System.out.printf("�������������ʼ�ڵ㣺");
		char c = (input.next().toCharArray())[0];
		bFirstTra(G, c);
	}

}
