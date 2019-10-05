package com.skilldistillery.blackjack.game;

import java.util.List;

import com.skilldistillery.blackjack.common.Card;

public class BlackjackHand extends Hand {

	public BlackjackHand(List<Card> cards) {
		super(cards);
	}

	@Override
	int getHandValue() {
		return 0;
	}
	
	public boolean isBlackjack() {
		return true;
	}
	
	public boolean isBust() {
		return true;
	}
	
	

}
