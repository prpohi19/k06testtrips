import org.junit.*;
import static org.junit.Assert.*;
public class TripsuTestid1{
	Tripsuliides laud;
	@Test(expected=IllegalArgumentException.class)
    public void alustus1(){
	   laud.alusta('S');
	}

	@Test
	public void korrahaldus(){
	   laud.alusta('0');
	   assertEquals('0', laud.kelleKord());
	   laud.paiguta('0', 2, 2);
	   assertEquals('X', laud.kelleKord());
	}

	@Test(expected = java.lang.AssertionError.class) //0 käib 2 korda järjest
	public void veaKontroll() {
		laud.alusta('0');
		assertEquals('0', laud.kelleKord());
		laud.paiguta('0', 0, 0);
		assertEquals('X', laud.kelleKord());
		laud.paiguta('X', 2, 1);
		assertEquals('0', laud.kelleKord());
		laud.paiguta('0', 1, 0);
		assertEquals('0', laud.kelleKord());
		laud.paiguta('0', 2, 2);
		assertEquals('0', laud.kelleKord());
		laud.paiguta('0', 2, 0);
	}
	@Test // proovitakse sama koordinaati märkida 2 korda
	public void veaKontroll2() {
		laud.alusta('0');
		assertEquals('0', laud.kelleKord());
		laud.paiguta('0', 0, 0);
		assertEquals('X', laud.kelleKord());
		laud.paiguta('X', 2, 1);
		assertEquals('0', laud.kelleKord());
		laud.paiguta('0', 2, 1);
	}

	@Test
	public void voiduKontroll() {
		laud.alusta('0');
		assertEquals('0', laud.kelleKord());
		laud.paiguta('0', 1, 1);
		assertEquals('X', laud.kelleKord());
		laud.paiguta('X', 2, 1);
		assertEquals('0', laud.kelleKord());
		laud.paiguta('0', 2, 0);
		assertEquals('X', laud.kelleKord());
		laud.paiguta('X', 0, 2);
		assertEquals('0', laud.kelleKord());
		laud.paiguta('0', 2, 0);
		assertEquals(true, laud.voiduKontroll());
	}
}
