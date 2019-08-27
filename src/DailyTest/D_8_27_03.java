package DailyTest;

import java.util.Arrays;
import java.util.Scanner;

public class D_8_27_03 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
        if(!sc.hasNext()){
            sc.close();
            return;
        }
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[] tower = new int[n];
        int max = 0;
        int min = 0;
        for(int i=0;i<n;i++) {
        	tower[i] = sc.nextInt();
        	if(tower[max]<tower[i]) {
        		max = i;
        	}
        	else if(tower[min]>tower[i]) {
        		min = i;
        	}
        }
        sc.close();
        int result = 0;
        int flag = 0;
        int[][] move = new int[m][2];
        for(int i=0;i<m;i++) {
        	if(tower[max] == tower[min])break;
        	else {
        		tower[max]--;
        		tower[min]++;
        		move[flag][0]=max+1;
        		move[flag++][1]=min+1;
        		result++;
        		for(int j=0;j<n;j++) {
                	if(tower[max]<tower[j]) {
                		max = j;
                	}
                	else if(tower[min]>tower[j]) {
                		min = j;
                	}
                }
        	}
        }
        
        System.out.println(tower[max]-tower[min]+" "+result);
        for(int i=0;i<flag;i++) {
        	System.out.println(move[i][0]+" "+move[i][1]);
        }
	}
}
