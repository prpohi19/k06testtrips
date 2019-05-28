import java.util.Scanner;

public class Game {

    static Scanner input;
    //static String[] board;
    static String turn;

    public static void main(String[] args){

        Tegevused tegevus = new Tegevused();
        input = new Scanner(System.in);
        String[] board = new String[9];
        turn = "X";
        int turns = 0;
        String winner;

        tegevus.alusta(board);
        tegevus.printBoard(board);
        System.out.println("X alustab mängu");

        //for(int i = 0; i < 9){

        while(true){
            turns++;
            tegevus.kysi(turn, board);
            tegevus.printBoard(board);
            turn = tegevus.kelleKord(turn);

            winner = tegevus.checkWinner(board, turns);

            if(!winner.equals("")){
                System.out.println(winner + " võitis!!!");
                break;
            }
        }
    }
}