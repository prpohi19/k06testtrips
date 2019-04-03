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

	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void AlastV2ljas(){
		laud.kysi(4, 1);
	}
	@Test(expected=IllegalArgumentException.class)
    public void Numbrilinealustus(){
	   laud.alusta('4');
	}
	@Test(expected=IllegalArgumentException.class) //asetamine hõivatud kohale vist?
    public void vistonsamakohatest(){
	   laud.alusta('X');
		 laud.paiguta(2,2);
		 assertEquals('X', laud.kysi(2,2));
	}
	//test: mängu jätkamine peale võitu
	//test: sümboli asetamine juba hõivatud kohale
	//test: sümboli asetamine lauast väljaspool asuvale väärtusele nt rida 4 veerg 5
	//test:
}
