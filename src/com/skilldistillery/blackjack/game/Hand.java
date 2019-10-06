package com.skilldistillery.blackjack.game;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.blackjack.common.Card;

public abstract class Hand {

	protected List<Card> cards;

	public Hand(List<Card> cards) {
		cards = new ArrayList<Card>();
	}

	abstract int getHandValue();

	public void addCard(Card card) {
		cards.add(card);
	}

	public void clearHand() {

	}

	@Override
	public String toString() {
		return "Hand is " + cards;
	}

	public List<Card> getCards() {
		for (Card card : cards) {
			System.out.println(card);
		}
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

}
