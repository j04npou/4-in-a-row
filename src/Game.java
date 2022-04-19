import java.util.Scanner;

public class Game {

    private static void menu() {
        Scanner keys = new Scanner(System.in);

        System.out.println("[1] - One player");
        System.out.println("[2] - Two player");
        System.out.println("[0] - To exit");
        String menu = keys.next();

        if (menu.equals("1")) {
            onePlayerGame();
        }else if (menu.equals("2")) {
            twoPlayerGame();
        }else if (menu.equals("0")) {
            System.exit(0);
        } else {
            System.out.println("⛔ Select one of the indicated options, please. ⛔");
        }
    }

    private static void onePlayerGame() {

    }

    private static void twoPlayerGame() {
        Board twoP = new Board();
        twoP.printBoard();

        int winner = 0;
        int player = 1;
        int column = twoP.askColumn(player);

        while (winner != 0 || column != 0 ) {
            if (twoP.putTile(column-1, player)) {
                twoP.printBoard();

                if (player == 1) {
                    player = 2;
                } else {
                    player = 1;
                }
            } else {
                System.out.println("⛔ This row is full, please select another row. ⛔");
            }
            column = twoP.askColumn(player);
        }
    }

    public static void main(String[] args) {
        while (true) {
            menu();
        }

    }
}