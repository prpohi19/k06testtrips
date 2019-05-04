public interface Tripsuliides {
	String alusta(String[] laud); // lubatud 0 ja X
	String kelleKord(String kord);
	boolean paiguta(String[] laud); // true if was able to place. false if selected position is already taken.
	String[] kysi(String kord, String[] laud);
}
