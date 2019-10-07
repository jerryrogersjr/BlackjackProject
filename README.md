## Blackjack Project

This is my fourth end of week project with Skill Distillery. The program will
welcome you and ask what you'd like to bet with a starting amount of $100.
NOTE: At this moment, I have not implemented the money calculations.
      This will be updated in the near future. Also, the Ace is fixed at '11'
      for the moment. This will also be given the chance to be 'soft' or 'hard'
      ace in the near future.

Then the game will go on with given cards and give you the chance to 'hit' or
'stand' to receive another card or move on in the play.

Example:

```
Welcome to Blackjack

You have: $ 100
How much do you want to bet?
10
Player Hand
hand [JACK of Spades, NINE of Clubs]
19

Dealer Showing
hand []


You have a total of $ 100
You have: 19 hand [JACK of Spades, NINE of Clubs]
Do you want to hit? (y or n)
n
Dealer showing hand [NINE of Hearts]

Dealer now has 20 hand [NINE of Hearts, ACE of Hearts]

House Wins!
```
### Overview

User Story #1
Create a class structure that mimics a deck of cards. Remember decks as well as hands are made up of cards. Feel free to create the structure in any way you see fit.

Your card and deck implementations should NOT be coupled to Blackjack; you should be able to reuse them to implement a poker or bridge game application.

User Story #2
Add methods and fields to your classes that mimic the functionality of shuffling and dealing a deck of cards. Remember that when a card is dealt you have to remove it from the current deck. You should be able to print out a shuffled deck to the terminal.

User Story #3
Deal two hands of cards - one to a Dealer and another to a Player. Allow the players to Hit (add cards to their hand) or Stay (not add cards to their hand) in accordance to the rules of blackjack shown in the wiki.

Do not worry about the multiple values for Ace until your basic game logic is working. Assume they are either 1 or 11 to start.

User Story #4
The Dealer's decisions are based on game logic in the program.

The Dealer must decide to Hit or Stay based on the rules of Blackjack: if the Dealer's hand total is below 17, the Dealer must Hit; if the hand total is 17 or above, the Dealer must Stay.

User Story #5
Determine the winner of each round by implementing the remaining rules of Blackjack (such as going over 21) and comparing hand values.

### How to Run

How to Run
Assuming you have Java already loaded on your machine:

Fancy editor (eclipse):

Load package, file, open, navigate to the file(s), and open. Run as java file and get results, etc.

### Technologies/Topics (I) Used
-MacBook Pro -java version "1.8.0_221" -terminal -iTerm2 -Eclipse -Atom

Getting comfortable building classes in an Object-Oriented manner.
Building classes whose fields are Objects.
Practice writing methods.
Use collection types to organize and manage data.
Use conditionals to create game logic.

### Lessons Learned

Again, I feel like I'm definitely learning Java the hard way. I wish I could give
a specific right now but I can't. I started the code and my biggest challenge
was working with dealing the hands of cards with value, etc. OO stuff, basiclally.
Once this was obtain, I ended up with a lot of extra code, so as I went along I cleaned up and streamlined.
Then it got down to the Dealer and Player functioning properly. Mostly the dealer.
I'll say, this was a lot of practice at java. I had to work hard with lots of
time, but forward movement is underway.
s
### Project Requirements

The program must NOT be contained in one procedural main(). You MUST design a OO class structure.

When the game begins both the player and dealer are dealt two cards.

If a player or dealer is dealt 21 the game is over. Otherwise the player can choose to hit as many times as they wish until they choose to stay.

Once the player has completed their turn the dealer will begin their turn, automatically hitting or staying according to the Blackjack rules.

The game is immediately over if either player gets above 21.

The winner is displayed.

To turn in a project, you must push it to Github. You must include a README.md that describes how to run your program and an overview of the class structure you chose to use.
