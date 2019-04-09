
interface TicTac {
    void start(char symbol);
    void getTurn();
    void place(char symbol, int pos);
    boolean checkPlacement(int pos);
    char getPlayer();
    void renderField();
    int winner();
    int tie();
}
