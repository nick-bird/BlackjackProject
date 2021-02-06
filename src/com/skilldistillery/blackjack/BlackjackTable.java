package com.skilldistillery.blackjack;

import com.skilldistillery.cards.Deck;

public class BlackjackTable {
private Dealer dealer = new Dealer();

private Player player = new Player();
private boolean roundGoing = true;

public void checkForBustOrBlackjack(BlackjackHand hand1, BlackjackHand hand2) {
	if (hand1.isBust()) {
		System.out.println("You have gone bust");
		roundGoing = false;
	}
	if (hand2.isBust()) {
		System.out.println("The dealer has bust. You win");
		roundGoing = false;
	}
	if (hand1.isBlackjack()) {
		System.out.println("Blackjack!");
		roundGoing = false;
	}
	if (hand2.isBlackjack()) {
		System.out.println("The dealer has Blackjack");
		roundGoing = false;
	}
}

public void checkForPlayerBust(BlackjackHand hand) {
	if (hand.isBust()) {
		System.out.println("You have gone bust");
	}
}
	public void checkForDealerBust(BlackjackHand hand) {
		if (hand.isBust()) {
			System.out.println("The dealer has bust. You win");
		}
}
public void checkForWin(BlackjackHand hand1, BlackjackHand hand2) {
	if (hand1.getHandValue() > hand2.getHandValue()) {
		System.out.println("You have won");
	}
	else if (hand1.getHandValue() < hand2.getHandValue()) {
		System.out.println("The dealer has won");
	}
}
	
public void playRound() {
	System.out.println("Welcome to Blackjack: ");
	player.addCard(dealer.dealCard());
	player.printHand();
	dealer.addCard(dealer.dealCard());
	dealer.printDealerHand();
	
	player.addCard(dealer.dealCard());
	player.printHand();
	dealer.addCard(dealer.dealCard());
	dealer.printDealerHand();
	
//	player.printHand();
//	dealer.printDealerHand();

	checkForBustOrBlackjack(player.getHand(), dealer.getHand());

	if(roundGoing) {
	while(dealer.playerHit()) {
		player.addCard(dealer.dealCard());
		player.printHand();
		checkForPlayerBust(player.getHand());
	}
	while(dealer.dealerHit(dealer.getHand())) {
		dealer.addCard(dealer.dealCard());
		dealer.printDealerHand();
		checkForDealerBust(dealer.getHand());
	}
	checkForWin(player.getHand(), dealer.getHand());
}
	
	
}
	
	
}
