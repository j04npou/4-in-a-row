import java.util.Scanner;

public class Game {

    private static void menu() {
        Scanner keys = new Scanner(System.in);

        System.out.println("[1] - One player");
        System.out.println("[2] - Two player");
        System.out.println("[0] - To exit");
        String menu = keys.next();
    }

    public static void main(String[] args) {
        menu();
    }
}
