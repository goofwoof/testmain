package DailyTest;

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
