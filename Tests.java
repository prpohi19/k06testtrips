import org.junit.Test;
import static org.junit.Assert.*;

public class Tests {
    Game Testing = new Game();
    GameFile TestingFile = new GameFile();

    @Test
    public void test1() {
        Testing.start('O');
        Testing.place(Testing.getPlayer(), 1);
        Testing.getTurn();
        Testing.place(Testing.getPlayer(), 2);
        Testing.getTurn();
        Testing.place(Testing.getPlayer(), 4);
        Testing.getTurn();
        Testing.place(Testing.getPlayer(), 3);
        Testing.getTurn();
        Testing.place(Testing.getPlayer(), 7);
        assertEquals(1, Testing.winner());
    }

    @Test
    public void test2(){
        Testing.start('X');
        Testing.place(Testing.getPlayer(), 1);
        Testing.getTurn();
        Testing.place(Testing.getPlayer(), 3);
        Testing.getTurn();
        Testing.place(Testing.getPlayer(), 2);
        Testing.getTurn();
        Testing.place(Testing.getPlayer(), 5);
        Testing.getTurn();
        Testing.place(Testing.getPlayer(), 4);
        Testing.getTurn();
        Testing.place(Testing.getPlayer(), 6);
        Testing.getTurn();
        Testing.place(Testing.getPlayer(), 9);
        Testing.getTurn();
        Testing.place(Testing.getPlayer(), 8);
        Testing.getTurn();
        Testing.place(Testing.getPlayer(), 7);
        assertEquals(1, Testing.tie());
    }

    @Test
    public void test3(){
        Testing.start('O');
        assertEquals('O', Testing.getPlayer());
        Testing.place(Testing.getPlayer(), 1);
        Testing.getTurn();
        assertEquals('X', Testing.getPlayer());
    }

    @Test
    public void test4() {
        char temp[] = new char[10];
        TestingFile.start('O');
        TestingFile.place(TestingFile.getPlayer(), 2);
        try {
            temp = TestingFile.readFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals('O', temp[2]);
    }

    @Test
    public void test5() {
        TestingFile.start('O');
        TestingFile.place(TestingFile.getPlayer(), 1);
        TestingFile.getTurn();
        TestingFile.place(TestingFile.getPlayer(), 2);
        TestingFile.getTurn();
        TestingFile.place(TestingFile.getPlayer(), 4);
        TestingFile.getTurn();
        TestingFile.place(TestingFile.getPlayer(), 3);
        TestingFile.getTurn();
        TestingFile.place(TestingFile.getPlayer(), 7);
        assertEquals(1, TestingFile.winner());
    }
}
