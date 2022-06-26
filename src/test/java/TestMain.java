import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestMain {
    @ParameterizedTest
    @ValueSource(ints = {3,5,7})
     void testGorizontalIsWin(int arg) {
        char player = 'X';
        char[][] field = new char[arg][arg];
        for (int i = 0; i < arg; i++) {
            field[i][0] = player;
        }
        Assertions.assertTrue(isWin(field,
                player,
                arg));
    }

    @ParameterizedTest
    @ValueSource(ints = {3,5,7})
    void testVerticalIsWin(int arg) {
        char player = 'X';
        char[][] field = new char[arg][arg];
        for (int i = 0; i < arg; i++) {
            field[0][i] = player;
        }
        Assertions.assertTrue(isWin(field,
                player,
                arg));
    }

    @ParameterizedTest
    @ValueSource(ints = {3,5,7})
    void TestLeftDiagonalIsWin(int arg) {
        char player = 'X';
        char[][] field = new char[arg][arg];
        for (int i = 0; i < arg; i++) {
            field[i][i] = player;
        }
        Assertions.assertTrue(isWin(field,
                player,
                arg));
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 5, 7})
    void TestRightDiagonalIsWin(int arg) {
        char player = 'X';
        char[][] field = new char[arg][arg];
        for (int i = 0; i < arg; i++) {
            field[arg-1-i][i] = player;
        }
        Assertions.assertTrue(isWin(field,
                player,
                arg));
    }
    public static boolean isWin(char[][] field, char player,int SIZE) {
        int countWinner = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (field[i][j] == player || field[j][i] == player || field[j][j] == player || field[SIZE-1-j][j] == player) {
                    countWinner++;
                }
            }
            if (countWinner == SIZE){
                return true;
            } else {
                countWinner = 0;
            }
        }
        return false;
    }
}
