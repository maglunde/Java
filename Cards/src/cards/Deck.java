package cards;

import java.util.Random;

public class Deck {

	private int cardsLeft; 	// Number of cards left in deck
	private Card[] deck;

	public Deck() {
		deck= new Card[52];
		cardsLeft = 52;
		generateDeck();

	}

	private void generateDeck() {
		int position=0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				Card card = new Card(i, j+1);
				deck[position++] = card;
			}
		}

	}
	
	
	public Card dealCard() throws IllegalStateException{
		// Deals the top card
		if(cardsLeft == 0)
			throw new IllegalStateException("No cards left in deck");
		return deck[--cardsLeft];		
	}
	
	public void shuffle() {
		Card temp;
		Random r = new Random();
		int randPos;
		
		for(int i=0; i < cardsLeft;i++) {
			temp = deck[i];
			randPos = r.nextInt(52);
			deck[i] = deck[randPos];
			deck[randPos] = temp;
		}

	}

}
