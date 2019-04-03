public class Trips implements Tripsuliides {
        private char[][] board = new char[3][3];
        private char[] dataChar = new char[9];
        private String[] dataInt = new String[9];
        private char turn;
        private char turnHelp;
        private int datac = 0;
        private int datai = 0;
        public boolean running = true;
        public boolean status = true;

        public void alusta(char symbol){
            this.turn=symbol;
        }
	public char kysi(int rida, int veerg){
	    return board[rida][veerg];
	}
        public char kelleKord(){
            return turn;
        }
        public void paiguta(int rida, int veerg){
            if(board[rida-1][veerg-1] != 'X' && board[rida-1][veerg-1] != '0'){
            board[rida-1][veerg-1] = turn;
            for(int i= 0; i<3; i++){
                for(int j= 0; j<3; j++) {
                        System.out.format("%-4s", board[i][j]);
                    }
                    System.out.println();
                }
                kontroll();
            if(turn == 'X'){
                turn = '0';
                turnHelp = 'X';
            } else {
                turn = 'X';
                turnHelp = '0';
            }
            if(status == false){
              System.out.println(kelleKord()+"-i kord");
              System.out.println("---");
            }

          } else {
            System.out.println("See ruut on juba võetud, vali uus!");
          }
        }
        public boolean kontroll(){
          boolean status = true;
          //reakontroll
          for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
              if(board[i][j]!=turn){
                status = false;
                break;
              }
            }
            if(status){
              System.out.println(turn+ " võitis!");
              running = false;
              return true;

            } else if(i<3) {
              status = true;
            }
          }
          //veerukontroll
          for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
              if(board[j][i]!=turn){
                status = false;
                break;
              }
            }
            if(status){
              System.out.println(turn+ " võitis!");
              running = false;
              return true;

            } else if(i<3) {
              status = true;
            }
          }
          //diagonaalid
          for(int i = 0; i<3; i++){
            if(board[i][i]!=turn){
              status = false;
              break;
            }
          }
          if(status){
            System.out.println(turn+ " võitis!");
            running = false;
            return true;
          }else{
          status = true;
          }
          int i = 0;
          int j = 2;
          while(i<3){
            if(board[j][i]!=turn){
              status = false;
              break;
            }
            i++;
            j--;
          }
          if(status){
            System.out.println(turn+ " võitis!");
            running = false;
            return true;
          }
          return false;
        }

        // Joonistab mängulaua.
        //public void joonista(){
        //  for (int rida = 0; rida < 3; rida++){
        // WORK IN PROGRESS!
        //  }
        //}

        //Salvestamine
        public void salvesta(int rida, int veerg){
          dataChar[datac] = turnHelp;
          //System.out.println(dataChar[datac]);
          datac++;
          dataInt[datai] = rida + " " + veerg;
          //System.out.println(dataInt[datai]);
          datai++;

        }
      }
