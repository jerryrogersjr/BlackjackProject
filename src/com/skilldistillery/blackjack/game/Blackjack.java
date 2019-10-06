package com.skilldistillery.blackjack.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.blackjack.common.Card;
import com.skilldistillery.blackjack.common.Deck;
import com.skilldistillery.blackjack.common.Rank;
import com.skilldistillery.blackjack.common.Suit;

public class Blackjack {
	public static final int INITIAL_MONEY = 100; // fixed amount
	private static int money = INITIAL_MONEY;
	public static Scanner kb = new Scanner(System.in);
	List<Card> dealersHand = new ArrayList<>();
	List<Card> playersHand = new ArrayList<>();
	private Rank rank;
	private Suit suit;
	static Deck deck = new Deck();
	Card c = new Card(rank, suit);

	Dealer dealer = new Dealer();
	Player player = new Player();

	public static void main(String[] args) {
		Blackjack bj = new Blackjack();
		bj.launchGame(bj);
	}

	public void launchGame(Blackjack bj) {

		System.out.println("Welcome to Blackjack\n");
		System.out.println("You have: $ " + money);
		bj.betAmount();
		dealer.Shuffle();
		for (int i = 0; i < 2; i++) {
			player.addCard(dealer.dealerDeck.dealCard());
		}
		System.out.println("Player Hand");
		System.out.println(player.getHand());
		System.out.println(player.getHand().getHandValue());
		System.out.println();

		System.out.println("Dealer Showing ");
		System.out.println(dealer.getHand());
		dealer.addCard(dealer.dealerDeck.dealCard());
		System.out.println();
		
		bj.player();
		bj.dealer();

	}

	int playerTotal = player.getHand().getHandValue();

	public void player() {
		boolean anotherCard = true;
		while (playerTotal < 21 && anotherCard) {
			anotherCard = hit(kb);
			
			if (playerTotal > 21 || playerTotal == 21 || !anotherCard) {
				break;
			} else {
				deck.dealCard();
			}
			for (int i = 0; i < playersHand.size(); i++) {
				if (playersHand.get(i).isAce() && playerTotal > 21) {
					playerTotal -= 10;
				}
			}
		}
	}

	int dealerTotal = 0;

	public void dealer() {
		while (dealerTotal < 17 && playerTotal < 21) {
			System.out.println("Dealer showing " + dealerTotal);
			Card dealersCard = null;

			System.out.println("Dealer gets ");
			System.out.println();
			// show here what the dealer got
			dealerTotal += dealersCard.getValue();
			dealersHand.add(dealersCard);
			for (int i = 0; i < playersHand.size(); i++) {
				if (playersHand.get(i).isAce() && playerTotal > 21) {
					playerTotal -= 10;
				}
			}
		}
		System.out.println();
//		money += winCheck(playerTotal, dealerTotal);
		boolean play = true;
//		play = bj.playAgain();
		playAgain();
	}

	private int winCheck() {
		return 0;
	}

	public boolean hit(Scanner kb) {
		boolean response = false;
		System.out.println();
		System.out.println("You have: ");
		System.out.println(player.getHand().getHandValue());
		System.out.println("Do you want to hit? (y or n)");
		String hitResponse = kb.next();

		if (hitResponse.indexOf("Y") == 0 || hitResponse.indexOf("y") == 0) {
			response = true;
			player.addCard(dealer.dealerDeck.dealCard());
		} else if (hitResponse.indexOf("N") == 0 || hitResponse.indexOf("n") == 0) {
			response = false;
		} else {
			System.out.println();
			response = false;
		}
		return response;

	}

	public boolean playAgain() {
		boolean response;
		System.out.println("You have: $ " + money);
		if (money == 0) {
			System.out.println("You're out of cash. House wins");
			response = false;
			return response;
		}
		System.out.println("Would you like to play again?");
		String response2 = kb.next();
		if (response2.indexOf("Y") == 0 || response2.indexOf("y") == 0) {
			response = true;
			return response;
		} else if (response2.indexOf("N") == 0 || response2.indexOf("n") == 0) {
			response = false;
			if (money > 100) {
				System.out.println("You've won $ " + (money - 100));
			} else {
				System.out.println("You lost a total of $ " + (100 - money));
				return response;
			}
		} else {
			System.out.println();
			response = false;
		}
		return response;
	}

	public int betAmount() {
		System.out.println("How much do you want to bet?");
		int bet = Math.abs(kb.nextInt());
		while (bet > money || bet < 10) {
			if (bet < 10) {
				System.out.println("The minimum bet is $10");
				System.out.println("Thats not enough money");
			}

			else {
				System.out.println("You don't have that much money");
			}
			System.out.println("How much would you like to bet");
			bet = kb.nextInt();
		}
		return bet;
	}

//	public void drawPlayer(Dealer dealer, Player player) {
//		dealer.Shuffle();
//		for (int i = 0; i < 2; i++) {
//			player.addCard(dealer.dealerDeck.dealCard());
//		}
//	}
//
//	public void drawDealer(Dealer dealer, Player player) {
//		dealer.Shuffle();
//		for (int i = 0; i < 1; i++) {
//			player.addCard(dealer.dealerDeck.dealCard());
//		}
//	}

}
