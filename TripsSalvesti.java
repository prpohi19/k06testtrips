import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class TripsSalvesti {

    public TripsSalvesti(String... input) throws Exception {
        if (input.length != 0){
            quicksaveToFile(input[0]);
        }
    }

    public void quicksaveToFile(String input) throws Exception {
        char[] temp = new char[input.length()];

        for (int i = 0; i < input.length(); i++){
            temp[i] = input.charAt(i);
        }

        saveToFile(temp);
    }

    public char[] loadFromFile(char[] spots) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("file.txt"));
        String row = bufferedReader.readLine();

        while (row != null) {
            System.out.println(row);

            for (int i = 0; i < row.length(); i++) {
                if (row.charAt(i) == 'X' || row.charAt(i) == '0'){
                    spots[i] = row.charAt(i);
                } else if (row.charAt(i) == ' '){
                    spots[i] = '_';
                }
            }
            row = bufferedReader.readLine();
        }

        return spots;
    }

    public void saveToFile(char[] spots) throws Exception{
        PrintWriter writer = new PrintWriter(new FileWriter("file.txt"));

        for (char c : spots){
            if (c == '_'){
                writer.print(' ');
            } else {
                writer.print(c);
            }
        }

        writer.close();
    }
}
