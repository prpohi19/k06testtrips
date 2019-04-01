import java.util.Random;

public class Tegevused implements Tripsuliides{


  private static char[][] laud = new char [3][3];

  public char alusta(){
    tyhiLaud();
    Random r = new Random();
    int kesAlustab = r.nextInt(2);
    if(kesAlustab == 0){
		char symbol = 'X';
    return symbol;
	}else{
		char symbol = 'O';
    return symbol;
	 }
  }

  public void tyhiLaud(){
    //loop läbi ridade:
    for(int i = 0; i < 3; i++){
      //loop läbi veergude
      for(int j = 0; j < 3; j++){
        laud[i][j] = '-';
      }
    }
  }

  public void prindiLaud(){
    System.out.println("-------------");
    for(int i = 0; i < 3; i++){
      System.out.print( "| ");
      for(int j = 0; j < 3; j++){
        System.out.print(laud[i][j] + " | ");
      }
      System.out.println();
      System.out.println("-------------");
    }
  }

  public char kelleKord(char symbol){
    char kes = symbol;
	  if (kes == 'X') {
            kes = 'O';
            symbol = kes;
            return symbol;
        }
        else {
            kes = 'X';
            symbol = kes;
            return symbol;
			}
  }

 /*public String kysi(int rida, int veerg){

   System.out.println(kelleKord(alusta()) + ", märgi soovitud asukoht."); // + tegevus.kysi(int rida, int veerg));
   System.out.print("Rida (0-2): ");
   rida = input.nextInt();
   System.out.print("Veerg (0-2): ");
   veerg = input.nextInt();
 }*/

 public void paiguta(char symbol, int rida, int veerg){
   System.out.println("----------");
   for(int i = 0; i < 3; i++){
     System.out.print( "| ");
     for(int j = 0; j < 3; j++){
       if(rida == i && veerg == j){System.out.print(symbol + " | ");}
       else{ System.out.print(laud[i][j] + " | "); }
     }
     System.out.println();
     System.out.println("----------");

     //vaja luua massiiv(3*3 kohta), kuhu salvestuvad symbolid
   }
 }

}
