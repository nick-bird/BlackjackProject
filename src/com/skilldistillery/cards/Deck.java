package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

	private ArrayList<Card> cards = new ArrayList<>();
	private Rank[] ranks = Rank.values();
	private Suit[] suits = Suit.values();

	public Deck() {
		for (Suit suit : suits) {
			for (Rank rank : ranks) {
				cards.add(new Card(suit, rank));
			}
			shuffle();
		}

	}

	public int checkDeckSize() {
		return cards.size();
	}

	public Card dealCard() {
		return cards.remove(0);
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}
}
