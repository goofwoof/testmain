package DailyTest;

import java.util.ArrayList;
import java.util.Scanner;


/*题目描述
latex自然是广大研究人员最喜欢使用的科研论文排版工具之一。
月神想在iPhone 上查阅写好的paper，但是无赖iPhone 上没有月神喜欢使用的阅读软件，于是月神也希望像tex老爷爷Donald Knuth那样自己动手do it yourself一个。
在DIY这个阅读软件的过程中，月神碰到一个问题，已知iPhone屏幕的高为H，宽为W，若字体大小为S(假设为方形），则一行可放W / S(取整数部分）个文字，一屏最多可放H / S （取整数部分）行文字。
已知一篇paper有N个段落，每个段落的文字数目由a1, a2, a3,...., an表示，月神希望排版的页数不多于P页（一屏显示一页），那么月神最多可使用多大的字体呢？

1 <= W, H, ai <= 1000
1 <= P <= 1000000
输入描述:
每个测试用例的输入包含两行。

第一行输入N,P,H,W

第二行输入N个数a1,a2,a3,...,an表示每个段落的文字个数。
输出描述:
对于每个测试用例，输出最大允许的字符大小S
示例1
输入
复制
1 10 4 3
10
2 10 4 3
10 10
输出
复制
3
2
备注:
以上所有输入、输出均为整数。

且所有测试用例均保证有解。

两个段落之前不空行，并且段落顶格写。*/


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
