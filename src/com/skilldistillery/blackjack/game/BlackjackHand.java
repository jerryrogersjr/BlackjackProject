package com.skilldistillery.blackjack.game;

import java.util.List;

import com.skilldistillery.blackjack.common.Card;

public class BlackjackHand extends Hand {

	public BlackjackHand(List<Card> cards) {
		super(cards);
	}

	@Override
	int getHandValue() {
		return 0;
	}
	
	public boolean isBlackjack() {
		System.out.println("Blackjack!!!!");
		return true;
	}
	
	public boolean isBust() {
		System.out.println("Busted Buster");
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
