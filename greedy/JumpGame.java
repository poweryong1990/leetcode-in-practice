package greedy;

public class JumpGame {
	/**
	 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
	
	Each element in the array represents your maximum jump length at that position.
	
	Determine if you are able to reach the last index.
	
	For example:
	A = [2,3,1,1,4], return true.
	
	A = [3,2,1,0,4], return false.
	 */
	public boolean canJump(int[] A) {
        if(A == null || A.length <= 1) return true;
        int jump = A[0];
        for(int i = 1; i < A.length; i++){
        	jump--;
        	if(jump < 0) return false;
        	if(jump < A[i]){
        		jump = A[i];
        	}
        }
        return true;
    }
	/**
	 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
	
	Each element in the array represents your maximum jump length at that position.
	
	Your goal is to reach the last index in the minimum number of jumps.
	
	For example:
	Given array A = [2,3,1,1,4]
	
	The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
	 */
	public int jump(int[] A) {
		if(A == null || A.length <= 1) return 0;
		int step = 0;
		int j = A[0];
		int i = 0;
		while(i < A.length){
			step++;
			if(i + j >= A.length - 1){
				break;
			}
			for(int k = j; k > 0; k--){
				i++;
				j--;
				if(j < A[i]) j = A[i];
			}
		}
		return step;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JumpGame s = new JumpGame();
		int[] a = {2,3,1,1,4};
		int[] b = {3,2,1,0,4};
		int[] c = {4,2,1,0,4};
		System.out.println(s.canJump(a));
		System.out.println(s.canJump(b));
		System.out.println(s.canJump(c));
		System.out.println("JumpSteps:");
		int[] d = {2,3,1,1,4};
		System.out.println(s.jump(d));
		
	}

}
