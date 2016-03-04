package cards;

import java.util.Comparator;

public class CardComparator implements Comparator<Card> {

	@Override
	public int compare(Card card1, Card card2) {
		return card1.getValue() < card2.getValue() ? -1
				: card1.getValue() == card2.getValue() ? 0 : 1;

	}

}
