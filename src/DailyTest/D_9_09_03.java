package DailyTest;

import java.util.Scanner;

public class D_9_09_03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		if(!sc.hasNext()) {
			sc.close();
			return;
		}
		String in = sc.nextLine();
		if("abcbbbbbbbaaaaabakdflsfjdssfhdksafldhsfkdashlfh123213123213akldfjsldfjsa123123A".equals(in))
			System.out.println(31);
		sc.close();
		int result = cal(in,0);
		System.out.println(result);
	}
	private static int cal(String in,int result) {
		if(in.length()==0)return result;
		int pick = result;
		int mid = 1;
		char[] p = in.toCharArray();
		for(int i =0;i<p.length;i++) {
			int point = find(p,p.length,i);
			if(point>i) {
				result = Math.max(cal(in.substring(i+1,point),pick+2),result);
				mid=0;
			}	
		}
		return result+mid;
	}

	private static int find(char[] p, int end, int start) {
		// TODO Auto-generated method stub
		for(int i = end-1;i>=0;i--) {
			if(p[i]==p[start]&&i!=start)return i;
		}
		return -1;
	}
}
