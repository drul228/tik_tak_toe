import java.util.Scanner;

public class Main {
    public static final int SIZE = 5;
    public static final char EMPTY = '-';
    public static final char CROSS = 'X';
    public static final char ZERO = 'O';

    public static void main(String[] args) {
        char[][] field = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                field[i][j] = EMPTY;
            }
        }

        Scanner scanner = new Scanner(System.in);

        boolean isCrossTurn = true;

        while (true) {
            printField(field);
            int r = 0, c = 0;
            System.out.println("Ходят " + (isCrossTurn ? "крестики" : "нолики") + "!");
            try {
                String input = scanner.nextLine(); // "2 3"
                String[] parts = input.split(" "); // ["2" , "3"]
                r = Integer.parseInt(parts[0]) - 1; // 2-1 = 1
                c = Integer.parseInt(parts[1]) - 1;
                if (field[r][c] != EMPTY) {
                    System.out.println("Сюда ходить нельзя");
                    continue;
                }

                field[r][c] = isCrossTurn ? CROSS : ZERO;
                if (isWin(field, isCrossTurn ? CROSS : ZERO)) {
                    printField(field);
                    System.out.println("Победили " + (isCrossTurn ? "крестики" : "нолики"));
                    break;
                } else {
                    if (isCrossTurn) {
                        isCrossTurn = false;
                    } else {
                        isCrossTurn = true;
                    }
                    //isCrossTurn = !isCrossTurn;
                }
            } catch (Exception e) {
                e.getMessage();
            }
        }

        System.out.println("Игра закончена!");
    }

    // !!ВНИМАНИЕ!!
    // Работает только для 3x3
    // Этот метод вам и надо переписать
    public static boolean isWin(char[][] field, char player) {
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

    public static void printField(char[][] field) {
        for (char[] row : field) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}