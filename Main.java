
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int temp = 0;
        Game Game = new Game();
        int winner = 0;
        Game.start('X');

        while(winner == 0){
            System.out.println("Mängija " + Game.getPlayer() + " kord");
            boolean taken = true;
            Game.renderField();
            System.out.println("Valige koht!");
            while(taken){
                temp = input.nextInt();
                while (temp<1 || temp>9) {
                    System.out.println("Valige numbrite vahel mis on laual jäänud");
                    temp = input.nextInt();
                }
                taken = Game.checkPlacement(temp);
            }
            Game.place(Game.getPlayer(), temp);
            winner = Game.winner();
            Game.tie();

            Game.getTurn();
        }
    }
}
