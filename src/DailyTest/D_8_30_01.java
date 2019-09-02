package DailyTest;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*题目描述
小明有一袋子长方形的积木，如果一个积木A的长和宽都不大于另外一个积木B的长和宽，则积木A可以搭在积木B的上面。好奇的小明特别想知道这一袋子积木最多可以搭多少层，你能帮他想想办法吗？
定义每一个长方形的长L和宽W都为正整数，并且1 <= W <= L <= INT_MAX, 袋子里面长方形的个数为N, 并且 1 <= N <= 1000000.
假如袋子里共有5个积木分别为 (2, 2), (2, 4), (3, 3), (2, 5), (4, 5), 则不难判断这些积木最多可以搭成4层, 因为(2, 2) < (2, 4) < (2, 5) < (4, 5)。
输入描述:
第一行为积木的总个数 N

之后一共有N行，分别对应于每一个积木的宽W和长L
输出描述:
输出总共可以搭的层数
示例1
输入
复制
5
2 2
2 4
3 3
2 5
4 5
输出
复制
4*/

public class D_8_30_01 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		if(!sc.hasNext()) {
			sc.close();
			return;
		}
		int n = sc.nextInt();
		
		int[][] array = new int[n][2];
		for(int i=0;i<n;i++) {
			sc.nextLine();
			array[i][0] = sc.nextInt();
			array[i][1] = sc.nextInt();
		}
		sc.close();
		if( n == 1){
            System.out.print(1);
            return;
        }
		Arrays.sort(array, (a, b) -> a[0] - b[0]);
		int[] top = new int[n];
        int piles = 0;
        for(int i = 0; i < n; i ++) {
            int target = array[i][1];
 
            int l = 0;
            int r = piles;
            while(l < r) {
                int mid = (l + r) >>> 1;
                if(top[mid] > target) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
 
            if(l == piles) piles ++;
            top[l] = target;
        }
 
        System.out.println(piles);
    }
}
