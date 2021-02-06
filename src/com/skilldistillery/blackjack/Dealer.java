package com.skilldistillery.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;
import com.skilldistillery.cards.Hand;

public class Dealer {
	private BlackjackHand dealerHand = new BlackjackHand();
	 Scanner sc = new Scanner(System.in);
	private Deck deck = new Deck();
	private boolean waitingForPlayer = true;

	public Card dealCard() {
		Card newCard =	deck.dealCard();
		return newCard;
	}

	public boolean playerHit() {
		System.out.println("Enter 1 to hit or 0 to stay.");
		int i = sc.nextInt();
		sc.nextLine();
		if (i == 1) {
			return true;
		} else {
			waitingForPlayer = false;
			return false;
		}
	}

	public boolean dealerHit(BlackjackHand hand) {

		if (hand.getHandValue() < 17) {
			return true;
		} else
			return false;
	}

	public void printDealerHand() {
		if (dealerHand.isBlackjack()) {
			System.out.println(dealerHand.toString());
		}
		else if (waitingForPlayer) {
			System.out.println(dealerHand.printCard(0) + " X of X");
		} else {
			System.out.println(dealerHand.toString());
		}
	}
	public void addCard(Card card){
		dealerHand.addCard(card);
	}
	
public BlackjackHand getHand() {
	return dealerHand;
}

}