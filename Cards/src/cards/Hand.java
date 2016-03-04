package cards;

import java.util.ArrayList;

public class Hand {

	private int cardsLeft;
	private Card[] hand;
	
	public Hand(Card[] hand) {
		this.hand = hand;
		this.cardsLeft = hand.length;
	}
	
	

	public Hand(Deck deck, int numCards) {
		this.hand = new Card[numCards];
		
		for (int i = 0; i < numCards; i++) {
			hand[i] = deck.dealCard();
		}
		this.cardsLeft = numCards;
	}

	public void clear() {
		

	}

	public Card playCard(Card card) throws IllegalArgumentException {
		for (int i = 0; i < hand.length; i++)
			if (hand[i] == card) {
				cardsLeft--;
				return card;

			}
		throw new IllegalArgumentException("No such card in hand");
	}

	public Card playCard(int position) throws IllegalArgumentException {
		if(position > cardsLeft) throw new IllegalArgumentException("No card in position "+position);
		Card card = hand[position];
		hand[position] = hand[--cardsLeft];
		return card;

	}
	
	public boolean contains(int value) {
		for(int i=0; i<hand.length;i++) {
			if(hand[i].getValue() == value) return true;
		}
		return false;
	}
	
	public ArrayList<Card> toList(){
		ArrayList<Card> list = new ArrayList<Card>();
		for (int i = 0; i < hand.length; i++) {
			list.add(hand[i]);
		}
		return list;
	}

	public String toString() {
		String str="";
		for(int i=0; i < cardsLeft; i++)
		{
			str += String.valueOf(hand[i]);
			if(i != (cardsLeft-1)) 
				str += "\n"; 
		}
		return str;
		
	}
}
