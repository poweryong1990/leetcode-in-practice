package dynamicProgramming;

public class ClimbingStairs {
	/**
	 * You are climbing a stair case. It takes n steps to reach to the top.
	 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
	 */
	public int climbStairs(int n){
		if(n < 1) return 0;
		if(n == 1 || n == 2) return n;
		return climbStairs(n -1) + climbStairs(n -2);
	}
	public int climbStairs_2(int n){
		if(n < 1) return 0;
		if(n == 1 || n == 2) return n;
		int a = 1, b = 2, c = 3;
		for(int i = 3; i <= n; i++){
			c = a + b;
			a = b;
			b = c;
		}
		return c;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
