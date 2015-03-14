
public class FactorialTrailingZeroes {
	/**
	 * Given an integer n, return the number of trailing zeroes in n!.
	 * Note: Your solution should be in logarithmic time complexity.
	 */
	public int trailingZeroes(int n) {
        if(n < 5) return 0;
        int sum = 0;
        for(int i = 5; i <= n; i += 5){
        	int k = i;
        	while(k % 5 == 0){
        		k /= 5;
        		sum++;
        	}
        }
        return sum;
    }
	public int trailingZeroes2(int n) {
		int sum = 0;
		while(n > 0){
			n /= 5;
			sum += n;
		}
		return sum;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FactorialTrailingZeroes s = new FactorialTrailingZeroes();
		int n = 0;
		System.out.println(s.trailingZeroes(n) + "==" + s.trailingZeroes(n));
		n = 1;
		System.out.println(s.trailingZeroes(n) + "==" + s.trailingZeroes(n));
		n = 5;
		System.out.println(s.trailingZeroes(n) + "==" + s.trailingZeroes(n));
		n = 93;
		System.out.println(s.trailingZeroes(n) + "==" + s.trailingZeroes(n));
		n = 169;
		System.out.println(s.trailingZeroes(n) + "==" + s.trailingZeroes(n));
		n = 234565;
		System.out.println(s.trailingZeroes(n) + "==" + s.trailingZeroes(n));
	}

}
