public class Trips implements Tripsuliides {
    private char[][] kohad = new char[3][3];
    private char[] symbolid = {'X', '0'};
    private char kord;

    public void alusta(char symbol) {
        if (new String(symbolid).indexOf(symbol) == -1) { // https://stackoverflow.com/a/18581539
            throw new IllegalArgumentException("See sümbol ei sobi!");
        }
        kord = symbol;
    }

    public char kelleKord() {
        return kord;
    }

    public void paiguta(char symbol, int rida, int veerg) {
        if (kelleKord() == symbol){
            kohad[rida][veerg] = symbol;
        }
        else {
            throw new IllegalArgumentException("Pole selle sümboli kord!");
        }

        // Vaheta korda
        if (kelleKord() == symbolid[0]){
            kord = symbolid[1];
        }
        else if (kelleKord() == symbolid[1]) {
            kord = symbolid[0];
        }
    }

    public char kysi(int rida, int veerg) {
        return kohad[rida][veerg];
    }
}
