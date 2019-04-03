interface Tripsuliides {
	void alusta(char symbol); // lubatud 0 ja X
	char kelleKord();
	boolean paiguta(int rida, int veerg); // true if was able to place. false if selected position is already taken.
	char kysi(int rida, int veerg);
}
