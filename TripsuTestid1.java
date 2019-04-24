import org.junit.*;
import static org.junit.Assert.*;
public class TripsuTestid1{
	Trips laud = new Trips();
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
    @Test
	public void voit(){
	   laud.alusta('0');
	   assertEquals('0', laud.kelleKord());
	   laud.paiguta('0', 0, 0);
       assertEquals('X', laud.kelleKord());
       laud.paiguta('X', 2, 1);
       assertEquals('0', laud.kelleKord());
	   laud.paiguta('0', 1, 0);
       assertEquals('X', laud.kelleKord());
       laud.paiguta('X', 2, 2);
       assertEquals('0', laud.kelleKord());
	   laud.paiguta('0', 2, 0);
	}
}
