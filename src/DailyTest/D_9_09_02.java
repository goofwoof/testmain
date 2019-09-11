package DailyTest;

import java.util.Arrays;
import java.util.Scanner;

public class D_9_09_02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		if(!sc.hasNext()) {
			sc.close();
			return;
		}
		int n = sc.nextInt();
		sc.nextLine();
		int[] in = new int[n];
		for(int i=0;i<n;i++) {
			String p = sc.nextLine();
			in[i] = Integer.parseInt(p.substring(p.length()-6,p.length()));
		}
		sc.close();
		Arrays.sort(in);
		for(int i:in) {
			System.out.println(i);
		}
	}
}
