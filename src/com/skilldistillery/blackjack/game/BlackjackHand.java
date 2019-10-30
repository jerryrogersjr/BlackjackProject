package com.skilldistillery.blackjack.game;

import java.util.List;

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
			System.out.println(player.getHand().getHandValue() + " " + player.getHand() + "\n");
			System.out.println("********** BLACKJACK!!!! **********\n");
			return true;
		
		} else
		return false;
	}

	public boolean isBust(Player player) {
		if (player.getHand().getHandValue() > 21) {
			System.out.println(player.getHand().getHandValue() + " " + player.getHand() + "\n");
			System.out.println("********** BUSTED BUSTER **********");
			return true;
		} else
		return false;
	}
//	public boolean isBlackjack() {
//		boolean blackjack = false;
//		if (getHandValue() == 21) {
//			System.out.println("***Blackjack***");
//			blackjack = true;
//		}
//		return blackjack;
//	} 
//	
//	public boolean isBust() {
//		boolean bust = false;
//		if (getHandValue() > 21) {
//			System.out.println("***Bust***");
//			bust = true;
//		}
//		return bust;
//	}

}
