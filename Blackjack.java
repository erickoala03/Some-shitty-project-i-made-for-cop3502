import java.util.Scanner;
import java.util.Random;

public class BlackJack {

    private static char ch = 'y';


    public static void main(String[] args) {
        P1Random randomGen = new P1Random();
        while ( ch == 'y' ) {
            int game = 1;


            System.out.println("START GAME #" + game);
            Scanner scnr = new Scanner(System.in);
            int apples = randomGen.nextInt(10);

            System.out.println("Your card is a " + apples + "!");

        }



    }
}
