package controlFlow_ob;
import java.util.Random;



public class Dynamic_Opaque_Predicate {
	
	public static int sum (int x, int y ){
		return x+y;
	}

	public static int sub (int x, int y ){
		return x-y;
	}

	public static void main(String[] args) {
		int a  = 1;
		int b = 1;
		int c = 1;
		int result = 0;
		int p = (int)(Math.random()*10)%2;
		int q = p % 2;
		
		result = a + b + c;
		
		if (p > 0) {
			result ++;
			
		} else {
			result --;
		}
		
		if (q <= 0) {
			result ++;
		} else {
			result --;
		}
		System.out.println("rand: " + p +", " + q);
		System.out.println("result: " + result);
	}

}
