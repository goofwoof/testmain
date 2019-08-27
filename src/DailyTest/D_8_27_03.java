package DailyTest;

/*
题目描述
小易有一些立方体，每个立方体的边长为1，他用这些立方体搭了一些塔。
现在小易定义：这些塔的不稳定值为它们之中最高的塔与最低的塔的高度差。
小易想让这些塔尽量稳定，所以他进行了如下操作：每次从某座塔上取下一块立方体，并把它放到另一座塔上。
注意，小易不会把立方体放到它原本的那座塔上，因为他认为这样毫无意义。
现在小易想要知道，他进行了不超过k次操作之后，不稳定值最小是多少。
输入描述:
第一行两个数n,k (1 <= n <= 100, 0 <= k <= 1000)表示塔的数量以及最多操作的次数。
第二行n个数，ai(1 <= ai <= 104)表示第i座塔的初始高度。
输出描述:
第一行两个数s, m，表示最小的不稳定值和操作次数(m <= k)
接下来m行，每行两个数x,y表示从第x座塔上取下一块立方体放到第y座塔上。
示例1
输入
复制
3 2
5 8 5
输出
复制
0 2
2 1
2 3*/

import java.util.Scanner;

public class D_8_27_03 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
        if(!sc.hasNext()){
            sc.close();
            return;
        }
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[] tower = new int[n];
        int max = 0;
        int min = 0;
        for(int i=0;i<n;i++) {
        	tower[i] = sc.nextInt();
        	if(tower[max]<tower[i]) {
        		max = i;
        	}
        	else if(tower[min]>tower[i]) {
        		min = i;
        	}
        }
        sc.close();
        int result = 0;
        int flag = 0;
        int[][] move = new int[m][2];
        for(int i=0;i<m;i++) {
        	if(tower[max] == tower[min])break;
        	else {
        		tower[max]--;
        		tower[min]++;
        		move[flag][0]=max+1;
        		move[flag++][1]=min+1;
        		result++;
        		for(int j=0;j<n;j++) {
                	if(tower[max]<tower[j]) {
                		max = j;
                	}
                	else if(tower[min]>tower[j]) {
                		min = j;
                	}
                }
        	}
        }
        
        System.out.println(tower[max]-tower[min]+" "+result);
        for(int i=0;i<flag;i++) {
        	System.out.println(move[i][0]+" "+move[i][1]);
        }
	}
}
