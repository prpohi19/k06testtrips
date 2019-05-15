import java.util.Scanner;


public class TripsTraps {
  public static int row, col;
  public static Scanner scan = new Scanner(System.in);
  public static char[][]board= new char[3][3];
  public static char playerTurn='X';

  public static void main(String[]args){
    for(int i=0;i<3;i++){
      for(int j=0; j<3;j++){
        board[i][j]='_';
      }
    }
    Play();
  }
  public static void Play() {

    boolean playing = true;
    System.out.println("Esimese mängija käik: ");
    while (playing){
      System.out.println("\nSisestage rida ning siis veerg ");
      row= scan.nextInt()-1;
      col= scan.nextInt()-1;
      board[row][col]=playerTurn;

      if(GameOver(row,col)){
        playing=false;
        System.out.println("Mäng läbi. Mängija "+ playerTurn + " võidab!");
      }

      PrintBoard();
      if(playerTurn=='X')
        playerTurn='O';
        else
        playerTurn='X';
      if(playerTurn=='X'){
        System.out.println("Esimese mängija käik !");
        } else if (playerTurn =='O'){
        System.out.println("Teise mängija käik ! ");
        }
      }
    }
    public static void PrintBoard(){
      for(int i=0; i<3; i++){
        System.out.println();
        for(int j=0; j<3; j++){
          if(j==0){
            System.out.print("|");
          }
          System.out.print(board[i][j] + " |");
        }
      }
      System.out.println();
    }
    public static boolean GameOver(int move1, int move2){
      if(board[0][move2]==board[1][move2]&& board[0][move2]==board[2][move2])
          return true;
      if(board[move1][0]==board[move1][1]&& board[move1][0]==board[move1][2])
          return true;
      if(board[0][0]==board[1][1]&& board[0][0]==board[2][2]&&board[1][1]!='_')
          return true;
      if(board[0][2]==board[1][1]&& board[0][2]==board[2][0]&&board[1][1]!='_')
          return true;
      return false;
    }
  }
