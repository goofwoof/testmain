package DailyTest;

import java.util.Arrays;
import java.util.Scanner;

/*题目描述
给满出二叉树，编写算法将其转化为求和树

什么是求和树：二叉树的求和树， 是一颗同样结构的二叉树，其树中的每个节点将包含原始树中的左子树和右子树的和。

二叉树：
                  10
               /      \
             -2        6
           /   \      /  \ 
          8    -4    7    5

求和树：
                 20(4-2+12+6)
               /      \
           4(8-4)      12(7+5)
            /   \      /  \ 
          0      0    0    0

二叉树给出前序和中序输入，求和树要求中序输出；
所有处理数据不会大于int；

输入描述:
2行整数，第1行表示二叉树的前序遍历，第2行表示二叉树的中序遍历，以空格分割
输出描述:
1行整数，表示求和树的中序遍历，以空格分割
示例1
输入
复制
10 -2 8 -4 6 7 5
8 -2 -4 10 7 6 5
输出
复制
0 4 0 20 0 12 0*/

public class D_8_29_02 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
        String line1 = sc.nextLine();
        String line2 = sc.nextLine();
        String[] p  = line1.split(" ");
        int[] apple = new int[p.length];
        int[] appll = new int[p.length];
        for(int i = 0;i<p.length;i++) {
        	apple[i]=Integer.parseInt(p[i]);
        	appll[i]=Integer.parseInt(p[i]);
        }
        String[] q  = line2.split(" ");
        int[] tree = new int[q.length];
        for(int i = 0;i<q.length;i++) {
        	tree[i]=Integer.parseInt(q[i]);
        }
        sc.close();
        caculate(apple,tree,0);
        show(appll,apple,tree,0);
	}

	private static void show(int[] appll,int[] apple,int[] tree, int i) {
		// TODO Auto-generated method stub
		if(tree.length ==0)return;
		if(tree.length==1) {
			System.out.print(apple[i]+" ");
		}
		else {
			int flag = 0;
			while(tree[flag]!=appll[i])
				flag++;
			
			int[] left = new int[flag];
			for(int i1=0;i1<flag;i1++)
				left[i1]=tree[i1];
			show(appll,apple,left,i+1);
			System.out.print(apple[i]+" ");
			int[] right = new int[tree.length-flag-1];
			for(int i1=0;i1<tree.length-flag-1;i1++)
				right[i1]=tree[flag+1+i1];
	        show(appll,apple,right,i+1+flag);
		}
	}

	private static int caculate(int[] apple,int[] tree, int i) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		System.out.println(i);
		System.out.println(Arrays.toString(apple));
		System.out.println(Arrays.toString(tree));
		if(tree.length ==0)return 0;
		int result = apple[i];
		if(tree.length==1) {
			apple[i]=0;
			return result;
		}
		else {
			int flag = 0;
			while(tree[flag]!=apple[i])
				flag++;
			int[] left = new int[flag];
			for(int i1=0;i1<flag;i1++)
				left[i1]=tree[i1];
			int[] right = new int[tree.length-flag-1];
			for(int i1=0;i1<tree.length-flag-1;i1++)
				right[i1]=tree[flag+1+i1];
			apple[i] = caculate(apple,left,i+1);
	        apple[i] += caculate(apple,right,i+1+flag);
	        return apple[i]+result;
		}
	}
}
class D2{
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
        String line1 = sc.nextLine();
        String line2 = sc.nextLine();
        if(line1.length()<1) {
        	sc.close();
        	return;
        }
        String[] p  = line1.split(" ");
        if(p.length==0) {
        	sc.close();
        	return;
        }
        int[] apple = new int[p.length];
        for(int i = 0;i<p.length;i++) {
        	apple[i]=Integer.parseInt(p[i]);
        }
        sc.close();
        caculate(apple,0,apple.length);
        show(apple,0,apple.length);
	}

	private static void show(int[] apple, int i, int j) {
		// TODO Auto-generated method stub
		if(j==1) {
			System.out.print(apple[i]+" ");
		}
		else {
			show(apple,i+1,j/2);
			System.out.print(apple[i]+" ");
	        show(apple,i+1+j/2,j/2);
		}
	}

	private static int caculate(int[] apple, int i, int j) {
		// TODO Auto-generated method stub
		int result = apple[i];
		if(j==1) {
			apple[i]=0;
			return result;
		}
		else {
			apple[i] = caculate(apple,i+1,j/2);
	        apple[i] += caculate(apple,i+1+j/2,j-j/2);
	        return apple[i]+result;
		}
	}
}
