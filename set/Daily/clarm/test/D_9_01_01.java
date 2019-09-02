package Daily.clarm.test;

import org.junit.Test;

public class D_9_01_01 {
	
	@Test
	public void longTest() {
		Long a = 1000L;
		Long b = 1000L;
		if(a == b)
			System.out.println("a==b");
		Long c = 100L;
		Long d = 100L;
		if(c == d)
			System.out.println("c==d");
		System.out.println((int)1e3);
		System.out.println((int)1^3);
	}
}
