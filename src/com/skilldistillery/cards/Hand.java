package com.skilldistillery.cards;

import java.util.ArrayList;

public abstract class Hand {

	protected ArrayList<Card> hand;

	public Hand() {
		hand = new ArrayList<Card>();
	}

	public void addCard(Card card) {
		hand.add(card);
	}

	public void remove() {
		hand.removeAll(hand);
	}

	public abstract int getHandValue();

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Card card : hand) {
			sb.append(card.toString() + " ");
		}
		return sb.toString();
	}

	public String printCard(int i) {
		return hand.get(i).toString();
	}

}
