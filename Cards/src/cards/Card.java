package cards;

public class Card {
	private int suit, value;
	private String stringSuit, stringValue;
	
	public static final int ACE 	= 1;
	public static final int TWO		= 2;
	public static final int THREE 	= 3;
	public static final int FOUR	= 4;
	public static final int FIVE	= 5;
	public static final int SIX		= 6;
	public static final int SEVEN	= 7;
	public static final int EIGHT 	= 8;
	public static final int NINE 	= 9;
	public static final int TEN		= 10;
	public static final int JACK	= 11;
	public static final int QUEEN	= 12;
	public static final int KING	= 13;
	
	
	public Card(int suit, int value) {
		this.value = value;
		this.suit = suit;
		getStringValue();
		getStringSuit();
	}
	
	

	public int getSuit() {
		return suit;
	}



	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}



	private void getStringSuit() {
		switch (suit) {
		case 0:
			stringSuit = "Clubs";
			break;
		case 1:
			stringSuit = "Diamonds";
			break;
		case 2:
			stringSuit = "Hearts";
			break;
		case 3:
			stringSuit = "Spades";
			break;
		default:
			stringSuit = "IllegalSuit";
		}
	}

	private void getStringValue() {
		switch (value) {
		case ACE:
			stringValue = "Ace";
			break;
		case TWO:
			stringValue = "Two";
			break;
		case THREE:
			stringValue = "Three";
			break;
		case FOUR:
			stringValue = "Four";
			break;
		case FIVE:
			stringValue = "Five";
			break;
		case SIX:
			stringValue = "Six";
			break;
		case SEVEN:
			stringValue = "Seven";
			break;
		case EIGHT:
			stringValue = "Eight";
			break;
		case NINE:
			stringValue = "Nine";
			break;
		case TEN:
			stringValue = "Ten";
			break;
		case JACK:
			stringValue = "Jack";
			break;
		case QUEEN:
			stringValue = "Queen";
			break;
		case KING:
			stringValue = "King";
			break;
		default:
			stringValue = "IllegalValue";
		}

	}

	public String toString() {
		return stringValue + " of " + stringSuit;
	}
}
