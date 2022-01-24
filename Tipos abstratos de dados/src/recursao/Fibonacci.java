package recursao;

public class Fibonacci {
	
	public static String result = "";
	public static int i = 0;
	
	public static String loop(int n) {
		
		if(i <= n) {
			if(i == n) {
				result += fibonacci(i);
			} else {
				result += fibonacci(i) + ",";
			}
			i++;
			loop(n);
		}
		/*for(int i = 0; i <= n; i++) {
			if(i == n) {
				result += fibonacci(i);	
			} else {
				result += fibonacci(i) + ",";
			}
		}*/
		return result;
	}
	
	public static int fibonacci(int f) {
		
		if(f == 1 || f == 2) {
			return 1;
		} else if(f == 0) {
			return 0;
		} else {
			return fibonacci(f - 1) + fibonacci(f - 2);			
		}
		
	}

	public static void main(String[] args) {
		
		String result = loop(10);
		System.out.println(result);
		
	}

}
