import org.junit.*;

import jdk.jfr.Timestamp;

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
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void AlastValjas(){
		laud.kysi(4, 2);
	}
	@Test(expected=IllegalArgumentException.class)
	public void NrAlgus(){
	  laud.alusta('4');
  }
  @Test
  public void Kontroll() {
	  laud.alusta('0');
	  assertEquals('0', laud.kelleKord());
	  laud.paiguta('0', 0, 0);
	  assertEquals('X', laud.kelleKord());
	  laud.paiguta('X', 2, 1);
	  assertEquals('0', laud.kelleKord());
	  laud.paiguta('0', 1, 0);
	  assertEquals('X', laud.kelleKord());
	  laud.paiguta('X', 2, 1);
  }
  @Test
  public void KontrollPaiguta() {
    laud.alusta('0');
    paiguta(1, 1);
    assertEquals('0', laud.kysi(1, 1));
  }
  @Test
	public void KontrollPuuduv() {
		laud.alusta('0');
		assertEquals(' ', laud.kysi(1, 2));
	}
	@Test(expected = IllegalArgumentException.class)
  	public void AlastValjasNeg() {
		laud.kysi(-1, -9);
	}
}
