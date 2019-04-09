import java.io.*;

public class GameFile implements TicTac{

    private   char board[]=new char[10];
    private   char player;
    public    int maxTurns=9;
    public    int currentTurns=1;

    @Override
    public void start(char symbol){
        char posndef[] =  {'0','1', '2', '3', '4', '5', '6', '7', '8', '9'};
        try {
            saveFile(posndef);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            board = readFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        player = symbol;
    }

    @Override
    public void getTurn() {
        currentTurns++;
        if (player == 'X') {
            player = 'O';
        } else {
            player = 'X';
        }
    }

    @Override
    public void place(char symbol, int pos) {
        board[pos] = symbol;
        try {
            saveFile(board);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean checkPlacement(int pos) {
        if (board[pos] == 'X' || board[pos] == 'O')
        {
            System.out.println("Koht on juba võetud, vali uus koht!");
            return true;
        }
        else {
            return false;
        }
    }

    public void renderField() {
        try {
            board = readFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println(board[1] + "   " + board[2] + "   " + board[3]);
        System.out.println();
        System.out.println(board[4] + "   " + board[5] + "   " + board[6]);
        System.out.println();
        System.out.println(board[7] + "   " + board[8] + "   " + board[9]);
        System.out.println();
    }

    public  char getPlayer() {
        return player;
    }

    public int winner(){
        char Winner = ' ';
        int temp = 0;
        try {
            board = readFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Check if X wins
        if (board[1] == 'X' && board[2] == 'X' && board[3] == 'X') Winner = 'X';
        if (board[4] == 'X' && board[5] == 'X' && board[6] == 'X') Winner = 'X';
        if (board[7] == 'X' && board[8] == 'X' && board[9] == 'X') Winner = 'X';
        if (board[1] == 'X' && board[4] == 'X' && board[7] == 'X') Winner = 'X';
        if (board[2] == 'X' && board[5] == 'X' && board[8] == 'X') Winner = 'X';
        if (board[3] == 'X' && board[6] == 'X' && board[9] == 'X') Winner = 'X';
        if (board[1] == 'X' && board[5] == 'X' && board[9] == 'X') Winner = 'X';
        if (board[3] == 'X' && board[5] == 'X' && board[7] == 'X') Winner = 'X';
        if (Winner == 'X' ) {
            System.out.println("X võitis" );
            temp = 1;
        }

        // Check if O wins
        if (board[1] == 'O' && board[2] == 'O' && board[3] == 'O') Winner = 'O';
        if (board[4] == 'O' && board[5] == 'O' && board[6] == 'O') Winner = 'O';
        if (board[7] == 'O' && board[8] == 'O' && board[9] == 'O') Winner = 'O';
        if (board[1] == 'O' && board[4] == 'O' && board[7] == 'O') Winner = 'O';
        if (board[2] == 'O' && board[5] == 'O' && board[8] == 'O') Winner = 'O';
        if (board[3] == 'O' && board[6] == 'O' && board[9] == 'O') Winner = 'O';
        if (board[1] == 'O' && board[5] == 'O' && board[9] == 'O') Winner = 'O';
        if (board[3] == 'O' && board[5] == 'O' && board[7] == 'O') Winner = 'O';
        if (Winner == 'O' ) {
            System.out.println( "O Võitis" );
            temp = 1;
        }

        return temp;
    }

    public int tie(){

        int temp = 0;
        if (currentTurns==maxTurns) {
            System.out.println("Mäng jäi viiki");
            temp = 1;
        }
        return temp;
    }

    //Faili sisse lugemine

    public char[] readFile() throws Exception {
        char temp[] = new char[10];
        BufferedReader reader = new BufferedReader(new FileReader("board.txt"));

        String line = reader.readLine();
        String s = "";
        for(int i = 0; i < 10; i++){
            s = line.split(" ")[i];
            temp[i] = s.charAt(0);
        }
        reader.close();
        return temp;
    }

    public void saveFile(char board[]) throws Exception {
        char temp[] = board;
        BufferedWriter writer = new BufferedWriter(new FileWriter("board.txt"));
        String s = "";
        for(int i = 0; i < temp.length; i++){
                s += temp[i] + " ";
        }
        writer.write(s);
        writer.close();
    }
}
