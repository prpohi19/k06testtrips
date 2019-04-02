import org.junit.*;
import static org.junit.Assert.*;

public class TripsuTestid1{
	Tripsuliides laud;

	@Test
	public void first(){
		System.out.println("Testi automaatkäivitus");
	}

	@Test(expected = NullPointerException.class)
	public void alustus1(){
		laud.alusta('X');
	}

	@Test(expected = NullPointerException.class)
	public void korrahaldus(){
		laud.alusta('0');
		assertEquals('0', laud.kelleKord());
		laud.paiguta(2,2);
		assertEquals('X', laud.kelleKord());
	}
	@Test(expected = NullPointerException.class)
	public void v6it1(){
		laud.alusta('0');
		laud.paiguta(1,2);
		laud.paiguta(3,1);
		laud.paiguta(2,3);
		laud.paiguta(2,2);
		laud.paiguta(1,1);
		laud.paiguta(1,3);
		//assertEquals(true, laud.kontroll());
	}
	@Test(expected = NullPointerException.class)
	public void salvestamine(){
		laud.paiguta(1,1);
		laud.salvesta(1,1);
		laud.paiguta(1,2);
		laud.salvesta(1,2);
		laud.paiguta(1,3);
		laud.salvesta(1,3);
		laud.paiguta(2,1);
		laud.paiguta(2,2);
		laud.paiguta(2,3);
		laud.paiguta(3,1);
		laud.paiguta(3,2);
		laud.paiguta(3,3);
	}
}
