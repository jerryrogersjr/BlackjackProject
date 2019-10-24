package com.skilldistillery.blackjack.game;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.blackjack.common.Card;

public abstract class Hand {

	protected List<Card> cards = new ArrayList<Card>();

	public abstract int getHandValue();

	public void addCard(Card card) {
		this.cards.add(card);
	}

	public void clearHand() {
		cards.clear();
	}

	public String toString() {
		return "cards " + cards;
	}

}
