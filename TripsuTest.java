
import static org.junit.Assert.*;
import org.junit.*;

	public class TripsuTest {

	Tripsuliides laud;

	public class IllegalMoveException extends Exception{
	public IllegalMoveException(int rida, int veerg){
	super(rida + "->" + veerg + " ei ole vyimalik");
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void alustus1() {
		laud.alusta('S');
	}

	public void korrahaldus() {
		laud.alusta('0');
		assertEquals('0', laud.kelleKord());
		laud.paiguta(2, 2);
		assertEquals('X', laud.kelleKord());
	}

	public void CheckNum() {
		if (kysi(x, y) == null) {
		throw new ArithmeticException("puudub.");
		}
	}

	@Test(expected = ArrayOutOfIndexException.class)
	public void CheckMore() {
		laud.kysi(4, 2);
	}

	@Test
	public void CheckMoreValid() {
		assertEquals(' ', laud.kysi(1, 2));
	}

	@Test
	public void CheckPaiguta() {
		laud.alusta('0');
		paiguta(1, 1);
		assertEquals('0', laud.kysi(1, 1));
	}
	
	@Test(expected = IllegalMoveException.class)
	public void CheckPaigutaIsNegative() throws IllegalMoveException {
		laud.alusta('X');
		paiguta(-1, -1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void alustus2() {
		laud.alusta('3');
	}

  	@Test(expected = IllegalArgumentException.class)
  		public void testNonSquareBoard() {
    		laud.kysi(1, 2, 3);
  	}
	
	@Test(expected = IllegalMoveException.class)
  	public void testMakeMoveOutOfBoundsNegative() throws IllegalMoveException {
    		laud.kysi(-1, -9);
	}
	
}
