package com.skilldistillery.blackjack.game;

import com.skilldistillery.blackjack.common.Deck;

public class Dealer extends Player {

	Deck dealerDeck = new Deck();

	public void Shuffle() {
		dealerDeck.shuffle();
	}

	public Deck getDeck() {
		return dealerDeck;
	}

//	protected void setDeck(Deck deck) {
//		deck = dealerDeck;
//	}

}
