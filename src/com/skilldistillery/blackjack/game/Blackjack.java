package com.skilldistillery.blackjack.game;

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

		// need to work on money minus bet, etc.
		while (playerTotal < 21) {
			System.out.println();
			System.out.println("You have a total of $ " + money);
			System.out.println("You have: " + player.getHand().getHandValue() + " " + player.getHand());
			player.getHand().getHandValue();
			winCheck(bj);
			System.out.println("Do you want to hit? (y or n)");
			String hitResponse = kb.next();
			if (hitResponse.indexOf("N") == 0 || hitResponse.indexOf("n") == 0) {
				dealer(bj);
			}
			if (hitResponse.indexOf("Y") == 0 || hitResponse.indexOf("y") == 0) {
				player.addCard(dealer.dealerDeck.dealCard());
				if (player.getHand().getHandValue() == 21) {
					bh.isBlackjack();
				}
				bj.hit(kb, bj);

			}
		}
	}

	int dealerTotal = dealer.getHand().getHandValue();

	public void dealer(Blackjack bj) {
//		while (dealerTotal < 17 && playerTotal < 21) {
		while (true) {
			if (dealer.getHand().getHandValue() < 17) {

				System.out.println("Dealer showing " + dealer.getHand());
				dealer.addCard(dealer.dealerDeck.dealCard());
				System.out.println();
				System.out.println("Dealer now has " + dealer.getHand().getHandValue() + " " + dealer.getHand());
				System.out.println();
				winCheck(bj);

			}
		}
	}

	public void winCheck(Blackjack bj) {

		if (dealer.getHand().getHandValue() > 17 && dealer.getHand().getHandValue() <= 21
				&& dealer.getHand().getHandValue() > player.getHand().getHandValue()) {
			System.out.println("House Wins!");
			System.exit(0);
		}
		if (dealer.getHand().getHandValue() > 17 && dealer.getHand().getHandValue() < player.getHand().getHandValue()) {
			System.out.println("You Win");
			System.exit(0);
		}
		if (dealer.getHand().getHandValue() == player.getHand().getHandValue()) {
			System.out.println(
					"You and the Dealer tied. This hand was a wash because I'm not at the next step of code yet, sorry!");
			System.exit(0);
		}
		if (dealer.getHand().getHandValue() > player.getHand().getHandValue()) {
			System.out.println("House wins, you lose");
			System.exit(0);
		}
		if (player.getHand().getHandValue() > dealer.getHand().getHandValue() && dealer.getHand().getHandValue() > 17) {
			System.out.println("You Win");
			System.exit(0);
		}
		if (dealer.getHand().getHandValue() > 21) {
			System.out.println("Dealer busts, You Win");
			System.exit(0);
		}
		if (dealer.getHand().getHandValue() == 21) {
			System.out.println("Dealer has Blackjack, you lose");
			System.exit(0);
		}
		if (player.getHand().getHandValue() == 21) {
			System.out.println(bh.isBlackjack());
		}

	}

	public void hit(Scanner kb, Blackjack bj) {

		System.out.println();
		System.out.println("You have: " + player.getHand().getHandValue() + " " + player.getHand());
		if (player.getHand().getHandValue() > 21) {
			System.out.println();
			System.out.println(bh.isBust());
			if (player.getHand().getHandValue() == 21) {
				System.out.println();
				System.out.println(bh.isBlackjack());

			}
			System.out.println("Do you want to hit? (y or n)");
			String hitResponse = kb.next();

			if (hitResponse.indexOf("Y") == 0 || hitResponse.indexOf("y") == 0) {
				player.addCard(dealer.dealerDeck.dealCard());
				winCheck(bj);
				bj.player(bj);
			} else if (hitResponse.indexOf("N") == 0 || hitResponse.indexOf("n") == 0) {
				dealer(bj);
			}
		}
	}
	// playAgain for scaling up
	public void playAgain(Blackjack bj) {
		System.out.println("You have: $ " + money);
		if (money == 0) {
			System.out.println("You're out of cash. House wins");
			System.exit(0);
		}
		System.out.println("Would you like to play again?");
		String response2 = kb.next();
		if (response2.indexOf("Y") == 0 || response2.indexOf("y") == 0) {
			bj.launchGame(bj);
		} else if (response2.indexOf("N") == 0 || response2.indexOf("n") == 0) {
			System.out.println("Goodbye");
			if (money > 100) {
				System.out.println("You've won $ " + (money - 100));
			} else {
				System.out.println("You lost a total of $ " + (100 - money));
				System.exit(0);
			}
		} else {
			System.err.println("Wrong Input, Try Again");
			System.exit(0);
		}

	}

	public int betAmount() {
		System.out.println("How much do you want to bet?");
//		int bet = Math.abs(kb.nextInt());
		int bet = kb.nextInt();

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
