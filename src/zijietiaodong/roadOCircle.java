package zijietiaodong;
import java.util.*;

public class roadOCircle{
	static HashMap<Integer,Long> his = new HashMap<Integer,Long>();
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        if(!sc.hasNext()){
            sc.close();
            return;
        }
        int n = sc.nextInt();
        sc.close();
        his.put(0, 1L);
        his.put(2, 1L);
        long result = resmul(n);
        System.out.print(result);
	}

	private static long resmul(int s) {
		// TODO Auto-generated method stub
		if(his.get(s)!=null)return his.get(s);
		long result =0;
		for(int i=1;i<s;i+=2) {
			long left = resmul(i-1);
		    long right = resmul(s-1-i);
		    result+=left*right;
		    result %=1000000007;
		}
		his.put(s, result);
		return result;
	}
}
