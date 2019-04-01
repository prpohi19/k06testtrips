import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FromFile {

    static int size = 3;

    public static void showField(Trips trips){
        char[][] spots = new char[size][size];

        for (int i = 0; i < size; i++){
            for (int y = 0; y < size; y++){
                spots[i][y] = trips.kysi(i, y);
            }
        }

        for (int i = 0; i < size; i++){
            for (int y = 0; y < size; y++){
                if (spots[i][y] != 'X' && spots[i][y] != '0'){
                    spots[i][y] = '_';
                }
            }
        }

        System.out.println(" ");
        for (int i = 0; i < size; i++){
            for (int y = 0; y < size; y++){
                System.out.print(spots[i][y] + " ");
            }
            System.out.println("");
        }
        System.out.println(" ");
    }

    public static void main(String[] args) throws Exception {

        Trips trips = new Trips();

        BufferedReader bufferedReader = new BufferedReader(new FileReader("file.txt")); // failisisu: X0X0X0X0X
        String row = bufferedReader.readLine();

        while (row != null) {
            System.out.println(row);
            trips.alusta(row.charAt(0));
            for (int i = 0; i < size; i++) {
                for (int y = 0; y < size; y++) {
                    trips.paiguta(row.charAt(i + y), i, y);
                    showField(trips);
                    if (trips.kontrolliVoitu() == true){
                        break;
                    }
                }
            }
            row = bufferedReader.readLine();
        }

    }
}
