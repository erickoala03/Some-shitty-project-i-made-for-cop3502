import java.util.Scanner; // allows input
import java.text.DecimalFormat; // allows me to format the percentage decimal

public class Blackjack {

/*
This method printjob allows me to minimize the repetitive print statements.
 */
    private static void printjob() {
               System.out.println("1. Get another card" );
        System.out.println("2. Hold hand" );
        System.out.println("3. Print statistics");
        System.out.println("4. Exit");
        System.out.println("Choose an option: \n " );
            }

   public static void main(String[] args) {
       boolean gameon = true; // allows my program to continue if boolean is false it turns off
       int hand = 0;
       int card ;
       int option;
       int numwins = 0;
       int dealerswins = 0;
       int numties = 0;
       int dealerhand;
       String percent;
       int game = 1;
        Scanner scnr = new Scanner(System.in);
        P1Random Rng = new P1Random();
       DecimalFormat rate = new DecimalFormat( "0.0"); //to get my percent it will always give me the first decimal
       System.out.println("START GAME #" + game);

       card = Rng.nextInt(13)+1 ;
       hand = getCard(hand, card);
       printjob(); /* In line 31 - 34 I need to have those code in order to reach the the while statement. I could have done
       a do statement. But I liked doing it like this more.*/

       option = scnr.nextInt(); /*my scnr function is ver useful in order to option go through every switch statement and
       prevent infinite loops
*/

             while( gameon) { //the while has gameon which is true until option 4. So it will always goes through the switch statement.

                 switch(option) {  // This allows me to pick my options.

                    case 1: // the case one simply allows the player to draw the card
                        card = Rng.nextInt(13)+1 ;
                        hand = getCard(hand, card);

if (hand > 21) /* This right here allows me to made sure the player loses when they overreach a new game. */
{
  System.out.println(" You exceeded 21! You lose.");
  dealerswins++;
    game++;
    System.out.println("START GAME #" + game );
    hand = 0;
    card = Rng.nextInt(13)+1 ;
    hand = getCard(hand, card);
    printjob();
    option = scnr.nextInt();
    }
/* The code here allows me to win is the game gives me total of 21 and then starts a new game.*/
else if  ( hand == 21)
{ System.out.println("BLACKJACK! You win!");
    numwins++;
    game++;
    System.out.println("START GAME #" + game );
    hand = 0;
    card = Rng.nextInt(13)+1 ;
    hand = getCard(hand, card);
    printjob();
    option = scnr.nextInt();
}

                        else {
    printjob();
    option = scnr.nextInt();
                         }
                        break;
                    case 2:
                        dealerhand = Rng.nextInt(11) + 16; //This is here because I will be using at for setting up the first assigned dealer's hand.
System.out.println("Dealer's hand:" + dealerhand);
System.out.println("Your hand is: " + hand);
/* The case 2 is simple as choosing makes the user ends their game. */
        if (dealerhand > 21) {
            System.out.println("You win!");
            numwins++;
        }
        else if (dealerhand == hand) {
        System.out.println(" It's a tie! No one wins!") ;
        numties++;
        }
        else if ( dealerhand > hand) {
            System.out.println("Dealer wins!");
            dealerswins++;
        }
else {
    System.out.println(" You win!");
    numwins++;
        }
/* The lines 102 - 109 allows me to start a new game when the user selects the second option.
* It resets the hand and gets the next card assigned number and also enters back into the switch statement.*/
                    game++;
                    System.out.println("START GAME #" + game) ;
                    hand = 0;
                        card = Rng.nextInt(13)+1 ;
                    hand = getCard(hand, card);
                    printjob();
                        option = scnr.nextInt();

break;
/* case 3 allows me to do the calculations when option 3 is pressed. I created no total games as I believe you could just calculate that
adding up every win or tie.
* */
                   case 3:
                       System.out.println("Number of Player wins: " + numwins);
            System.out.println("Number of Dealer wins: " + dealerswins);
            System.out.println("Number of tie games: " + numties);
            System.out.println("Total # of games played is: " + (numties + dealerswins + numwins)); // I simply didn't use total games. I just added all wins and ties.
            percent =  rate.format( (double) numwins / (numties + dealerswins + numwins) * 100); //rate format allows the percentage to round to first decimal
            System.out.println("Percentage of Player wins: " + percent + "%");
                   printjob();
                       option = scnr.nextInt();
                       break;



                   case 4: //turns off my game. Nothing more nothing less.
                       gameon = false;
             break;

                    default:
                       System.out.println("Invalid input! \n  Please enter an integer value between 1 and 4.");
                       printjob();
                       option = scnr.nextInt();
                        break; /* any number that isn't 1-4 will lead to default and prompts the user to type those desired numbers*/}
}
    }
/*
The method below allowed me to my lines to shorter and efficient.
I now only have to access the next "random integer" before I call this method to draw a another card.
*/
    private static int getCard(int hand, int card) {
        if (card == 1 ) {
            System.out.println("Your card is a ACE! ");
            hand++;        }

        else if ( card > 1 & card < 10)  {
            System.out.println("Your card is a " + card + "!" );
            hand = card + hand;

        }
        else if (card == 11 ) {
            System.out.println("Your card is a JOKER!");
            hand = 10 + hand;
        }

        else if (card == 12) {
            System.out.println("Your card is a QUEEN!");
            hand = 10 + hand;
        }

        else   {
            System.out.println("Your card is a KING!");
            hand = 10 + hand;
        }
        System.out.println("Your hand is: " + hand);
        return hand;

    }


}