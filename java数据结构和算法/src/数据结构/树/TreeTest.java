package ���ݽṹ.��;

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
	
	//��ʼ���������ĸ�
	BiTreeType init(){
		BiTreeType root;
		if ((root = new BiTreeType()) != null){
			System.out.println("������һ�����ڵ������!");
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
	
	//��ӽڵ�
	void addTreeNode(BiTreeType root){
		BiTreeType pnode, parent;
		String data;
		int menusel;
		
		if((pnode = new BiTreeType()) != null){
			System.out.println("����������ڵ�����");
			pnode.data = input.next();
			pnode.left = null;
			pnode.right = null;
			
			System.out.println("����Ҫ����ĸ��ڵ�����ݣ�");
			data = input.next();
			parent = findTreeNode(root, data);
			if (parent == null){
				System.out.println("�ø��ڵ㲻����!");
				pnode = null;
				return;
			}
			
			System.out.println("����������  1.���������� 2.����������");
			do{
				menusel = input.nextInt();
				if (menusel == 1 || menusel == 2){
					if (parent == null){
						System.out.println("���ڵ㲻����!�������ø��ڵ�");
					}else{
						switch(menusel){
						case 1:
							if (parent.left != null){
								System.out.println("�������ڵ㲻Ϊ��!");
							}else{
								parent.left = pnode;
							}
							break;
						case 2:
							if (parent.right != null){
								System.out.println("�������ڵ㲻Ϊ��!");
							}else{
								parent.right = pnode;
							}
							break;
						default:
							System.out.println("��Ч������");
						}
					}
				}
			}while(menusel != 1 && menusel != 2);
		}
	}
	
	//�������ݲ��ҽڵ�
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
	
	//��ȡ������
	BiTreeType getLeftTree(BiTreeType node){
		if(node.left != null){
			return node.left;
		}else{
			return null;
		}
	}
	
	//��ȡ������
	BiTreeType getRightTree(BiTreeType node){
		if (node.right != null){
			return node.right;
		}else{
			return null;
		}
	}
	
	//�жϿ���
	boolean isEmpty(BiTreeType root){
		if (root != null){
			return true;
		}else{
			return false;
		}
	}
	
	//������������
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
	
	//��ն�����
	void clear(BiTreeType root){
		if (root != null){
			clear(root.left);
			clear(root.right);
			root = null;
		}
	}
	
	//��ʾ�ڵ�����
	void treeNodeData(BiTreeType b){
		System.out.printf(b.data);
	}
	
	//����α���
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
	
	//�������
	void preOrder(BiTreeType b){
		if (b != null){
			treeNodeData(b);
			preOrder(b.left);
			preOrder(b.right);
		}
	}
	
	//�������
	void inOrder(BiTreeType b){
		if (b != null){
			inOrder(b.left);
			treeNodeData(b);
			inOrder(b.right);
		}
	}
	
	//�������
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
		System.out.println("��������ʼ�����......");
		
		//��ӽڵ�
		do{
			System.out.println("��ѡ��˵���Ӷ������ڵ�");
			System.out.println("1.��ӽڵ�   0.�˳�");
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
		
		//�����ڵ�
		do{
			System.out.println("---------------�����������Ľڵ�------------------");
			System.out.printf("1.�������\t");
			System.out.printf("2.�������\t");
			System.out.printf("3.�������\t");
			System.out.printf("4.��α���\t");
			System.out.printf("0.�˳�");
			System.out.println();
			
			menusel = input.nextInt();
			switch(menusel){
				case 1:
					System.out.printf("��������Ľ����");
					treeTest.preOrder(b);
					System.out.println();
					break;
				case 2:
					System.out.println("��������Ľ����");
					treeTest.inOrder(b);
					System.out.println();
					break;
				case 3:
					System.out.println("��������Ľ����");
					treeTest.postOrder(b);
					System.out.println();
					break;
				case 4:
					System.out.println("��α����Ľ����");
					treeTest.levelTraverse(b);
					System.out.println();
					break;
				case 0:
					break;
				default:;
			}
			
		}while(menusel != 0);
		
		//�����������
		System.out.println("�����������Ϊ��" + treeTest.treeDepth(b));
		treeTest.clear(b);
		b = null;
	}
	
}
