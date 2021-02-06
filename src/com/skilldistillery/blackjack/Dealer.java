package com.skilldistillery.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;
import com.skilldistillery.cards.Hand;

public class Dealer {
	private BlackjackHand dealerHand = new BlackjackHand();
	private Deck deck = new Deck();

	public Card dealCard() {
		Card newCard = deck.dealCard();
		return newCard;
	}

	public boolean dealerHit(BlackjackHand hand) {

		if (hand.getHandValue() < 17 && hand.getHandValue() < 21) {
			return true;
		} else
			return false;
	}

	public void printDealerHand() {

		System.out.println(dealerHand.toString());

	}

	public void addCard(Card card) {
		dealerHand.addCard(card);
	}

	public BlackjackHand getHand() {
		return dealerHand;
	}

}
