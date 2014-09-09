package integerconversion;

import org.testng.Assert;
import org.testng.annotations.Test;

public class IntegerConversion {
	
	private static final char[] CHARMAP = {
		'0', '1', '2', '3', '4', 
		'5', '6', '7', '8', '9'
	};
	
	
	/** @return String representation of integer in base 10 */
	public String itoa(int i) {
		final base = 10;
		// LIMITATION: doesn't process i=Integer.MIN_VALUE; special case impl.
		if (i == Integer.MIN_VALUE) return "-2147483648";
		
		boolean negative = i < 0;
		if (negative) i = -i;
		
		int digitsLeft = i; // running example: i=1432,base=10
		char[] instr = new char[11];  // max length
		int counter = 0;

		do {
			int toStr = digitsLeft % base;	//   2
			digitsLeft = digitsLeft / base; // 143
			
			instr[counter++] = CHARMAP[toStr]; // 2, 3, 4, 1
		} while (digitsLeft > 0);
		
		if (negative) instr[counter++] = '-';

		// reverse char[] by swapping
		for (i = 0; i < counter/2; i++) {
			char temp = instr[i];
			instr[i] = instr[(counter-1) - i];
			instr[(counter-1) - i] = temp;
		}
		
		return String.copyValueOf(instr, 0, counter).intern();
	}
	
	
	@Test
	public void testbase10() {		
		try {
			Assert.assertEquals(itoa(0), "0" );
			Assert.assertEquals(itoa(1), "1" );
			Assert.assertEquals(itoa(1234), "1234" );
			Assert.assertEquals(itoa(-4567), "-4567" );
			Assert.assertEquals(itoa(Integer.MAX_VALUE), Integer.toString(Integer.MAX_VALUE) );
			Assert.assertEquals(itoa(Integer.MIN_VALUE), Integer.toString(Integer.MIN_VALUE) );
		} catch (AssertionError e) {
			System.out.println(e.getMessage() );
			throw e;
		}
	}

}
