package com.skilldistillery.blackjack.game;

import com.skilldistillery.blackjack.common.Card;

public class BlackjackHand extends Hand {

	public int getHandValue() {
		int value = 0;
		for (Card card : cards) {
			value += card.getValue();
		}
		return value;
	}

	public boolean isBlackjack(Player player) {
		if (player.getHand().getHandValue() == 21) {
			System.out.println("********** BLACKJACK!!!! **********");
		} 
		return true;
	}

	public boolean isBust(Player player) {
		if (player.getHand().getHandValue() > 21) {
			System.out.println("********** BUSTED BUSTER **********");
			System.out.println(player.getHand().getHandValue() + " " + player.getHand());
		}
		return true;
	}

}
