
public class ReverseInteger {
	/**
	 * Reverse digits of an integer.
	 * Example1: x = 123, return 321
	 * Example2: x = -123, return -321
	 */
	public int reverse(int x) {
        int y = 0;
        if(x > 0){
	        while(x != 0){
	        	int n = x % 10;
	        	if(y > Integer.MAX_VALUE / 10 || 
	        			y == Integer.MAX_VALUE / 10 && n > Integer.MAX_VALUE % 10)
	        		return 0;
	        	y = 10 * y + n;
	        	x /= 10;
	        }
        }else{
        	while(x != 0){
	        	int n = x % 10;
	        	if(y < Integer.MIN_VALUE / 10 || 
	        			y == Integer.MIN_VALUE / 10 && n < Integer.MIN_VALUE % 10)
	        		return 0;
	        	y = 10 * y + n;
	        	x /= 10;
	        }
        }
        return y;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-1 % 10 = " + (-1 % 10));
		System.out.println("-7 % 10 = " + (-7 % 10));
		System.out.println("-7 % 5 = " + (-7 % 5));
		System.out.println("max int is " + Integer.MAX_VALUE);
		System.out.println("min int is " + Integer.MIN_VALUE);
	}

}
