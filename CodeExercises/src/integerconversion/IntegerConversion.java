package integerconversion;

import org.testng.Assert;
import org.testng.annotations.Test;

public class IntegerConversion {
	
	private static final char[] CHARMAP = {
		'0', '1', '2', '3', '4', '5', '6', '7', 
		'8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
	};
	
	
	/** @return string representation of integer for a given radix base. */
	public char[] itoa(int i, int base) {		
		boolean negative = i < 0;
		if (negative) i *= -1;
		
		int digitsLeft = i; // running example: i=1432,base=10
		char[] instr = new char[32];  // max length
		int counter = 0;

		do {
			int toStr = digitsLeft % base;	//   2
			digitsLeft = digitsLeft / base; // 143
			
			instr[counter++] = CHARMAP[toStr]; // 2, 3, 4, 1
		} while (digitsLeft > 0);
		
		if (negative) instr[counter++] = '-';

		for (i = 0; i < instr.length/2; i++) {
			char temp = instr[i];
			instr[i] = instr[(counter-1) - i];
			instr[(counter-1) - i] = temp;
		}
		return instr;
	}
	
	
	@Test
	public void testbase10() {
		IntegerConversion c = new IntegerConversion();
		int base = 10;
		
		try {
			Assert.assertEquals(itoa(0, base), "0" );
			Assert.assertEquals(itoa(1234, base), "1234" );
			Assert.assertEquals(itoa(-4567, base), "-4567" );
			Assert.assertEquals(itoa(Integer.MAX_VALUE, base), Integer.toString(Integer.MAX_VALUE) );
		} catch (AssertionError e) {
			System.out.println(e.getMessage() );
			throw e;
		}
	}

}
