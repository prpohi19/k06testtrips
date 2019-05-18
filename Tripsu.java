import java.io.*;
import java.net.*;
import java.util.*;

public class Tripsu {

  public static void main(String[] args) throws Exception {
    Tegevused tegevus = new Tegevused();
    String[] laud = new String[9];
    String v6itja = null;
    //String v6itja = null;


    // mängu alustamine
    String kord = tegevus.alusta(laud);
    tegevus.paiguta(laud);
    System.out.println(kord + " alustab.");
    
    // kysi ja paiguta tsükkel
    for(int i = 0; i < laud.length; i++){ //5
      tegevus.kysi(kord, laud);
      tegevus.paiguta(laud);
      kord = tegevus.kelleKord(kord);
      
      v6itja = tegevus.kontrolliV6itjat(laud);

      if (!v6itja.equals("")) {
        System.out.println(v6itja + " võitis.");
        break;
      }
    }
}
}
