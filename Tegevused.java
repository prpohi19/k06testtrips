import java.util.Random;
import java.io.*;
import java.net.*;
import java.util.*;

public class Tegevused implements Tripsuliides{

  public String alusta(String[] laud){
    Random r = new Random();
    System.out.println("Algab Trips-Traps-Trull mäng.");

    // täidame laua numbritega:
    for (int i = 0; i < 9; i++) {
        laud[i] = String.valueOf(i + 1);
    }

    //randomiga otsustatakse kes alustab
    int kesAlustab = r.nextInt(2);
    if(kesAlustab == 0){
		String kord = "X";
    return kord;
	}else{
		String kord = "O";
    return kord;
	 }
  }


  public String kelleKord(String kord){

    if (kord.equals("X")) {
        kord = "O";
        return kord;
    } else {
        kord = "X";
        return kord;
    }
  }

 public String[] kysi(String kord, String[] laud ){
   Scanner sisend = new Scanner(System.in);
   System.out.println(kord + ", märgi soovitud asukoht.");
   int number = sisend.nextInt();
   laud[number - 1] = kord;
   return laud;
 }



 public boolean paiguta(String[] laud){
     System.out.println("/---|---|---\\");
     System.out.println("| " + laud[0] + " | " + laud[1] + " | " + laud[2] + " |");
     System.out.println("|-----------|");
     System.out.println("| " + laud[3] + " | " + laud[4] + " | " + laud[5] + " |");
     System.out.println("|-----------|");
     System.out.println("| " + laud[6] + " | " + laud[7] + " | " + laud[8] + " |");
     System.out.println("/---|---|---\\");
     return true;
   }

}
