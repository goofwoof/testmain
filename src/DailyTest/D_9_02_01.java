package DailyTest;

import java.util.HashMap;
import java.util.Scanner;

/*题目描述
前几个月放映的头号玩家简直火得不能再火了，作为一个探索终极AI的研究人员，月神自然去看了此神剧。
由于太过兴奋，晚上月神做了一个奇怪的梦，月神梦见自己掉入了一个被施放了魔法的深渊，月神想要爬上此深渊。

已知深渊有N层台阶构成（1 <= N <= 1000)，并且每次月神仅可往上爬2的整数次幂个台阶(1、2、4、....)，请你编程告诉月神，月神有多少种方法爬出深渊
输入描述:
输入共有M行，(1<=M<=1000)

第一行输入一个数M表示有多少组测试数据，

接着有M行，每一行都输入一个N表示深渊的台阶数
输出描述:
输出可能的爬出深渊的方式
示例1
输入
复制
4
1
2
3
4
输出
复制
1
2
3
6
备注:
为了防止溢出，可将输出对10^9 + 3取模*/

public class D_9_02_01 {
	static HashMap<Integer,Integer> link = new HashMap<Integer,Integer>();
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		if(!sc.hasNext()) {
			sc.close();
			return;
		}
		int n = sc.nextInt();
		link.put(1, 1);
		link.put(2, 2);
		int[] array = new int[n];
		int big = Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			sc.nextLine();
			array[i] = sc.nextInt();
			big = Math.max(big, array[i]);
		}
		sc.close();
		int[] way = new int[big+1];
		way[0] = 1;
		way[1] = 1;
		int  m = (int) Math.pow(10, 9)+3;
        for (int i = 2; i <= big; i++) {
            int tmp = 1;
            while (tmp <= i) {
            	way[i] += way[i - tmp];
                tmp *= 2;
                way[i] %= m;
            }
        }
		for(int i=0;i<n;i++) {
			System.out.println(way[array[i]]);
		}
    }
}
