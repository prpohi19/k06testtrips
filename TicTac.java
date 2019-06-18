import java.util.Scanner;

public class TicTac {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] board = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };

        drawBoard(board); // Joonista tühi mängulaud
        int row, column; // Kastide koordinaadid
        for (int i = 0; i < 9; i++) { // 9 käiku
            while (true) { // kastide koordinaatide lugemine
                System.out.print("Enter a row (1, 2 or 3) for player " +
                        (i % 2 == 0 ? "X" : "O") + ": ");
                row = input.nextInt() - 1;
                System.out.print("Enter a column (1, 2 or 3) for player " +
                        (i % 2 == 0 ? "X" : "O") + ": ");
                column = input.nextInt() - 1;
                if (board[row][column] != 0) { // 0 denotes vacant cell
                    System.out.println("Row " + row + " and column " + column +
                            " is already occupied, try again");
                }
                else
                    break;
            }

            board[row][column] = (i % 2 == 0) ? 1 : 2;
            drawBoard(board);

            // Loeb kas mängija on käigu lõpus võitnud
            switch (checkGameStatus(board)) {
                case 1:
                    System.out.println("X player won");
                    return; // Terminate program
                case 2:
                    System.out.println("O player won");
                    return;
            }
        }

        // Kui 9 korra pärast kumbki ei ole võitnud
        System.out.println("It's a draw");
    }

    /** Laua visualiseerimine */
    public static void drawBoard(int[][] board) {
        for (int[] row : board) {
            for (int cell : row)
                switch (cell) {
                    case 0:
                        System.out.print("| ");
                        break;
                    case 1:
                        System.out.print("|X");
                        break;
                    case 2:
                        System.out.print("|O");
                        break;
                    default:
                        System.out.println("Wrong element on board");
                        System.exit(1);
                }
            System.out.println("|");
        }
    }

    /** Kontrollib mängu staatust*/
    public static int checkGameStatus(int[][] board) {
        if (isFormLine(board, 1))
            return 1; // Mängija X võitis
        if (isFormLine(board, 2))
            return 2; // Mängija O võitis

        return 0; // mäng jätkub
    }

    /** Kontrolli kas tekib 3ne rida */
    public static boolean isFormLine(int[][] board, int number) {
        boolean lineFormed;

        // Kontrolli ridu
        for (int i = 0; i < board.length; i++) {
            lineFormed = true;
            for (int j = 1; j < board[i].length; j++)
                if (board[i][j - 1] != number || board[i][j] != number)
                    lineFormed = false;
            if (lineFormed)
                return true; // Horisontaalne rida
        }

        // kontrolli veerge
        for (int j = 0; j < board[0].length; j++) {
            lineFormed = true;
            for (int i = 1; i < board.length; i++)
                if (board[i - 1][j] != number || board[i][j] != number)
                    lineFormed = false;
            if (lineFormed)
                return true;
        }

        // kontrolli diagonaali
        lineFormed = true;
        for (int i = 1; i < board.length; i++)
            if (board[i - 1][i - 1] != number || board[i][i] != number)
                lineFormed = false;
        if (lineFormed)
            return true;

        // kontrolli diagonaali
        lineFormed = true;
        for (int i = 1; i < board.length; i++)
            if (board[board.length - i][i - 1] != number ||
                    board[board.length - i - 1][i] != number)
                lineFormed = false;
        if (lineFormed)
            return true;

        return false; // kui ükski joon pole tekkinud
    }
}
