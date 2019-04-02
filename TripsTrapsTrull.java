import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TripsTrapsTrull {
    static Scanner sisend;
    static String[] laud;
    static String kord;

    public static void main(String[] args) {
        sisend = new Scanner(System.in);
        laud = new String[9];
        kord = "X";
        String v6itja = null;
        populateEmptyBoard();

        System.out.println("Trips traps trull.");
        System.out.println("--------------------------------");
        printLaud();
        System.out.println("X alustab. Tee esimene käik!");

        while (v6itja == null) {
            int numInput;
            try {
                numInput = sisend.nextInt();
                if (!(numInput > 0 && numInput <= 9)) {
                    System.out.println("Selline lahter puudub, sisestage uus number:");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Selline lahter puudub, sisestage uus number:");
                continue;
            }
            if (laud[numInput - 1].equals(String.valueOf(numInput))) {
                laud[numInput - 1] = kord;
                if (kord.equals("X")) {
                    kord = "O";
                } else {
                    kord = "X";
                }
                printLaud();
                v6itja = kontrolliV6itjat();
            } else {
                System.out.println("See lahter on juba valitud, tee uus käik:");
                continue;
            }
        }
        if (v6itja.equalsIgnoreCase("viik")) {
            System.out.println("Mängisite viiki!");
        } else {
            System.out.println("Õnnitlused! " + v6itja + "'on võitnud. ");
        }
    }

    // Võitja kontrollimine
    static String kontrolliV6itjat() {
        for (int a = 0; a < 8; a++) {
            String rida = null;
            switch (a) {
            case 0:
                rida = laud[0] + laud[1] + laud[2];
                break;
            case 1:
                rida = laud[3] + laud[4] + laud[5];
                break;
            case 2:
                rida = laud[6] + laud[7] + laud[8];
                break;
            case 3:
                rida = laud[0] + laud[3] + laud[6];
                break;
            case 4:
                rida = laud[1] + laud[4] + laud[7];
                break;
            case 5:
                rida = laud[2] + laud[5] + laud[8];
                break;
            case 6:
                rida = laud[0] + laud[4] + laud[8];
                break;
            case 7:
                rida = laud[2] + laud[4] + laud[6];
                break;
            }
            if (rida.equals("XXX")) {
                return "X";
            } else if (rida.equals("OOO")) {
                return "O";
            }
        }
        // kontrollib, kas tegemist on viigiga
        for (int a = 0; a < 9; a++) {
            if (Arrays.asList(laud).contains(String.valueOf(a + 1))) {
                break;
            } else if (a == 8)
                return "viik";
        }

        System.out.println(kord + "'i kord; sisesta enda käik (vali number)");
        return null;
    }

    // laua joonistamine
    static void printLaud() {
        System.out.println("/---|---|---\\");
        System.out.println("| " + laud[0] + " | " + laud[1] + " | " + laud[2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + laud[3] + " | " + laud[4] + " | " + laud[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + laud[6] + " | " + laud[7] + " | " + laud[8] + " |");
        System.out.println("/---|---|---\\");
    }

    static void populateEmptyBoard() {
        for (int a = 0; a < 9; a++) {
            laud[a] = String.valueOf(a + 1);
        }
    }
}