
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
import org.junit.*;

@RunWith(Parameterized.class)
public class TripsuTest {
	Tripsuliides laud;

	public TripsuTest(Tripsuliides laud) {
        this.laud = laud;
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
		if (laud.kysi(0, 0) == ' ') {
			throw new ArithmeticException("puudub.");
		}
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void CheckMore() {
		laud.alusta('0');
		laud.kysi(4, 2);
	}

	@Test
	public void CheckMoreValid() {
		laud.alusta('0');
		assertEquals(' ', laud.kysi(1, 2));
	}

	@Test
	public void CheckPaiguta() {
		laud.alusta('0');
		laud.paiguta(1, 1);
		assertEquals('0', laud.kysi(1, 1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void alustus2() {
		laud.alusta('3');
	}

	@Parameterized.Parameters
    public static Collection<Object> instancesToTest() {
        return Arrays.asList(
                    new Object[]{new TripsuMassiiv()}
        );
    }
}
