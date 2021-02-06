package com.skilldistillery.blackjack;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Hand;

public class BlackjackHand extends Hand {

	
	
	
	public BlackjackHand() {
		super();
	}

	@Override
	public int getHandValue() {
	int handValue = 0;
		for (Card card : hand) {
			handValue += card.getValue();
		}
		
		return handValue;
	}

public boolean isBlackjack() {
	if(getHandValue() == 21) {
		return true;
	}
	else {
		return false;
	}
}
	
	public boolean isBust() {
		
		if(getHandValue() > 21) {
			return true;
		}
		else {
			return false;
		}
	}
}

