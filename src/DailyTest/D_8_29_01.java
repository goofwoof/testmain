package DailyTest;

import java.util.Arrays;
import java.util.Scanner;

/*题目描述
小明在越南旅游，参加了当地的娱乐活动。小明运气很好，拿到了大奖， 到了最后的拿奖金环节。小明发现桌子上放着一列红包，每个红包上写着奖金数额。
现在主持人给要求小明在这一列红包之间“切”2刀，将这一列红包“切”成3组，并且第一组的奖金之和等于最后一组奖金和（允许任意一组的红包集合是空）。最终第一组红包的奖金之和就是小明能拿到的总奖金。小明想知道最多能拿到的奖金是多少，你能帮他算算吗。

举例解释：桌子上放了红包  1, 2, 3, 4, 7, 10。小明在“4,7”之间、“7,10” 之间各切一刀，将红包分成3组 [1, 2, 3, 4]   [7]   [10]，其中第一组奖金之和=第三组奖金之和=10，所以小明可以拿到10越南盾。
输入描述:
第一行包含一个正整数n，(1<=n<= 200 000)，表示有多少个红包。

第二行包含n个正整数d[i]，表示每个红包包含的奖金数额。其中1<= d[i] <= 1000 000 000
输出描述:
小明可以拿到的总奖金
示例1
输入
复制
5
1 3 1 1 4
输出
复制
5
说明
[1,3,1]  [ ]   [1,4] ，其中第一组奖金和是5，等于第三组奖金和。所以小明可以拿到5越南盾
示例2
输入
复制
5
1 3 2 1 4
输出
复制
4
说明
[1,3]   [2,1]  [4]，小明可以拿到4越南盾
示例3
输入
复制
3
4 1 2
输出
复制
0
说明
[ ]  [4, 1, 2] [ ] ，小明没办法，为了保证第一组第三组相等，只能都分成空的。所以小明只能拿到0越南盾。*/

public class D_8_29_01 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
        if(!sc.hasNext()){
            sc.close();
            return;
        }
        int n = sc.nextInt();
        sc.nextLine();
        long[] apple = new long[n];
        for(int i=0;i<n;i++) {
        	apple[i] = sc.nextInt();
        }
        sc.close();
        long result = 0;
        long resultl = apple[0];
        long resultr = apple[n-1];
        int l = 0;
        int r = n-1;
        while(l!=r){
        	if(resultl==resultr) {
        		result=resultr;
        		if(r-l==1)break;
        		l++;
        		resultl += apple[l];
        		r--;
        		resultr += apple[r];
        	}
        	else {
        		if(r-l==1)break;
        		if(resultl>resultr) {
        			r--;
            		resultr += apple[r];
        		}
        		else {
        			l++;
            		resultl += apple[l];
        		}
        	}
        }
        System.out.println(result);
	}
}
