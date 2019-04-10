package tund7_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class TripsSalvesti implements Tripsuliides {
    private static int size = 3;
    private char[][] spots = new char[size][size];
    private char[] symbls = {'X', '0'};
    private char whosTurn = 'X';

    public TripsSalvesti(String... input) throws Exception {
        if (input.length != 0){
            quicksaveToFile(input[0]);
        }
    }

    private void quicksaveToFile(String input) throws Exception {
        int counter = 0;
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                spots[i][j] = input.charAt(counter);
                counter += 1;
            }
        }

        saveToFile();
    }

    public void loadFromFile() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("file.txt"));
        String row = bufferedReader.readLine();

        int counter = 0;
        while (row != null) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (row.charAt(counter) == 'X' || row.charAt(counter) == '0') {
                        spots[i][j] = row.charAt(counter);
                    } else if (row.charAt(counter) == ' ') {
                        spots[i][j] = '_';
                    }
                    counter += 1;
                }
            }
            row = bufferedReader.readLine();
        }
    }

    public void saveToFile() throws Exception {
        PrintWriter writer = new PrintWriter(new FileWriter("file.txt"));

        for (int i = 0; i < 3; i++){
            for (int ii = 0; ii < 3; ii++){
                if (spots[i][ii] == '_'){
                    writer.print(' ');
                } else {
                    writer.print(spots[i][ii]);
                }
            }
        }

        writer.close();
    }

    public void alusta(char symbol) {
        if (new String(symbls).indexOf(symbol) == -1) { // https://stackoverflow.com/a/18581539
            throw new IllegalArgumentException("See sümbol ei sobi!");
        }
        whosTurn = symbol;
    }

    public char kelleKord() {
        return whosTurn;
    }

    public void paiguta(char symbol, int rida, int veerg) throws Exception {
        loadFromFile();

        if (kelleKord() == symbol){
            spots[rida][veerg] = symbol;
        }
        else {
            throw new IllegalArgumentException("Pole selle sümboli kord!");
        }

        if (kelleKord() == symbls[0]){
            whosTurn = symbls[1];
        }
        else if (kelleKord() == symbls[1]) {
            whosTurn = symbls[0];
        }
        saveToFile();
    }

    public char kysi(int rida, int veerg) {
        return spots[rida][veerg];
    }

    public boolean kontrolliVoitu() throws Exception {
        loadFromFile();
        boolean isDone = false;

        for (char c : symbls) {
            if ((kysi(0, 0) == c && kysi(1, 0) == c && kysi(2, 0) == c) || // ülevalt alla 1 tulp
                    (kysi(0, 1) == c && kysi(1, 1) == c && kysi(2, 1) == c) || // ülevalt alla 2 tulp
                    (kysi(0, 2) == c && kysi(1, 2) == c && kysi(2, 2) == c) || // ülevalt alla 3 tulp
                    (kysi(0, 0) == c && kysi(1, 1) == c && kysi(2, 2) == c) || // ülevalt vasakult alla paremale
                    (kysi(0, 2) == c && kysi(1, 1) == c && kysi(2, 0) == c) || // ülevalt paremalt alla vasakule
                    (kysi(0, 0) == c && kysi(0, 1) == c && kysi(0, 2) == c) || // 1. rida
                    (kysi(1, 0) == c && kysi(1, 1) == c && kysi(1, 2) == c) || // 2. rida
                    (kysi(2, 0) == c && kysi(2, 1) == c && kysi(2, 2) == c)) { // 2. rida
                isDone = true;
                System.out.println("Võitis [" + c + "]");
                break;
            }
        }

        return isDone;
    }
}
