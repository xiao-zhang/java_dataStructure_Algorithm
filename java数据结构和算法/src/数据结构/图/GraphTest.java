package 数据结构.图;

import java.util.Scanner;

class Graph{
	static final int MAXNUM = 20;
	static final int MAXVALUE = Integer.MAX_VALUE;
	int Gtype;	//图的类型  0：有向图  1：无向图
	int vertexNum;   //顶点数量
	int edgeNum;	//边的数量
	char []vertex = new char[MAXNUM];   //顶点集合
	int [][]edgeWeight = new int[MAXNUM][MAXNUM];	//边的集合
	int []isTraverse = new int[MAXNUM];	//是否遍历的标志
}
public class GraphTest {
	static final Scanner input = new Scanner(System.in);
	
	//创建并初始化图
	static void createGraph(Graph G){
		int i,j,k;
		int weight;
		char EstartV,EendV;
		System.out.println("输入图的各个顶点:");
		for (i = 0; i < G.vertexNum; i ++){
			System.out.printf("第%d个顶点:"+(i+1));
			G.vertex[i] = (input.next().toCharArray())[0];
		}
		System.out.println("输入构成各边的顶点的权值：");
		for (k = 0; k < G.edgeNum; k ++){
			System.out.println("请输入  起始顶点  结束顶点  权值");
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
	
	//清空图
	static void clearGraph(Graph G){
		for (int i = 0; i < G.vertexNum; i++){
			for (int j = 0; j < G.vertexNum; j++){
				G.edgeWeight[i][j] = G.MAXVALUE;
			}
		}
	}
	
	//输出邻接矩阵
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
	
	//深度遍历图,从第n个节点开始
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
	
	//深度优先遍历
	static void deepFirstTra(Graph G){
		int i;
		for (i = 0; i < G.vertexNum; i ++){
			G.isTraverse[i] = 0;
		}
		System.out.printf("输出深度优先遍历的节点:");
		for (i = 0; i < G.vertexNum; i++){
			if (G.isTraverse[i] == 0){
				deepTraOne(G, i);
			}
		}
		System.out.println();
	}
	
	//广度优先遍历
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
		
		System.out.printf("输入生成图的模型：");
		G.Gtype = input.nextInt();	//图的类型：0无向图，1 有向图
		System.out.println();
		System.out.printf("输入图的顶点的数量：");
		G.vertexNum = input.nextInt();
		System.out.println();
		System.out.println("输入图的边的数量：");
		G.edgeNum = input.nextInt();
		
		clearGraph(G);
		createGraph(G);
		System.out.println("图的邻接矩阵如下：");
		printGraph(G);
		System.out.println("深度优先遍历：");
		deepFirstTra(G);
		System.out.println("广度优先遍历:");
		System.out.printf("请输入遍历的起始节点：");
		char c = (input.next().toCharArray())[0];
		bFirstTra(G, c);
	}

}
