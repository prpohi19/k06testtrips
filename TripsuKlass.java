import java.io.*;

public class TripsuKlass {
  private char[] symbols = {'X', '0'};
  private char[][] board = new char[3][3];
  private char turn;
  void alusta(char symbol)throws Exception{
    if(symbol == 'x' || symbol == 'X'){
      turn = symbols[0];
    } else{
      turn = symbols[1];
    }
    System.out.println(turn + " alustab mängu");
    System.out.println("---");
    loadFile();
  } //lubatud 0 ja X
	char kelleKord(){
    return turn;
  }
	void paiguta(char symbol, int rida, int veerg)throws Exception{
    board[rida][veerg] = symbol;
    if(!checkLines(symbol)){
      if(turn == 'X'){
        turn = symbols[1];
      } else if(turn == '0'){
        turn = symbols[0];
      }
    }
    saveFile();
  }
	char kysi(int rida, int veerg){
    return board[rida][veerg];
  }

  boolean checkLines(char turn){
    boolean lineCheck = false;
    for (int i = 0; i < board.length; i++) {
      if ((kysi(0, 0) == turn && kysi(1, 0) == turn && kysi(2, 0) == turn) ||
              (kysi(0, 1) == turn && kysi(1, 1) == turn && kysi(2, 1) == turn) ||
              (kysi(0, 2) == turn && kysi(1, 2) == turn && kysi(2, 2) == turn) ||
              (kysi(0, 0) == turn && kysi(1, 1) == turn && kysi(2, 2) == turn) ||
              (kysi(0, 2) == turn && kysi(1, 1) == turn && kysi(2, 0) == turn) ||
              (kysi(0, 0) == turn && kysi(0, 1) == turn && kysi(0, 2) == turn) ||
              (kysi(1, 0) == turn && kysi(1, 1) == turn && kysi(1, 2) == turn) ||
              (kysi(2, 0) == turn && kysi(2, 1) == turn && kysi(2, 2) == turn)){
          lineCheck = true;
          break;
        }
      }
    return lineCheck;
  }

  void loadFile() throws Exception {
    BufferedReader fReader = new BufferedReader(new FileReader("game.txt"));
    String row = fReader.readLine();
    while (row != null) {
      System.out.println(row);
      for (int i = 0; i < row.length(); i++) {
        int r = 0;
        int c = 0;
        if(i >= 3 && i <= 5) {
          r = 1;
        } else if(i > 5) {
          r = 2;
        }
        if(i == 1 || i == 4 || i == 7) {
          c = 1;
        } else if(i == 2 || i == 5 || i == 8) {
          c = 2;
        }
        if (row.charAt(i) == 'X' || row.charAt(i) == '0'){
          board[r][c] = row.charAt(i);
        } else if (row.charAt(i) == ' '){
          board[r][c] = '#';
        }
      }
      row = fReader.readLine();
    }
    fReader.close();
  }

  void saveFile() throws Exception {
    PrintWriter fWriter = new PrintWriter(new FileWriter("game.txt"));
    for (int i = 0; i < 3; i++){
  		for (int j = 0; j < 3; j++){
  			if (board[i][j] == '#'){
  				fWriter.print(' ');
  			} else {
  				fWriter.print(board[i][j]);
  			}
  		}
    }
    fWriter.close();
  }

  boolean checkInput(int rida, int veerg){
    boolean checkI = false;
    if((rida <= 2 && rida >= 0 && veerg <= 2 && veerg >= 0) &&
      (board[rida][veerg] != 'X' && board[rida][veerg] != '0')){
        checkI = true;
    } else if((rida <= 2 && rida >= 0 && veerg <= 2 && veerg >= 0) &&
      (board[rida][veerg] == 'X' || board[rida][veerg] == '0')){
      System.out.println("Sisestatud asukoht on juba võetud!");
    } else {
      System.out.println("Sisestasid ebasobivad arvud!");
  }
  return checkI;
}

  static void clearScreen() {
      System.out.print("\033[H\033[2J");
      System.out.flush();
      System.out.println("---");
  }
  void wipeFile()throws Exception{
    BufferedReader fReader = new BufferedReader(new FileReader("game.txt"));
    PrintWriter fWriter = new PrintWriter(new FileWriter("game.txt"));
    String row = fReader.readLine();
    while(row != null){
      row.trim();
    }
    fWriter.close();
    fReader.close();
  }
  void printBoard(){
    char[] pBoard = new char[9];
    pBoard[0] = kysi(0, 0);
    pBoard[1] = kysi(0, 1);
    pBoard[2] = kysi(0, 2);
    pBoard[3] = kysi(1, 0);
    pBoard[4] = kysi(1, 1);
    pBoard[5] = kysi(1, 2);
    pBoard[6] = kysi(2, 0);
    pBoard[7] = kysi(2, 1);
    pBoard[8] = kysi(2, 2);
    for(int i = 0; i < pBoard.length; i++){
      if(pBoard[i] != 'X' && pBoard[i] != '0'){
        pBoard[i] = '#';
      }
    }
    System.out.println(pBoard[0] +" "+ pBoard[1] +" "+ pBoard[2]);
    System.out.println(pBoard[3] +" "+ pBoard[4] +" "+ pBoard[5]);
    System.out.println(pBoard[6] +" "+ pBoard[7] +" "+ pBoard[8]);
  }
}
