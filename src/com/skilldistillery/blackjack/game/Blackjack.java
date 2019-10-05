package com.skilldistillery.blackjack.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.blackjack.common.Card;
import com.skilldistillery.blackjack.common.Deck;

public class Blackjack {
	public static final int INITIAL_MONEY = 100; // fixed amount
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		Deck deck = new Deck(); // this will call methods from the Deck class
		Blackjack bj = new Blackjack(); // this will call non-static methods from this class
		int money = INITIAL_MONEY;
		deck.createDeck(); 
		bj.betAmount(kb, 100);
//		System.out.println(deck.createDeck());
	}

	public void launchGame() {
		System.out.println("Welcome to Blackjack\n");
		System.out.println("You have: $ ");

	}

	public void player() {

	}

	public void dealer() {

	}

	public boolean hit(Scanner kb) {
		boolean response = false;
		System.out.println();
		System.out.println("You have: ");
		System.out.println("Do you want to hit? (y or n)");
		String hitResponse = kb.next();
		if (hitResponse.indexOf("Y") == 0 || hitResponse.indexOf("y") == 0) {
			response = true;
		} else if (hitResponse.indexOf("N") == 0 || hitResponse.indexOf("n") == 0) {
			response = false;
		} else {
			System.out.println();
			response = false;
		}
		return response;

	}

	public boolean playAgain(Scanner kb, int money) {
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

	public int betAmount(Scanner kb, int money) {
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
