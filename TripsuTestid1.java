import org.junit.*;
import static org.junit.Assert.*;
public class TripsuTestid1{
	Tripsuliides laud;
	@Test(expected=IllegalArgumentException.class)
    public void alustus1(){
	   laud.alusta('S');
	}
	public void korrahaldus(){
	   laud.alusta('O');
	   assertEquals('O', laud.kelleKord());
	   laud.paiguta('O', 2, 2);
	   assertEquals('X', laud.kelleKord());
	}

	//test: mängu jätkamine peale võitu
	//test: sümboli asetamine juba hõivatud kohale
	//test: sümboli asetamine lauast väljaspool asuvale väärtusele nt rida 4 veerg 5
	//test: 
}
