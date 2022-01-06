import java.util.ArrayList;
import java.util.Scanner;



public class DeckOfCardsGame {
    public static final Scanner scanner = new Scanner(System.in);
    public ArrayList<String> cardsDeck = new ArrayList<String>();


    public void welcome() {
        System.out.println("Welcome to the gaming world of Deck of Cards");
    }


    public void deckOfCards() {
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "King", "Queen", "Ace"};
        int numOfCards = suits.length * ranks.length;
        System.out.println("\nNumber of cards in the deck is : " + numOfCards);
        // First we have to itterate for loop for ranks starting from index 0.
        for (int i = 0; i < ranks.length; i++) {
            // Now we have to ittreate the suits for all the indexes of ranks
            for (int j = 0; j < suits.length; j++) {
                cardsDeck.add(ranks[i] + "----->" + suits[j]);
            }
        }
        toDisplay(cardsDeck);
    }


    public static void toDisplay(ArrayList<String> cardsDeck) {
        System.out.println("\nCards in Deck:");
        for (String element : cardsDeck) {
            System.out.println(element);
        }
        System.out.println();
    }


    public void noOfPlayers() {
        System.out.print("\nEnter number of players minimum 2 , maximum 4 : ");
        int player = scanner.nextInt();
        if (player >= 2 && player <= 4) {
            System.out.println("\n" + player + " players will play the game");
            sequenceOfPlay(player);
        } else {
            System.out.println("Please enter number of players in the Range");
            noOfPlayers();
        }
        scanner.close();
    }


    public void sequenceOfPlay(int player) {
        System.out.println("\nSequence of cards are below : ");
        toshuffle(cardsDeck, player);
    }


    public static ArrayList<String> toshuffle(ArrayList<String> cardsDeck, int player) {
        System.out.println("Shuffling the cards before Distribution");
        ArrayList<String> temp = new ArrayList<String>();
        while (!cardsDeck.isEmpty()) {
            int loc = (int) (Math.random() * cardsDeck.size());
            temp.add(cardsDeck.get(loc));
            cardsDeck.remove(loc);
        }
        cardsDeck = temp;
        toDisplay(cardsDeck);
        cardDistribution(cardsDeck, player);
        return cardsDeck;
    }


    public static void cardDistribution(ArrayList<String> cardsDeck, int player) {
        // This loop will itterate for no of players
        for (int i = 0; i < player; i++) {
            System.out.print("\nPlayer " + (i + 1) + " got cards:\n");
            // This loop will itterate for no of cards for each player
            for (int j = 0; j < 9; j++) {
                System.out.print("\t" + cardsDeck.get(i+j*player));
            }
        }
        System.out.println();
    }
}