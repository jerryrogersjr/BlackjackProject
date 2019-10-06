package com.skilldistillery.blackjack.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.blackjack.common.Deck;

public class Blackjack {
	public static final int INITIAL_MONEY = 100; // fixed amount
	private static int money = INITIAL_MONEY;
	public static Scanner kb = new Scanner(System.in);
//	List<Card> dealersHand = new ArrayList<>();
//	List<Card> playersHand = new ArrayList<>();
	Deck deck = new Deck();
	Dealer dealer = new Dealer();
	Player player = new Player();
	BlackjackHand bh = new BlackjackHand();

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

		if (playerTotal == 21) {
			bh.isBlackjack();
		}

		System.out.println("Dealer Showing ");
		System.out.println(dealer.getHand());
		dealer.addCard(dealer.dealerDeck.dealCard());
		System.out.println();

		bj.player(bj);

	}

	int playerTotal = player.getHand().getHandValue();

	public void player(Blackjack bj) {

		if (playerTotal < 21) {
			System.out.println();
			System.out.println("You have: " + player.getHand().getHandValue() + " " + player.getHand());
			System.out.println("Do you want to hit? (y or n)");
			String hitResponse = kb.next();
			if (hitResponse.indexOf("N") == 0 || hitResponse.indexOf("n") == 0) {
				dealer(bj);
			}
			if (hitResponse.indexOf("Y") == 0 || hitResponse.indexOf("y") == 0) {
				player.addCard(dealer.dealerDeck.dealCard());
				bj.hit(kb, bj);

			}
		}
	}

	int dealerTotal = dealer.getHand().getHandValue();

	public void dealer(Blackjack bj) {
		while (dealerTotal < 17 && playerTotal < 21) {
			System.out.println("Dealer showing " + dealer.getHand());
			dealer.addCard(dealer.dealerDeck.dealCard());
			System.out.println("Dealer gets ");
			System.out.println(dealer.getHand());
			System.out.println();
			break;
		}
		System.out.println();

	}

	private int winCheck() {

		int winLose = 0;

		return winLose;
	}

	public void hit(Scanner kb, Blackjack bj) {

		System.out.println();
		System.out.println("You have: " + player.getHand().getHandValue() + " " + player.getHand());
		if (player.getHand().getHandValue() > 21) {
			System.out.println();
			bh.isBust();
		} else if (player.getHand().getHandValue() == 21) {
			System.out.println();
			bh.isBlackjack();
		}
		System.out.println("Do you want to hit? (y or n)");
		String hitResponse = kb.next();

		if (hitResponse.indexOf("Y") == 0 || hitResponse.indexOf("y") == 0) {
			player.addCard(dealer.dealerDeck.dealCard());

		} else if (hitResponse.indexOf("N") == 0 || hitResponse.indexOf("n") == 0) {
			dealer(bj);
		}

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

}
