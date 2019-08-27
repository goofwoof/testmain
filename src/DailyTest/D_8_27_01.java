package DailyTest;

/*题目描述
又到了丰收的季节，恰逢小易去牛牛的果园里游玩。
牛牛常说他对整个果园的每个地方都了如指掌，小易不太相信，所以他想考考牛牛。
在果园里有N堆苹果，每堆苹果的数量为ai，小易希望知道从左往右数第x个苹果是属于哪一堆的。
牛牛觉得这个问题太简单，所以希望你来替他回答。
输入描述:
第一行一个数n(1 <= n <= 105)。
第二行n个数ai(1 <= ai <= 1000)，表示从左往右数第i堆有多少苹果
第三行一个数m(1 <= m <= 105)，表示有m次询问。
第四行m个数qi，表示小易希望知道第qi个苹果属于哪一堆。
输出描述:
m行，第i行输出第qi个苹果属于哪一堆。
示例1
输入
复制
5
2 7 3 4 9
3
1 25 11
输出
复制
1
5
3*/

import java.util.*;
public class D_8_27_01 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
        if(!sc.hasNext()){
            sc.close();
            return;
        }
        int n = sc.nextInt();
        sc.nextLine();
        int[] apple = new int[n+1];
        int count=0;
        for(int i=0;i<n;i++) {
        	apple[i] = count;
        	count+=sc.nextInt();
        }
        apple[n] = count;
        sc.nextLine();
        int m =sc.nextInt();
        int[] wh = new int[m];
        for(int i=0;i<m;i++) {
        	wh[i] = sc.nextInt();
        }
        sc.close();
        //System.out.println(Arrays.toString(apple));
        for(int i=0;i<m;i++) {
        	int result = Arrays.binarySearch(apple, wh[i]);
        	System.out.println(result>0?result:-result-1);
        }
	}
}
