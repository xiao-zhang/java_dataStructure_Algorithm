package 数据结构.树;

import java.util.Scanner;

/*class Data{
	String key;
	String name;
}*/

class BiTreeType{
	String data;
	BiTreeType left;
	BiTreeType right;
}

public class TreeTest {
	static final int MAXLEN = 20;
	static Scanner input = new Scanner(System.in);
	
	//初始化二叉树的跟
	BiTreeType init(){
		BiTreeType root;
		if ((root = new BiTreeType()) != null){
			System.out.println("请输入一个根节点的数据!");
			root.data = input.next();
			root.left = null;
			root.right = null;
			if (root != null){
				return root;
			}else{
				return null;
			}
		}
		return null;
	}
	
	//添加节点
	void addTreeNode(BiTreeType root){
		BiTreeType pnode, parent;
		String data;
		int menusel;
		
		if((pnode = new BiTreeType()) != null){
			System.out.println("输入二叉树节点数据");
			pnode.data = input.next();
			pnode.left = null;
			pnode.right = null;
			
			System.out.println("输入要插入的父节点的数据：");
			data = input.next();
			parent = findTreeNode(root, data);
			if (parent == null){
				System.out.println("该父节点不存在!");
				pnode = null;
				return;
			}
			
			System.out.println("请输入数字  1.插入左子树 2.插入右子树");
			do{
				menusel = input.nextInt();
				if (menusel == 1 || menusel == 2){
					if (parent == null){
						System.out.println("父节点不存在!请先设置父节点");
					}else{
						switch(menusel){
						case 1:
							if (parent.left != null){
								System.out.println("左子树节点不为空!");
							}else{
								parent.left = pnode;
							}
							break;
						case 2:
							if (parent.right != null){
								System.out.println("右子树节点不为空!");
							}else{
								parent.right = pnode;
							}
							break;
						default:
							System.out.println("无效参数！");
						}
					}
				}
			}while(menusel != 1 && menusel != 2);
		}
	}
	
	//根据数据查找节点
	BiTreeType findTreeNode(BiTreeType root, String data){
		BiTreeType ptr;
		if (root == null){
			return null;
		}else{
			if (root.data.equals(data)){
				return root;
			}
			else{
				if ((ptr = findTreeNode(root.left, data)) != null){
					return ptr;
				}else if ((ptr = findTreeNode(root.right, data)) != null){
					return ptr;
				}else{
					return null;
				}
			}
		}
	}
	
	//获取左子树
	BiTreeType getLeftTree(BiTreeType node){
		if(node.left != null){
			return node.left;
		}else{
			return null;
		}
	}
	
	//获取右子树
	BiTreeType getRightTree(BiTreeType node){
		if (node.right != null){
			return node.right;
		}else{
			return null;
		}
	}
	
	//判断空树
	boolean isEmpty(BiTreeType root){
		if (root != null){
			return true;
		}else{
			return false;
		}
	}
	
	//计算二叉树深度
	int treeDepth(BiTreeType root){
		int depleft,depright;
		if (root == null){
			return 0;
		}
		else{
			depleft = treeDepth(root.left);
			depright = treeDepth(root.right);
			
			if (depleft > depright){
				return depleft + 1;
			}
			else{
				return depright + 1;
			}
		}
	}
	
	//清空二叉树
	void clear(BiTreeType root){
		if (root != null){
			clear(root.left);
			clear(root.right);
			root = null;
		}
	}
	
	//显示节点数据
	void treeNodeData(BiTreeType b){
		System.out.printf(b.data);
	}
	
	//按层次遍历
	void levelTraverse(BiTreeType root){
		BiTreeType p;
		BiTreeType []q = new BiTreeType[MAXLEN];
		int head = 0, tail = 0;
		
		if (root != null){
			tail = (tail + 1)%MAXLEN;
			q[tail] = root;
		}
		while(head != tail){
			head = (head + 1)%MAXLEN;
			p = q[head];
			treeNodeData(p);
			if (p.left != null){
				tail = (tail + 1)%MAXLEN;
				q[tail] = p.left;
			}
			if (p.right != null){
				tail = (tail + 1)%MAXLEN;
				q[tail] = p.right;
			}
		}
		
	}
	
	//先序遍历
	void preOrder(BiTreeType b){
		if (b != null){
			treeNodeData(b);
			preOrder(b.left);
			preOrder(b.right);
		}
	}
	
	//中序遍历
	void inOrder(BiTreeType b){
		if (b != null){
			inOrder(b.left);
			treeNodeData(b);
			inOrder(b.right);
		}
	}
	
	//后序遍历
	void postOrder(BiTreeType b){
		if (b != null){
			postOrder(b.left);
			postOrder(b.right);
			treeNodeData(b);
		}
	}
	
	public static void main(String[] args) {
		TreeTest treeTest = new TreeTest();
		BiTreeType b = null;
		int menusel;
		
		b = treeTest.init();
		System.out.println("二叉树初始化完成......");
		
		//添加节点
		do{
			System.out.println("请选择菜单添加二叉树节点");
			System.out.println("1.添加节点   0.退出");
			menusel = input.nextInt();
			
			switch(menusel){
				case 1:
					treeTest.addTreeNode(b);
					break;
				case 0:
					break;
				default:;
			}
		}while(menusel != 0);
		
		//遍历节点
		do{
			System.out.println("---------------遍历二叉树的节点------------------");
			System.out.printf("1.先序遍历\t");
			System.out.printf("2.中序遍历\t");
			System.out.printf("3.后序遍历\t");
			System.out.printf("4.层次遍历\t");
			System.out.printf("0.退出");
			System.out.println();
			
			menusel = input.nextInt();
			switch(menusel){
				case 1:
					System.out.printf("先序遍历的结果：");
					treeTest.preOrder(b);
					System.out.println();
					break;
				case 2:
					System.out.println("中序遍历的结果：");
					treeTest.inOrder(b);
					System.out.println();
					break;
				case 3:
					System.out.println("后序遍历的结果：");
					treeTest.postOrder(b);
					System.out.println();
					break;
				case 4:
					System.out.println("层次遍历的结果：");
					treeTest.levelTraverse(b);
					System.out.println();
					break;
				case 0:
					break;
				default:;
			}
			
		}while(menusel != 0);
		
		//二叉树的深度
		System.out.println("二叉树的深度为：" + treeTest.treeDepth(b));
		treeTest.clear(b);
		b = null;
	}
	
}
