import java.util.Scanner;

public class Program{
  public static void main(String[] args){
      Trips laud = new Trips();
      int rida;
      int veerg;
      Scanner reader = new Scanner(System.in);
      laud.alusta('X');
      System.out.println("Mängu alustab " + laud.kelleKord());

      while(laud.running){
        System.out.println("Sisesta rida: ");
        rida = Integer.parseInt(reader.nextLine());
        System.out.println("Sisesta veerg: ");
        veerg = Integer.parseInt(reader.nextLine());
        System.out.println();
        laud.paiguta(rida,veerg);
        laud.salvesta(rida,veerg);
      }


      //System.out.println(laud.kelleKord());
      }
}
