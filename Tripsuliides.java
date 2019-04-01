public interface Tripsuliides{
	void tyhiLaud(); //loob laua
	void prindiLaud(); //kuvab laua
	char alusta(); //randomiga otsustatakse, kes alustab : lubatud O ja X
	char kelleKord(char symbol); // vahetab mängukorda
	//String kysi(int rida, int veerg);  <-- ei tea kas on vaja?
	void paiguta(char symbol, int rida, int veerg);
	//funktsioon:  kas on võit
}

/*
interface Tripsuliides{
	void alusta(char symbol); //lubatud 0 ja X
	char kelleKord();
	void paiguta(char symbol, int rida, int veerg);
	char kysi(int rida, int veerg);
}
*/
