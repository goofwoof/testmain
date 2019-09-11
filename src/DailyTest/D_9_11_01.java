package DailyTest;

import java.util.ArrayList;
import java.util.Scanner;

public class D_9_11_01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> out = new ArrayList<Integer>();
		if(!sc.hasNext()) {
			sc.close();
			return;
		}
		do{
			int N = sc.nextInt();
			int P = sc.nextInt();
			int H = sc.nextInt();
			int W = sc.nextInt();
			sc.nextLine();
			int[] words = new int[N];
			int t=0;
			for(int i=0;i<N;i++) {
				words[i]=sc.nextInt();
				t+=words[i];
			}
			sc.nextLine();
			if(t<=P)
				out.add(Math.min(H, W));
			else out.add(cal(N,P,H,W,words,(int)Math.sqrt(H*W*P/t)));	
		}while(sc.hasNext());
		sc.close();
		out.forEach((Integer i)->System.out.println(i));
	}

	private static int cal(int n, int p, int h, int w, int[] words,int result) {
		// TODO Auto-generated method stub
		int max = Math.min(h, w);
		//int result = max/2;
		int lastMid = -1;
		while(true) {
			//System.out.println("result=>"+result);
			int t = total(p,words,h/result,w/result);
			//System.out.println("t=>"+t);
			if(t==0) {
				return result;	
			}
			else if(t==1){
				if(lastMid>0)return lastMid;//如果上次可以则返回
				result--;
			}
			else {
				lastMid=result;
				result++;
			}
		}
	}

	private static int total(int p,int[] words, int lofpage, int lofline) {
		// TODO Auto-generated method stub
		float result = 0;
		for(int i=0;i<words.length;i++) {
			result +=Math.ceil((float)words[i]/lofline);
		}
		result/=lofpage;
		//System.out.println("result=>"+result+"  p=>"+p);
		if(result==p)return 0;//恰好
		if(result>p)return 1;//多了
		return 2;//还可以再改
	}
}
