
import org.junit.*;
import static org.junit.Assert.*;
public class TripsuTest{
	Tripsuliides laud;
	@Test(expected=IllegalArgumentException.class)
    public void alustus1(){
	   laud.alusta('S');
	}
	public void korrahaldus(){
	   laud.alusta('0');
	   assertEquals('0', laud.kelleKord());
	   laud.paiguta('0', 2, 2);
	   assertEquals('X', laud.kelleKord());
	}

  public void CheckNum(){
  if(kysi(x, y) == null){throw new ArithmeticException("puudub.");}
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

  @Test(expected = ArithmeticException.class)
  public void alustus2(){
    laud.alusta('3');
  }
}
