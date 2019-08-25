package tengcent;
import java.util.*;

public class Maain{
	
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        if(!sc.hasNext()){
            sc.close();
            return;
        }
        int N = sc.nextInt();
        int[] song = new int[N];
        int[] lastman = new int[N];
        sc.nextLine();
        for(int i=0;i<N;i++) {
        	song[i] = sc.nextInt();
        }
        sc.close();
        int result =0;
        lastman[result++] = song[0];
        for(int i=1;i<N;i++) {
        	if(song[i]<lastman[result-1]) {//纳入这一组
        		for(int j=result-2;j>=0;j--) {
                	if(song[i]<lastman[j]) {
                		lastman[j] = lastman[j+1];
                		result--;
                	}
                }
        	}
        	else {//新的组
        		lastman[result] = song[i];
        		result++;
        	}
        	
        }
        System.out.print(result);
	}
}