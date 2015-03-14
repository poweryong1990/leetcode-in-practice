package array;

public class PlusOne {
	/**
	 * Given a non-negative number represented as an array of digits, plus one to the number.
	 * digits are stored such that the most significant digit is at the head of the list.
	 */
	public int[] plusOne(int[] digits) {
        int carry = 1;
        int sum = 0;
        for(int i = digits.length - 1; i >= 0; i--){
        	sum = carry + digits[i];
        	digits[i] = sum % 10;
        	carry = sum /10;
        }
        if(carry == 0){
        	return digits;
        }else{
        	int[] r = new int[digits.length + 1];
        	r[0] = carry;
        	for(int i =0; i < digits.length; i++){
        		r[i+1] = digits[i];
        	}
        	return r;
        }
    }
	public int[] plusOne2(int[] digits) {
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i--){
        	if(carry == 1){
        		if(digits[i] == 9)
        			digits[i] = 0;
        		else{
        			digits[i] += 1;
        			carry = 0;
        		}
        	}
        }
        if(carry == 0){
        	return digits;
        }else{
        	int[] r = new int[digits.length + 1];
        	r[0] = carry;
        	for(int i =0; i < digits.length; i++){
        		r[i+1] = digits[i];
        	}
        	return r;
        }
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PlusOne s = new PlusOne();
		int[] a = {9,9,9,9,9};
		int[] b = {1,2,3,4,5};
		Array.print(s.plusOne(a));
		Array.print(s.plusOne(b));
	}

}
