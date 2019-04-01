import java.io.*;
import java.net.*;
import java.util.*;

public class Tripsu{

  public static void main(String[] args) throws Exception{
   Scanner input = new Scanner(System.in);
   Tegevused tegevus = new Tegevused();

   //mängu alustamine
   tegevus.prindiLaud();
   char alusta = tegevus.alusta();
   System.out.println("Algab Trips-Traps-Trull mäng.");
   System.out.println("Alustab " + alusta);

   //kysi ja paiguta while tsükkel
   System.out.println(alusta + ", märgi soovitud asukoht."); // + tegevus.kysi(int rida, int veerg));
   System.out.print("Rida (0-2): ");
   int rida = input.nextInt();
   System.out.print("Veerg (0-2): ");
   int veerg = input.nextInt();
   //tegevus.kysi(rida, veerg); kuidas see ülemine osa funktsiooni sisse saada??
   tegevus.paiguta(alusta, rida, veerg);

   //System.out.println(tegevus.kelleKord(char symbol) + " kord.");
   //repeat
   char kord = tegevus.kelleKord(alusta);
   System.out.println(kord + ", märgi soovitud asukoht."); // + tegevus.kysi(int rida, int veerg));
   System.out.print("Rida (0-2): ");
   rida = input.nextInt();
   System.out.print("Veerg (0-2): ");
   veerg = input.nextInt();
   //tegevus.kysi(rida, veerg); kuidas see ülemine osa funktsiooni sisse saada??
   tegevus.paiguta(kord, rida, veerg);
 }
}
//kasuta clearscreeni
