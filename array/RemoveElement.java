package array;

public class RemoveElement {
	/**
	 * Given an array and a value, remove all instances of that value in place and return the new length.
	 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
	 */
	public int removeElement(int[] A, int elem) {
		if(A == null)
			return 0;
        int i = 0;
        int j = A.length;
        while(i < j){
        	while(i < j && A[i] != elem) i++;
        	while(i < j && A[--j] == elem) ;
        	if(i < j){
        		A[i++] = A[j];
        	}
        }
        return j;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveElement s = new RemoveElement();
		int[] a = {1,2,3,2,4,5,2,6,2,2,7};
		for(int i = 0; i < a.length; i++)
			System.out.print("-->" + a[i]);
		System.out.println();
		int j = s.removeElement(a, 2);
		for(int i = 0; i < j; i++)
			System.out.print("-->" + a[i]);
		System.out.println();
	}

}
