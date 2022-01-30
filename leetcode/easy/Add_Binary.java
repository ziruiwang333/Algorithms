package leetcode.easy;

/**
 * Given two binary strings a and b, return their sum as a binary string.
 * 
 * @author zirui
 * @url https://leetcode.com/problems/add-binary/
 */

public class Add_Binary {

	public static void main(String[] args) {
		String a = "1111";
		String b = "1111";
		System.out.println(optimizedSol(a,b));
	}
	
	public static String optimizedSol(String a, String b) {
		StringBuilder result = new StringBuilder();
        int aPtr = a.length()-1;
        int bPtr = b.length()-1;
        int carry = 0;
        while(aPtr >= 0 || bPtr >= 0){
            int sum = 0;
            sum += carry;
            if(aPtr >= 0){
                sum += Integer.parseInt(a.substring(aPtr, aPtr+1));
                aPtr--;
            }
            if(bPtr >= 0){
                sum += Integer.parseInt(b.substring(bPtr, bPtr+1));
                bPtr--;
            }
            result.append(sum%2);
            carry = sum > 1 ? 1 : 0;
        }
        if(carry != 0){
            result.append(1);
        }
        return result.reverse().toString();
	}
	
	// WRONG! May exceed Integer range
	public static String mySol(String a, String b) {
		int aInt = Integer.parseInt(a);
		int bInt = Integer.parseInt(b);
		Integer sum = aInt + bInt;
		char[] result = sum.toString().toCharArray();
		for(int i=result.length-1; i>=1; i--) {
			if(result[i] == '2') {
				result[i] = '0';
				result[i-1] = (char) (result[i-1] + 1);
			}
			else if(result[i] == '3') {
				result[i] = '1';
				result[i-1] = (char) (result[i-1] + 1);
			}
		}
		if(result[0] == '2') {
			result[0] = '0';
			return "1" + new String(result);
		}
		else if(result[0] == '3') {
			result[0] = '1';
			return "1" + new String(result);
		}
		return new String(result);
	}

}
