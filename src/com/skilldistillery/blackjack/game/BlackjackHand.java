package com.skilldistillery.blackjack.game;

import java.util.List;

import com.skilldistillery.blackjack.common.Card;

public class BlackjackHand extends Hand {

	@Override
	public void addCard(Card card) {
		super.addCard(card);
	}

	@Override
	public void clearHand() {
		super.clearHand();
	}

	@Override
	public List<Card> getCards() {
		return super.getCards();
	}

	@Override
	public String toString() {
		return super.toString();
	}

	public boolean isBlackjack() {
		System.out.println("Blackjack!!!!");
		System.out.println();
		System.exit(0);
		
		return true;
	}

	public boolean isBust() {
		System.out.println("Busted Buster");
		System.exit(0);
		return true;
	}

	public boolean isHard() {
		System.out.println("Hard Ace 11");
		return true;
	}

	public boolean isSoft() {
		System.out.println("Soft Ace 1");
		return true;
	}

}
