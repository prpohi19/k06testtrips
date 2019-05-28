import java.util.Scanner;

public class Tegevused implements Tripsuliides {

    public String alusta(String[] board){
        System.out.println("Game begins !");

        for (int i = 0; i < 9; i++) {
            board[i] = String.valueOf(i + 1);
        }
        return "";
    }


    public String kelleKord(String turn){
        if (turn.equals("X")){
            turn = "O";
            return turn;
        } else {
            turn = "X";
            return turn;
        }
    }

    public String checkWinner(String[] board, int turns) {
        for (int a = 0; a < 8; a++) {
            String row = null;
            switch (a) {
                case 0:
                    row = board[0] + board[1] + board[2];
                    break;
                case 1:
                    row = board[3] + board[4] + board[5];
                    break;
                case 2:
                    row = board[6] + board[7] + board[8];
                    break;
                case 3:
                    row = board[0] + board[3] + board[6];
                    break;
                case 4:
                    row = board[1] + board[4] + board[7];
                    break;
                case 5:
                    row = board[2] + board[5] + board[8];
                    break;
                case 6:
                    row = board[0] + board[4] + board[8];
                    break;
                case 7:
                    row = board[2] + board[4] + board[6];
                    break;
            }
            if (row.equals("XXX")) {
                return "X";
            } else if (row.equals("OOO")) {
                return "O";
            } else if (turns==9){
                return "Draw";
            }
        }

        return "";

    }


    public String[] kysi(String turn, String[] board ){
        Scanner input = new Scanner(System.in);
        System.out.println(turn + ", märgi soovitud asukoht.");
        int number = input.nextInt();
        board[number - 1] = turn;
        return board;
    }


    public boolean printBoard(String[] laud){
        System.out.println("/---|---|---\\");
        System.out.println("| " + laud[0] + " | " + laud[1] + " | " + laud[2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + laud[3] + " | " + laud[4] + " | " + laud[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + laud[6] + " | " + laud[7] + " | " + laud[8] + " |");
        System.out.println("/---|---|---\\");
        return true;
    }

}