import java.util.Scanner;

/**
 * Application
 */
public class Application {

    private Tripsuliides trips;
    private Scanner reader;

    public Application() {
        reader = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.game();
    }

    private int askPosition(String message) {
        while (true) {
            System.out.println(message);
            int n = reader.nextInt();
            if (n < 1 || n > 3) {
                System.out.println("Sisesta arv 1-3.");
            } else {
                return n - 1;
            }
        }
    }

    private void game() {
        trips = new TripsuMassiiv();
        trips.alusta('0');
        while (true) {
            System.out.println("Mängija " + trips.kelleKord() + "");
            while (true) {
                int x = askPosition("Vali rida: (1-3)");
                int y = askPosition("Vali veerg: (1-3)");
                if (trips.paiguta(x, y)) {
                    break;
                } else {
                    System.out.println("Sisestatud koht on juba valitud!");
                }
            }
            
            printBoard();
            if (checkGameStatus()) {
                System.out.println("Kas soovid uuesti mängida? [ y / n ]");
                char temp = reader.next().charAt(0);
                if (temp == 'y' && temp == 'Y') {
                    trips.alusta('0');
                } else {
                    break;
                }
            }
        }
    }

    private boolean checkGameStatus() {

        for (int i = 0; i < 3; i++) { // check rows
            if (trips.kysi(i, 0) != ' ' && trips.kysi(i, 0) == trips.kysi(i, 1) && trips.kysi(i, 1) == trips.kysi(i, 2)) {
                System.out.println(trips.kysi(i, 0) + " võitis mängu!");
                return true;
            }
        }

        for (int i = 0; i < 3; i++) { // check columns
            if (trips.kysi(0, i) != ' ' && trips.kysi(0, i) == trips.kysi(1, i) && trips.kysi(1, i) == trips.kysi(2, i)) {
                System.out.println(trips.kysi(0, 1) + " võitis mängu!");
                return true;
            }
        }

        // check diagonals
        if (trips.kysi(1, 1) != ' ') {
            if (trips.kysi(0, 0) == trips.kysi(1, 1) && trips.kysi(1, 1) == trips.kysi(2, 2)) {
                System.out.println(trips.kysi(0, 0) + " võitis mängu!");
                return true;
            }
            if (trips.kysi(0, 2) == trips.kysi(1, 1) && trips.kysi(1, 1) == trips.kysi(2, 0)) {
                System.out.println(trips.kysi(0, 2) + " võitis mängu!");
                return true;
            }
        }
        return false;
    }

    private void printBoard() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                System.out.print(" ");
                char player = trips.kysi(x, y);
                System.out.print(player);
                if (y < 2) {
                    System.out.print(" |");
                }

            }

            if (x < 2) {
                System.out.println("\n-----------");
            }
        }
        System.out.println();
    }
}