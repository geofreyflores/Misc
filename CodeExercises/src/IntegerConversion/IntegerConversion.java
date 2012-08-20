package IntegerConversion;

public class IntegerConversion {
	
	private static final char[] CHARMAP = {'0', '1', '2', '3', '4', '5', '6', 
		'7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
	
	
	/** @return string representation of integer for a given radix base. */
	public String itoa(int i, int base) {
		boolean isNegative = i < 0;

		int digitsLeft = i;
		char[] str = new char[32];  // max length
		int counter = 0;

		do {
			digitsLeft = digitsLeft / base;
			int toStr = i % base;

			str[counter++] = CHARMAP[toStr];
		} while (digitsLeft > 1);
		
		if (isNegative) str[counter++] = '-';

		StringBuffer b = new StringBuffer(counter);
		while (counter >= 0) { 
			b.append(str[counter--]);
		}
		return b.toString();
	}
	
	
	
	/** Do tests here */
	public static void main(String[] args) {
		IntegerConversion c = new IntegerConversion();
		int base = 10;
		
		c.itoa(1, base);
		
	}

}
