import java.util.Random;
import java.io.*;
import java.net.*;
import java.util.*;

public class Tegevused implements Tripsuliides {

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
  public String kontrolliV6itjat(String[] laud) {
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

    return "";
    
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
