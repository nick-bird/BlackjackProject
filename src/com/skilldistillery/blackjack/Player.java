package com.skilldistillery.blackjack;

import com.skilldistillery.cards.Card;

public class Player {
private BlackjackHand playerHand = new BlackjackHand();

public void printHand() {
	System.out.println(playerHand.toString());
}

public void addCard(Card card){
	playerHand.addCard(card);
}
public BlackjackHand getHand() {
	return playerHand;
}
}
