package controlFlow_ob;

public class Contextual_Opaque_Predicates {
	
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
		int temp = 2;
		int result = 0;
		
		if (temp * temp > 3) {
			if(a*a+(-1-(1))*(-1-(1))>0) {
				result = sum(a,b);
				temp = sum(b,c);
				result = sum(result, temp);
				result = sub(result, b);
			}
		} else {
			result = sub(a,b);
			}
		
		System.out.println("result: " + result);
	}
}
