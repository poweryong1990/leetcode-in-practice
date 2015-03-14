
public class AddBinary {
	/**
	 * Given two binary strings, return their sum (also a binary string).
	 * For example,
	 * a = "11"
	 * b = "1"
	 * Return "100".
	 */
	public String addBinary(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int i = a.length();
        int j = b.length();
        int index;
        char carry = '0';
        int c = 0;
        while(i > 0 && j > 0){
        	i--;
        	j--;
//        	int x = Integer.parseInt(a.substring(i, i+1));
//        	int y = Integer.parseInt(b.substring(j, j+1));
        	char x = a.charAt(i);
        	char y = b.charAt(j);
        	c = 0;
        	if(x == '1') c++;
        	if(y == '1') c++;
        	if(carry == '1') c++;
        	switch(c){
        	case 0:
        		sb.append("0");
        		break;
        	case 1:
        		sb.append("1");
        		carry = '0';
        		break;
        	case 2:
        		sb.append("0");
        		carry = '1';
        		break;
        	case 3:
        		sb.append("1");
        		carry = '1';
        		break;
        	default:
        		System.out.println("error");
        	}
        }
        while(i > 0){
        	i--;
        	char x = a.charAt(i);
        	if(x == '1' && carry == '1'){
        		sb.append("0");
//        		carry = '1';
        	}else if(x == '0' && carry == '0'){
        		sb.append("0");
        	}else{
        		sb.append("1");
        		carry = '0';
        	}
        }
        while(j > 0){
        	j--;
        	char x = b.charAt(j);
        	if(x == '1' && carry == '1'){
        		sb.append("0");
//        		carry = '1';
        	}else if(x == '0' && carry == '0'){
        		sb.append("0");
        	}else{
        		sb.append("1");
        		carry = '0';
        	}
        }
        if(carry == '1'){
        	sb.append("1");
        }
        return sb.reverse().toString();
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto__generated method stub
		AddBinary s = new AddBinary();
		System.out.println("10101010 + 111100000 = " + s.addBinary("10101010", "111100000"));
		System.out.println("10 + 11 = " + s.addBinary("10", "11"));
	}

}
