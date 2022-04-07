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
    }

    public static void main(String[] args) {
        while (true) {
            menu();
        }

    }
}