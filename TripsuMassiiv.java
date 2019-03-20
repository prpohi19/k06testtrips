import java.util.*;

public class TripsuMassiiv implements Tripsuliides{
    char[] symbols;
    char praeguneMangja;

    public void alusta(char symbol){
      symbols = new char[9];
      Arrays.fill(symbols, ' ');
      if (symbol == '0' || symbol == 'X'){
        praeguneMangja = symbol;
      }
      else {
        throw new IllegalArgumentException("Invalid player");
      }
    }
    public char kelleKord(){
      return praeguneMangja;
    }
    public void paiguta(char symbol, int rida, int veerg){
      symbols[rida+(veerg*3)] = praeguneMangja;
      if (praeguneMangja=='0'){
        praeguneMangja='X';
      }
    }
    public char kysi(int rida, int veerg){
        return symbols[rida+(veerg*3)];
    }
}
