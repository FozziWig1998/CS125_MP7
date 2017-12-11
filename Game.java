import java.util.ArrayList;

/*
 * this checks if you can slap the pile and does everything that the game should be checking
 */
public class Game {
		/*
		 * ------- everything that happens next only happens until one of the player deck has all of the cards----------
We need a variable that keeps track of turns
The computer starts by placing their first card from their pile to the flipped pile (this removes the card from the player’s pile and adds the card to the flipped pile)//since we do this a lot, this should be a method called flip in the game class
Now call the method from the game class that checks if you can slap;
If true, the computer should wait 2 seconds before “slapping” thus adding the flipped pile to the end of its pile and now the flipped pile has no cards
If false but the player presses the space or presses a key within 5 seconds you do the two for stupid
Then you continue
Next player places their card and we call the the method from the game class that checks if you can slap 
Thats all we should be doing in the loop

		 */
		
		private ArrayList<Card> flippedCards;
		
		public Game(ArrayList<Card> pile) {
			flippedCards = pile;
		}
		//this is a helper function to add all of the cards from the pile to the player 
		//DOES THIS WORKKKKKKKKK OR NAHHHHHHHHH
		public void addAllCards(ArrayList<Card> playerPile) {
			for (int i = 0; i < flippedCards.size(); i++) {
				playerPile.add(i, flippedCards.remove(i));
			}
		}
		
		
		public void addCardToPile(Card newCard, ArrayList<Card> otherPlayer) {
			if (otherPlayer.size() == 0) {
				return;
			}
			flippedCards.add(newCard);
			System.out.println(flippedCards.get(flippedCards.size() - 1).FaceValue() + " of " + flippedCards.get(flippedCards.size() - 1).Suit());
			
			if (newCard.getFaceValue() == 11) {
				flippedCards.add(otherPlayer.remove(otherPlayer.size() - 1));
				System.out.println(flippedCards.get(flippedCards.size() - 1).FaceValue() + " of " + flippedCards.get(flippedCards.size() - 1).Suit());
				//if the next card put down was not a face card
				if (flippedCards.get(flippedCards.size() - 1).getFaceValue() < 11) {
					addAllCards(otherPlayer);
					System.out.println("sorry, a face card wasn't put down, the other player gets the pile");
				}
			}
			if (newCard.getFaceValue() == 12) {
				for (int i = 0; i < 2; i++) {
					flippedCards.add(otherPlayer.remove(otherPlayer.size() - 1));
					System.out.println(flippedCards.get(flippedCards.size() - 1).FaceValue() + " of " + flippedCards.get(flippedCards.size() - 1).Suit());
					if (flippedCards.get(flippedCards.size() - 1).getFaceValue() > 10) {
						return;
					}
				}
				//if the next card put down was not a face card
				if (flippedCards.get(flippedCards.size() - 1).getFaceValue() < 11) {
					addAllCards(otherPlayer);
					System.out.println("sorry, a face card wasn't put down, the other player gets the pile");
				}
			}
			if (newCard.getFaceValue() == 13) {
				for (int i = 0; i < 3; i++) {
					flippedCards.add(otherPlayer.remove(otherPlayer.size() - 1));
					System.out.println(flippedCards.get(flippedCards.size() - 1).FaceValue() + " of " + flippedCards.get(flippedCards.size() - 1).Suit());
					if (flippedCards.get(flippedCards.size() - 1).getFaceValue() > 10) {
						return;
					}
				}
				//if the next card put down was not a face card
				if (flippedCards.get(flippedCards.size() - 1).getFaceValue() < 11) {
					addAllCards(otherPlayer);
					System.out.println("sorry, a face card wasn't put down, the other player gets the pile");
				}	
			}
			if (newCard.getFaceValue() == 14) {
				for (int i = 0; i < 4; i++) {
					flippedCards.add(otherPlayer.remove(otherPlayer.size() - 1));
					System.out.println(flippedCards.get(flippedCards.size() - 1).FaceValue() + " of " + flippedCards.get(flippedCards.size() - 1).Suit());
					if (flippedCards.get(flippedCards.size() - 1).getFaceValue() > 10) {
						return;
					}
				}
				//if the next card put down was not a face card
				if (flippedCards.get(flippedCards.size() - 1).getFaceValue() < 11) {
					addAllCards(otherPlayer);
					System.out.println("sorry, a face card wasn't put down, the other player gets the pile");
				}	
			}
		}
		
		public boolean slap() {
			if (flippedCards.size() > 1) {
				//doubles
				if (flippedCards.get(flippedCards.size() - 1).getFaceValue() == flippedCards.get(flippedCards.size() - 2).getFaceValue()) {
				return true;
				}
			}
			if (flippedCards.size() > 2) {
			//sandwich
				if(flippedCards.get(flippedCards.size() - 1).getFaceValue() == flippedCards.get(flippedCards.size() - 3).getFaceValue()) {
					return true;
				}
				//increments
				else if (flippedCards.get(flippedCards.size() - 1).getFaceValue() == flippedCards.get(flippedCards.size() - 2).getFaceValue() + 1 
						&& flippedCards.get(flippedCards.size() - 2).getFaceValue() == flippedCards.get(flippedCards.size() - 3).getFaceValue() + 1) {
					return true;
				}
				//decrements
				else if (flippedCards.get(flippedCards.size() - 1).getFaceValue() + 1 == flippedCards.get(flippedCards.size() - 2).getFaceValue() 
						&& flippedCards.get(flippedCards.size() - 2).getFaceValue() + 1 == flippedCards.get(flippedCards.size() - 3).getFaceValue()) {
					return true;
				} 
			}
			return false;
		}
		
		public void hand(ArrayList<Card> playerOne) {
			if (this.slap())  {
				for (int i = 0; i < flippedCards.size(); i++) {
					playerOne.add(i, flippedCards.remove(i));
				}
			} else {
				for (int i = 0; i < 2; i++) {
					flippedCards.add(i,playerOne.get(i));
				}
			}
		}
				
}
