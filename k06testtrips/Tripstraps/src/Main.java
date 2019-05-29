import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        TripsTraps tripsTraps = new TripsTraps();

        tripsTraps.alusta('X');
        tripsTraps.kelleKord();
        tripsTraps.paiguta(tripsTraps.kelleKord(), 3, 3);
        tripsTraps.kysi(3, 3);
        tripsTraps.printBoard();
        tripsTraps.paiguta(tripsTraps.kelleKord(), 2, 1);
        tripsTraps.printBoard();
        tripsTraps.paiguta(tripsTraps.kelleKord(), 3, 2);
        tripsTraps.printBoard();

    }
}
