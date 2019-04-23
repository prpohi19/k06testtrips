import java.util.*;

public class Trips {
  static TripsuKlass tripsuKlass = new TripsuKlass();
  public static void main(String[] args)throws Exception{
    Scanner input = new Scanner(System.in);
    boolean check = false;
    boolean winnerExists = false;
    tripsuKlass.wipeFile();
    tripsuKlass.clearScreen();
    System.out.println("Trips Traps Trull");
    System.out.println("---");
    System.out.print("Sisesta symbol(X/0): ");
    String helpStr = input.nextLine();

    while(check != true){
      tripsuKlass.clearScreen();
      if(helpStr.charAt(0) == 'X' || helpStr.charAt(0) == 'x'){
        check = true;
        tripsuKlass.alusta(helpStr.charAt(0));
      } else if(helpStr.charAt(0) == '0'){
        check = true;
        tripsuKlass.alusta(helpStr.charAt(0));
      } else {
        System.out.print("Sisesta symbol(X/0): ");
        helpStr = input.nextLine();
      }
      tripsuKlass.clearScreen();
    }

    tripsuKlass.printBoard();

    while(winnerExists != true){
      char turn = tripsuKlass.kelleKord();
      System.out.println("---");
      System.out.println(turn + " kord käia.");
      System.out.print("Sisesta rida(1-3): ");
      int row = input.nextInt() - 1;
      System.out.print("Sisesta veerg(1-3): ");
      int col = input.nextInt() - 1;
      boolean checkI = tripsuKlass.checkInput(row, col);
      if(checkI){
        tripsuKlass.clearScreen();
        tripsuKlass.paiguta(turn, row, col);
        tripsuKlass.printBoard();
        winnerExists = tripsuKlass.checkLines(turn);
      }
    }
    System.out.println("---");
    System.out.println("Võitis " + tripsuKlass.kelleKord() + "!");
    tripsuKlass.wipeFile();
  }
}
