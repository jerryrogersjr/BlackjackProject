package com.skilldistillery.blackjack.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private List<Card> cards;

	public Deck() {
		cards = createDeck();
	}

	public Deck(List<Card> cards) {
		super();
		this.cards = cards;
	}

	public List<Card> createDeck() {
		List<Card> deck = new ArrayList<>();
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				deck.add(new Card(r, s));
			}
		}
		return deck;
	}
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public List<Card> getCards() {
		return cards;
	}

	public int cardsLeftInDeck() { // what is the difference between this and deck size??
		return cards.size();
	}

	public int checkDeckSize() {
		return cards.size();
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}

	public Card dealCard() {

		return cards.remove(0);

	}

}