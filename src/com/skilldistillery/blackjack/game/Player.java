package com.skilldistillery.blackjack.game;

import com.skilldistillery.blackjack.common.Card;

public class Player {

	private BlackjackHand hand = new BlackjackHand();

	public void addCard(Card card) {
		hand.addCard(card);
	}

	public Hand getHand() {
		return hand;
	}

}
