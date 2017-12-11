import java.util.ArrayList;
import java.util.Scanner;

public class ERStest {
	
	
	private static final String exit = null;

	public static void main(String[] args) {
		
		ArrayList<Card> pile = new ArrayList<Card>(); 
		Game game = new Game(pile);
		Scanner reader = new Scanner(System.in);
		boolean slappable = false;
		String userInput = "";
		ArrayList<Card> playerDeck = new ArrayList<Card>();
		ArrayList<Card> computerDeck = new ArrayList<Card>();
		
		Deck deck = new Deck();
		deck.shuffle();
		for (int i = 0; i < 15; i ++) {
			playerDeck.add(deck.getDeck().get(i));
		}
		for (int j = 15; j < 30; j++) {
			computerDeck.add(deck.getDeck().get(j));
		}
		while(playerDeck.size() > 0 && computerDeck.size() > 0) {
			int turn = 0; // variable to see whos playing, computer = 0, player = 1
			if (turn % 2 == 0) {
				if (slappable) {
					game.hand(computerDeck);
					System.out.println("Computer Slapped deck! Computer wins deck");
				}
				System.out.print("The computer placed a ");
				game.addCardToPile(computerDeck.remove(computerDeck.size() - 1), playerDeck);
				if (pile.get(pile.size() - 1).getFaceValue() > 10) {
					turn--;
				}
				//System.out.println("The computer placed a " + pile.get(pile.size() - 1).FaceValue() + " of " + pile.get(pile.size() - 1).Suit());
				slappable = game.slap();
				turn++;
			}
			if (turn % 2 == 1) {
				//what if the pile is the players?
				if (pile.get(pile.size() - 1).getFaceValue() > 10) {
					game.addAllCards(playerDeck);
				}
				System.out.println("Enter \"f\" to flip a card or \"s\" to slap the current pile");
				userInput = reader.nextLine().toLowerCase();
				if (userInput.equals("s")) {
					game.hand(playerDeck);
					if (slappable) {
						System.out.println("Player wins the deck");
						System.out.print("You placed a ");
						game.addCardToPile(playerDeck.remove(playerDeck.size() - 1), computerDeck);
						if (pile.get(pile.size() - 1).getFaceValue() > 10) {
							turn--;
						}
						//System.out.println("You placed a " + pile.get(pile.size() - 1).FaceValue() + " of " + pile.get(pile.size() - 1).Suit());
						slappable = game.slap();
					} else {
						System.out.println("Stupid! Player loses two cards");
					}
				} else if (slappable) {
					game.hand(computerDeck);
					System.out.println("Computer Slapped deck before you could flip! Computer wins deck");
					slappable = false;
				} else {
					System.out.print("You placed a ");
				game.addCardToPile(playerDeck.remove(playerDeck.size() - 1), computerDeck);
				if (pile.get(pile.size() - 1).getFaceValue() > 10) {
					turn--;
				}
				
				//System.out.println("You placed a " + pile.get(pile.size() - 1).FaceValue() + " of " + pile.get(pile.size() - 1).Suit());
				slappable = game.slap();
				}
				if (turn % 2 == 1) {
				System.out.println("type \"c\" to end your turn and continue or \"s\" to slap");
				userInput = reader.nextLine().toLowerCase();
				if (userInput.equals("s")) {
					game.hand(playerDeck);
					if (slappable) {
						System.out.println("Player wins the deck");
						slappable = false;
					} else {
						System.out.println("Stupid! Player loses two cards");
					}
				turn++;
				} else {
					turn++;
				}
				}
			}
			
			
		}
		if (playerDeck.size() > computerDeck.size()) {
			System.out.println("Player wins!");
			System.exit(0);
		}
		if (playerDeck.size() < 1) {
			System.out.println("Computer wins!");
			System.exit(0);
		}
		else {
			System.out.println("Computer wins!");
			System.exit(0);
		}
		
	}
	

}
