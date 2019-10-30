package com.skilldistillery.blackjack.game;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.blackjack.common.Card;

public abstract class Hand {

	protected List<Card> cards = new ArrayList<Card>();
	

	public abstract int getHandValue();

	protected void addCard(Card card) {
		this.cards.add(card);
	}

	protected void clearHand() {
		cards.clear();
	}

	public String toString() {
		return "with cards " + cards;
	}

}
