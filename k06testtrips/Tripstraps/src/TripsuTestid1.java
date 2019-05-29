import org.junit.*;
import static org.junit.Assert.*;
public class TripsuTestid1{
	Tripsuliides laud;
	@Test(expected=IllegalArgumentException.class)
    public void alustus1(){
		laud = new TripsTraps();
	   laud.alusta('S');
	}

	@Test
	public void korrahaldus(){
		laud = new TripsTraps();
		laud.alusta('0');
		assertEquals('X', laud.kelleKord());
		laud.paiguta('0', 1, 1);
		assertEquals('0', laud.kelleKord());
	}

	@Test
	public void kysi() {
		laud = new TripsTraps();
		laud.alusta('X');
		laud.paiguta('X', 3, 3);
		assertEquals('X', laud.kysi(3, 3));
	}
}
