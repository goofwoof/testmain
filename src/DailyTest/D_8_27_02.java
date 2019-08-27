package DailyTest;

import java.util.*;

public class D_8_27_02 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
        if(!sc.hasNext()){
            sc.close();
            return;
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        sc.close();
        int Max = a+b+c;
        Max = Math.max(Max, a*b+c);
        Max = Math.max(Max, a+b*c);
        Max = Math.max(Max, a*(b+c));
        Max = Math.max(Max, (a+b)*c);
        Max = Math.max(Max, a*b*c);
        System.out.println(Max);
	}
}
