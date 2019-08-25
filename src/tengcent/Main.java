package tengcent;
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        if(!sc.hasNext()){
            sc.close();
            return;
        }
        int n = sc.nextInt();
        int[] test = new int[n];
        for(int i=0;i<n;i++) {
        	sc.nextLine();
        	test[i] = sc.nextInt();
        }
        sc.close();
        for(int i=0;i<n;i++) {
        	int s = test[i];
        	HashMap<Integer,Integer> list = new HashMap<Integer,Integer>();
        	while(s>1) {
        		if(list.get(s)==null)list.put(s, s);
        		else break;
        		System.out.print(s+"=>>>");
        		s = resmul(s);
        		
        	}
        	if(s==1)
        		System.out.println("true");
        	else System.out.println("false");
        }
        
	}

	private static int resmul(int s) {
		// TODO Auto-generated method stub
		int result =0;
		while(s>0) {
			int p = s%10;
			result+=p*p;
			s /=10;	
		}
		return result;
	}
}