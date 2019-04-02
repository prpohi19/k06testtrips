import java.util.*;

public class TripsuMassiiv implements Tripsuliides {
    char[] symbols;
    char praeguneMangja;

    public void alusta(char symbol) {
        symbols = new char[9];
        Arrays.fill(symbols, ' ');
        if (symbol == '0' || symbol == 'X') {
            praeguneMangja = symbol;
        } else {
            throw new IllegalArgumentException("Invalid player");
        }
    }

    public char kelleKord() {
        return praeguneMangja;
    }

    public boolean paiguta(int rida, int veerg){
        if (rida < 0 || rida > 2) {
            throw new IllegalArgumentException("Rida saab olla ainult 0, 1 või 2");
        } else if (veerg < 0 || veerg > 2) {
            throw new IllegalArgumentException("Veerg saab olla ainult 0, 1 või 2");
        }
        int position = veerg + (rida * 3);
        if (symbols[position] != ' ') {
            return false;
        }
        symbols[position] = praeguneMangja;
        if (praeguneMangja == '0') {
            praeguneMangja = 'X';
        } else {
            praeguneMangja = '0';
        }
        return true;
    }

    public char kysi(int rida, int veerg){
        if (rida < 0 || rida > 2) {
            throw new IllegalArgumentException("Rida saab olla ainult 0, 1 või 2");
        } else if (veerg < 0 || veerg > 2) {
            throw new IllegalArgumentException("Veerg saab olla ainult 0, 1 või 2");
        }
        return symbols[veerg + (rida * 3)];
    }
}
