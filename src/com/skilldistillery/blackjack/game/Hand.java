package com.skilldistillery.blackjack.game;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.blackjack.common.Card;
import com.skilldistillery.blackjack.common.Deck;

public abstract class Hand {

	protected List<Card> cards = new ArrayList<Card>();

	public Hand() {
		super();
	}

	public int getHandValue() {
		int value = 0;
		for (Card card : cards) {
			value += card.getValue();
		}
		return value;
	}

	public void addCard(Card card) {
		this.cards.add(card);
	}

	public void clearHand() {
		cards.clear();
	}

	public String toString() {
		return "Hand is " + cards;
	}

	public List<Card> getCards() {
		return cards;

	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

}
