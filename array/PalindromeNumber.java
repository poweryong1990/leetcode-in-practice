package array;

public class PalindromeNumber {
	/**
	 * Determine whether an integer is a palindrome. Do this without extra space.
	 */
	//zero is a palindrome
	//a negative number is not a palindrome number
	public boolean isPalindrome(int x) {
		int a = x;
		int b = 0;
		while(a > 0){
			b = b * 10 + a % 10;
			a /= 10;
		}
		return x == b;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromeNumber s = new PalindromeNumber();
		int a = 0;
		System.out.println(a + " is a palindrome: " + s.isPalindrome(a));
		a = -12321;
		System.out.println(a + " is a palindrome: " + s.isPalindrome(a));
		a = 1234321;
		System.out.println(a + " is a palindrome: " + s.isPalindrome(a));
		a = 123321;
		System.out.println(a + " is a palindrome: " + s.isPalindrome(a));
		a = 1234543210;
		System.out.println(a + " is a palindrome: " + s.isPalindrome(a));
	}

}
