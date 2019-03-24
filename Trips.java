public class Trips implements Tripsuliides {
    private char[][] kohad = new char[3][3];
    private char[] symbolid = {'X', '0'};
    private char kord = 'X';

    public void alusta(char symbol) {
        if (new String(symbolid).indexOf(symbol) == -1) { // https://stackoverflow.com/a/18581539
            throw new IllegalArgumentException("See sümbol ei sobi!");
        }
        kord = symbol;
    }

    public char kelleKord() {
        return kord;
    }

    public void paiguta(char symbol, int rida, int veerg) {
        if (kelleKord() == symbol){
            kohad[rida][veerg] = symbol;
        }
        else {
            throw new IllegalArgumentException("Pole selle sümboli kord!");
        }

        // Vaheta korda
        if (kelleKord() == symbolid[0]){
            kord = symbolid[1];
        }
        else if (kelleKord() == symbolid[1]) {
            kord = symbolid[0];
        }
    }

    public char kysi(int rida, int veerg) {
        return kohad[rida][veerg];
    }

    public static boolean kontrolliVoitu(Trips trips) {
        char[] symbls = {'X', '0'};
        boolean isDone = false;

        for(int i = 0; i < symbls.length; i++) {
            if(!isDone) {
                if((trips.kysi(0,0) == symbls[i] && trips.kysi(1,0) == symbls[i] && trips.kysi(2,0) == symbls[i]) || // ülevalt alla 1 tulp
                        (trips.kysi(0,1) == symbls[i] && trips.kysi(1,1) == symbls[i] && trips.kysi(2,1) == symbls[i]) || // ülevalt alla 2 tulp
                        (trips.kysi(0,2) == symbls[i] && trips.kysi(1,2) == symbls[i] && trips.kysi(2,2) == symbls[i]) || // ülevalt alla 3 tulp
                        (trips.kysi(0,0) == symbls[i] && trips.kysi(1,1) == symbls[i] && trips.kysi(2,2) == symbls[i]) || // ülevalt vasakult alla paremale
                        (trips.kysi(0,2) == symbls[i] && trips.kysi(1,1) == symbls[i] && trips.kysi(2,0) == symbls[i]) || // ülevalt paremalt alla vasakule
                        (trips.kysi(0,0) == symbls[i] && trips.kysi(0,1) == symbls[i] && trips.kysi(0,2) == symbls[i]) || // 1. rida
                        (trips.kysi(1,0) == symbls[i] && trips.kysi(1,1) == symbls[i] && trips.kysi(1,2) == symbls[i]) || // 2. rida
                        (trips.kysi(2,0) == symbls[i] && trips.kysi(2,1) == symbls[i] && trips.kysi(2,2) == symbls[i])) { // 2. rida
                    isDone = true;
                    System.out.println("Võitis ["+symbls[i]+"]");
                }
            }
        }

        return isDone;
    }
}
