package com.skilldistillery.blackjack.game;

import java.util.List;

import com.skilldistillery.blackjack.common.Card;

public class BlackjackHand extends Hand {

	public int getHandValue() {
		int value = 0;
		for (Card card : cards) {
			value += card.getValue();
		}
		return value;
	}

	public boolean isBlackjack() {
		if(getHandValue() == 21) {
		System.out.println("********** BLACKJACK!!!! **********");
		System.out.println();
		}

		return true;
	}

	public boolean isBust() {
		if (getHandValue() > 21) {
			System.out.println("********** BUSTED BUSTER **********");
		}
		return true;
	}

}
