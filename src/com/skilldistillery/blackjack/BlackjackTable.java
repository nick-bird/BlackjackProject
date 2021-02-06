package com.skilldistillery.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.Card;



public class BlackjackTable {
private Dealer dealer = new Dealer();
private Scanner sc = new Scanner(System.in);
private Player player = new Player();
private boolean roundGoing = true;
private boolean keepHitting = true;
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
		roundGoing = false;
		keepHitting = false;
		
	}
}
	public boolean checkForBlackjack(BlackjackHand hand) {
		if (hand.isBlackjack()) {
			System.out.println("Blackjack!");
			return true;
		}
		else {
			return false;
		}
}
	public void checkForDealerBust(BlackjackHand hand) {
		if (hand.isBust()) {
			System.out.println("The dealer has bust. You win");
			roundGoing = false;
		}
}
	public void checkForDealerBlackJack(BlackjackHand hand) {
		if (hand.isBlackjack()) {
			System.out.println("The dealer has Blackjack");
			roundGoing = false;
		}
	}
public void checkForWin(BlackjackHand hand1, BlackjackHand hand2) {
	if (hand1.getHandValue() > hand2.getHandValue() && hand1.getHandValue() < 22) {
		System.out.println("You have won");
		roundGoing = false;
	}
	else if (hand1.getHandValue() < hand2.getHandValue() && hand2.getHandValue() < 22) {
		System.out.println("The dealer has won");
		roundGoing = false;
	}
}
	
public void playRound() {
	
	while(roundGoing) {
	System.out.println("Welcome to Blackjack! ");
	player.addCard(dealer.dealCard());
	System.out.println("You have drawn: ");
	player.printHand();
	
	dealer.addCard(dealer.dealCard());
	System.out.println("The dealer has drawn: ");
	dealer.printDealerHand();
	
	player.addCard(dealer.dealCard());
	System.out.println("You have drawn: ");
	player.printHand();
	if(checkForBlackjack(player.getHand())) {
		break;
	}
	dealer.addCard(dealer.dealCard());
	System.out.println("The dealer draws a card and places it face down.");
	
//	player.printHand();
//	dealer.printDealerHand();

//	checkForBustOrBlackjack(player.getHand(), dealer.getHand());
	

	
		while(keepHitting) {
		System.out.println("Enter 1 to hit or 0 to stay: ");
		int i = sc.nextInt();
		sc.nextLine();
		if(i == 1) {
		Card newPlayerCard = dealer.dealCard();	
		player.addCard(newPlayerCard);
		System.out.println("You draw a: ");
		System.out.println(newPlayerCard);
		checkForPlayerBust(player.getHand());
		}
		else {
			keepHitting = false;
		}
		}
	if(roundGoing) {
		System.out.println("The dealer flips the facedown card to reveal the hand: ");
		dealer.printDealerHand();
		checkForDealerBlackJack(dealer.getHand());

		while(dealer.dealerHit(dealer.getHand())) {
		System.out.println("The dealer draws a: ");
		Card newDealerCard = dealer.dealCard();	
		dealer.addCard(newDealerCard);
		System.out.println(newDealerCard);
		
		checkForDealerBust(dealer.getHand());
		}
	}
	checkForWin(player.getHand(), dealer.getHand());
}
	
	
}
}
	
	

