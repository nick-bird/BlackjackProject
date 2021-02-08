package com.skilldistillery.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.Card;

public class BlackjackTable {
	private Dealer dealer = new Dealer();
	private static Scanner sc = new Scanner(System.in);
	private Player player = new Player();
	private boolean roundGoing = true;
	private boolean keepHitting = true;

	public boolean checkForPlayerBust(BlackjackHand hand) {
		if (hand.isBust()) {
			System.out.println("You have gone bust");
			roundGoing = false;
			keepHitting = false;
			return true;

		} else {
			return false;
		}
	}

	public boolean checkForBlackjack(BlackjackHand hand) {
		if (hand.isBlackjack()) {
			System.out.println("Blackjack!");
			return true;
		} else {
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
		} else if (hand1.getHandValue() <= hand2.getHandValue() && hand2.getHandValue() < 22) {
			System.out.println("The dealer has won");
			roundGoing = false;
		}
	}

	public void playRound() {

		while (roundGoing) {
			player.addCard(dealer.dealCard());
			System.out.println("You have drawn: ");
			player.printHand();

			dealer.addCard(dealer.dealCard());
			System.out.println("The dealer has drawn: ");
			dealer.printDealerHand();

			player.addCard(dealer.dealCard());
			System.out.println("You have drawn: ");
			player.printHand();
			if (checkForBlackjack(player.getHand())) {
				break;
			}
			if (checkForPlayerBust(player.getHand())) {
				break;
			}
			dealer.addCard(dealer.dealCard());
			System.out.println("The dealer draws a card and places it face down.");

			while (keepHitting) {
				System.out.println("Enter 1 to hit or 0 to stay: ");
				int i = sc.nextInt();
				sc.nextLine();
				if (i == 1) {
					Card newPlayerCard = dealer.dealCard();
					player.addCard(newPlayerCard);
					System.out.println("You draw a: ");
					System.out.println(newPlayerCard);
					checkForPlayerBust(player.getHand());
				} else {
					keepHitting = false;
				}
			}
			if (roundGoing) {
				System.out.println("The dealer flips the facedown card to reveal the hand: ");
				dealer.printDealerHand();

				while (dealer.dealerHit(dealer.getHand())) {
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

	public static void main(String[] args) {

		System.out.println("Welcome to Blackjack! ");
		boolean keepGame = true;
		while (keepGame) {
			BlackjackTable bjt = new BlackjackTable();
			bjt.playRound();
			System.out.println("Would you like to play again? Type yes or no");

			String answer = sc.nextLine();
			if (answer.equals("no")) {
				break;
			}

		}
	}
}
