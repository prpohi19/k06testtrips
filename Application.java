/**
 * Application
 */
public class Application {

    Tripsuliides trips;

    public static void main(String[] args) {
        Application app = new Application();
        app.game();
    }

    private void game() {
        trips = new TripsuMassiiv();
        trips.alusta('0');
        while (true) {
            System.out.print("Vali asukoht X: ");

            System.out.print("Vali asukoht Y: \n");
            printBoard();
            break;
        }
    }

    private void printBoard() {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                System.out.print(" ");
                char player = trips.kysi(x, y);
                System.out.print(player);
                if (x < 2) {
                    System.out.print(" |");
                }

            }

            if (y < 2) {
                System.out.println("\n-----------");
            }
        }
    }
}