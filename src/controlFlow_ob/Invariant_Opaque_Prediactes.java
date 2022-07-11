package controlFlow_ob;

public class Invariant_Opaque_Prediactes {
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
		int temp = 0;

		if (a*a >=0) {
			result = sum(a,b);
			temp = sum(b,c);
			result = sum (result, temp);
		} else {
			result = sub(a,b);
			temp = sub(b,c);
			result = sub (result, temp);
		}
		
		if (b*b >=0) {
			result = sub (result, b);
		}
		else {
			result = sum (temp, c);
		}
		
		System.out.println("result: " + result);
	}

}
