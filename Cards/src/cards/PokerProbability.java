package cards;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PokerProbability {

	public static void main(String[] args) {
		
		int N = 500_000;
		
		calculateHighCardProbability(N);
		calculateOnePairProbability(N);
		calculateTwoPairProbability(N);
		calculateThreeOfAKindProbability(N);
		calculateStraightProbability(N);
		calculateFlushProbability(N);
		calculateFullHouseProbability(N);
		calculateFourOfAKindProbability(N);
		calculateStraightFlushProbability(N);
		calculateRoyalFlushProbability(N);

	}

	public static void calculateHighCardProbability(int numHands) {
		Deck deck;
		Hand hand;
		int numHighCard = 0;

		for (int i = 0; i < numHands; i++) {
			deck = new Deck();
			deck.shuffle();
			hand = new Hand(deck, 5);
			if (isNOfAKind(hand, 1))
				if (!isStraight(hand))
					if (!isFlush(hand))
						numHighCard++;
			if (i % (numHands / 10) == 0)
				System.out.print(".");

		}
		double probabilityHighCard = (double) numHighCard / numHands;
		double percentageHighCard = probabilityHighCard * 100;
		DecimalFormat df = new DecimalFormat("0.00000");
		System.out.println("Chance of High Card: " + df.format(percentageHighCard) + "%");
	}

	public static void calculateOnePairProbability(int numHands) {
		Deck deck;
		Hand hand;
		int numOnePair = 0;

		for (int i = 0; i < numHands; i++) {
			deck = new Deck();
			deck.shuffle();
			hand = new Hand(deck, 5);
			if (isNOfAKind(hand, 2))
				numOnePair++;
			if (i % (numHands / 10) == 0)
				System.out.print(".");

		}
		double probabilityOnePair = (double) numOnePair / numHands;
		double percentageOnePair = probabilityOnePair * 100;
		DecimalFormat df = new DecimalFormat("0.00000");
		System.out.println("Chance of One Pair: " + df.format(percentageOnePair) + "%");
	}

	public static void calculateTwoPairProbability(int numHands) {
		Deck deck;
		Hand hand;
		int numTwoPairs = 0;

		for (int i = 0; i < numHands; i++) {
			deck = new Deck();
			deck.shuffle();
			hand = new Hand(deck, 5);
			if (isTwoPair(hand))
				numTwoPairs++;
			if (i % (numHands / 10) == 0)
				System.out.print(".");

		}
		double probabilityTwoPairs = (double) numTwoPairs / numHands;
		double percentageTwoPairs = probabilityTwoPairs * 100;
		DecimalFormat df = new DecimalFormat("0.00000");
		System.out.println("Chance of Two Pairs: " + df.format(percentageTwoPairs) + "%");
	}

	public static void calculateThreeOfAKindProbability(int numHands) {
		Deck deck;
		Hand hand;
		int ThreeOfAKind = 0;

		for (int i = 0; i < numHands; i++) {
			deck = new Deck();
			deck.shuffle();
			hand = new Hand(deck, 5);
			if (isNOfAKind(hand, 3))
				ThreeOfAKind++;
			if (i % (numHands / 10) == 0)
				System.out.print(".");
		}

		double probabilityThreeOfAKind = (double) ThreeOfAKind / numHands;
		double percentageThreeOfAKind = probabilityThreeOfAKind * 100;
		DecimalFormat df = new DecimalFormat("0.00000");
		System.out.println("Chance of Three Of A Kind: " + df.format(percentageThreeOfAKind) + "%");

	}

	public static void calculateStraightProbability(int numHands) {
		Deck deck;
		Hand hand;
		int numStraights = 0;

		for (int i = 0; i < numHands; i++) {
			deck = new Deck();
			deck.shuffle();
			hand = new Hand(deck, 5);
			if (isStraight(hand))
				if (!isFlush(hand))
					numStraights++;
			if (i % (numHands / 10) == 0)
				System.out.print(".");

		}

		double probabilityStraight = (double) numStraights / numHands;
		double percentageStraight = probabilityStraight * 100;
		DecimalFormat df = new DecimalFormat("0.0000");
		System.out.println("Chance of Straight: " + df.format(percentageStraight) + "%");
	}

	public static void calculateFlushProbability(int numHands) {
		Deck deck;
		Hand hand;
		int numFlushes = 0;

		for (int i = 0; i < numHands; i++) {
			deck = new Deck();
			deck.shuffle();
			hand = new Hand(deck, 5);
			if (isFlush(hand))
				if (!isStraight(hand))
					numFlushes++;
			if (i % (numHands / 10) == 0)
				System.out.print(".");
		}
		double probabilityFlush = (double) numFlushes / numHands;
		double percentageFlush = probabilityFlush * 100;
		DecimalFormat df = new DecimalFormat("0.0000");
		System.out.println("Chance of Flush: " + df.format(percentageFlush) + "%");

	}

	public static void calculateFullHouseProbability(int numHands) {
		Deck deck;
		Hand hand;
		int fullHouse = 0;

		for (int i = 0; i < numHands; i++) {
			deck = new Deck();
			deck.shuffle();
			hand = new Hand(deck, 5);
			if (isFullHouse(hand))
				fullHouse++;
			if (i % (numHands / 10) == 0)
				System.out.print(".");
		}

		double probabilityFullHouse = (double) fullHouse / numHands;
		double percentageFullHouse = probabilityFullHouse * 100;
		DecimalFormat df = new DecimalFormat("0.0000");
		System.out.println("Chance of Full House: " + df.format(percentageFullHouse) + "%");
	}

	public static void calculateFourOfAKindProbability(int numHands) {
		Deck deck;
		Hand hand;
		int FourOfAKind = 0;

		for (int i = 0; i < numHands; i++) {
			deck = new Deck();
			deck.shuffle();
			hand = new Hand(deck, 5);
			if (isNOfAKind(hand, 4))
				FourOfAKind++;
			if (i % (numHands / 10) == 0)
				System.out.print(".");
		}

		double probabilityFourOfAKind = (double) FourOfAKind / numHands;
		double percentageFourOfAKind = probabilityFourOfAKind * 100;
		DecimalFormat df = new DecimalFormat("0.00000");
		System.out.println("Chance of Four Of A Kind: " + df.format(percentageFourOfAKind) + "%");

	}

	public static void calculateStraightFlushProbability(int numHands) {
		Deck deck;
		Hand hand;
		int numStraightFlushes = 0;

		for (int i = 0; i < numHands; i++) {

			deck = new Deck();
			deck.shuffle();
			hand = new Hand(deck, 5);
			if (isFlush(hand) && isStraight(hand) && !isRoyalFlush(hand))
				numStraightFlushes++;

			if (i % (numHands / 10) == 0)
				System.out.print(".");
		}
		double probabilityRoyalFlush = (double) numStraightFlushes / numHands;
		double percentageRoyalFlush = probabilityRoyalFlush * 100;
		DecimalFormat df = new DecimalFormat("0.00000");
		System.out.println("Chance of Straight Flush: " + df.format(percentageRoyalFlush) + "%");

	}

	public static void calculateRoyalFlushProbability(int numHands) {
		Deck deck;
		Hand hand;
		int numRoyals = 0;

		for (int i = 0; i < numHands; i++) {

			deck = new Deck();
			deck.shuffle();
			hand = new Hand(deck, 5);
			if (isRoyalFlush(hand))
				numRoyals++;

			if (i % (numHands / 10) == 0)
				System.out.print(".");
		}
		double probabilityRoyalFlush = (double) numRoyals / numHands;
		double percentageRoyalFlush = probabilityRoyalFlush * 100;
		DecimalFormat df = new DecimalFormat("0.000000");
		System.out.println("Chance of Royal Flush: " + df.format(percentageRoyalFlush) + "%");
	}

	public static boolean isNOfAKind(Hand hand, int n) {
		List<Card> list = hand.toList();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < list.size(); i++) {
			int val = list.get(i).getValue();
			if (map.get(val) != null)
				map.put(val, map.get(val) + 1);
			else
				map.put(val, 1);
		}
		if (n == 1)
			return map.keySet().size() == 5;
		if (n == 2)
			return map.keySet().size() == 4;

		int max = 1, next = 1;

		for (int key : map.keySet()) {
			int count = map.get(key);
			if (count > max) {
				next = max;
				max = count;
			}

		}
		boolean NOfAKind = max == n && next == 1;
		return NOfAKind;

	}

	private static boolean isTwoPair(Hand hand) {
		List<Card> list = hand.toList();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < list.size(); i++) {
			int val = list.get(i).getValue();
			if (map.get(val) != null)
				map.put(val, map.get(val) + 1);
			else
				map.put(val, 1);
		}

		// if (map.keySet().size() != 3)
		// return false;

		int max = 1, next = 1;
		for (int key : map.keySet()) {
			int count = map.get(key);
			if (count >= max) {
				next = max;
				max = count;
			}

		}
		boolean isTwoPair = max == 2 && next == 2;
		return isTwoPair;
	}

	public static boolean isStraight(Hand hand) {
		boolean firstRound = true;
		ArrayList<Card> list = hand.toList();
		list.sort(new CardComparator());
		int value = -1, prev = -1;

		if (list.get(0).getValue() == Card.ACE && list.get(1).getValue() == Card.TEN) {
			return list.get(2).getValue() == Card.JACK && list.get(3).getValue() == Card.QUEEN
					&& list.get(4).getValue() == Card.KING;
		}

		for (Card card : list) {
			if (!firstRound)
				prev = value;
			value = card.getValue();
			if (!firstRound) {
				if (value != (prev + 1))
					return false;
			}
			firstRound = false;
		}

		return true;
	}

	public static boolean isFlush(Hand hand) {
		List<Card> list = hand.toList();
		int suit = list.get(0).getSuit();
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i).getSuit() != suit)
				return false;
		}

		return true;
	}

	public static boolean isRoyalFlush(Hand hand) {
		List<Card> list = hand.toList();
		list.sort(new CardComparator());
		Card first = list.get(0);
		Card second = list.get(1);

		if (first.getValue() != Card.ACE || second.getValue() != Card.TEN)
			return false;

		return isStraight(hand) && isFlush(hand);
	}

	public static boolean isFullHouse(Hand hand) {
		List<Card> list = hand.toList();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < list.size(); i++) {
			int val = list.get(i).getValue();
			if (map.get(val) != null)
				map.put(val, map.get(val) + 1);
			else
				map.put(val, 1);
		}
		int max = 1;

		if (map.keySet().size() != 2)
			return false;

		for (int key : map.keySet()) {
			int count = map.get(key);
			max = Math.max(max, count);

		}
		boolean isFullHouse = max == 3;
		return isFullHouse;

	}
}
